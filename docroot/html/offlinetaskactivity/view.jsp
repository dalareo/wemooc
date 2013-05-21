<%@page import="com.liferay.lms.service.LearningActivityTryLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.LearningActivityTry"%>
<%@page import="com.liferay.lms.service.LearningActivityResultLocalServiceUtil"%>
<%@page import="com.liferay.lms.service.LearningActivityLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.LearningActivity"%>
<%@page import="com.liferay.portal.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.model.RoleConstants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.dao.orm.CustomSQLParam"%>
<%@page import="com.liferay.lms.model.LearningActivityResult"%>
<%@page import="com.liferay.lms.model.Course"%>
<%@page import="com.liferay.lms.OfflineActivity"%>
<%@page import="com.liferay.lms.service.CourseLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.comparator.UserFirstNameComparator"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<%
	long actId = ParamUtil.getLong(request,"actId",0);
	
	if(actId==0)
	{
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.FALSE);
	}
	else
	{
		Course course=CourseLocalServiceUtil.fetchByGroupCreatedId(themeDisplay.getScopeGroupId());
		LearningActivity activity = LearningActivityLocalServiceUtil.getLearningActivity(actId);
		long typeId=activity.getTypeId();
		
		boolean isOffline = activity.getTypeId() == 5;
		
		LearningActivityResult result = LearningActivityResultLocalServiceUtil.getByActIdAndUserId(actId, themeDisplay.getUserId());
		Object  [] arguments=null;
		
		if(result!=null){	
			arguments =  new Object[]{result.getResult()};
		}
		
		if(typeId==5&&(!LearningActivityLocalServiceUtil.islocked(actId,themeDisplay.getUserId())||
				permissionChecker.hasPermission(
				activity.getGroupId(),
				LearningActivity.class.getName(),
				actId, ActionKeys.UPDATE)||permissionChecker.hasPermission(course.getGroupId(),  Course.class.getName(),course.getCourseId(),"ACCESSLOCK")))
		{

			
			boolean isTeacher=false;
					
			for(Role role : RoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId(), themeDisplay.getScopeGroupId())){
				if("courseTeacher".equals(role.getName())) {
					isTeacher=true;
					break;
				}
			}
				
			if(isTeacher==false){
				for(Role role : themeDisplay.getUser().getRoles()){
					if(RoleConstants.ADMINISTRATOR.equals(role.getName())) {
						isTeacher=true;
						break;
					}
				}
			}
		%>

			<div class="offlinetaskactivity view">

				<h2><%=activity.getTitle(themeDisplay.getLocale()) %></h2>
										
				<% if(isTeacher){ %>
				
				<liferay-portlet:resourceURL var="exportURL" >
					<portlet:param name="action" value="export"/>
					<portlet:param name="resId" value="<%=String.valueOf(activity.getActId()) %>"/>
				</liferay-portlet:resourceURL>
				<liferay-ui:icon image="export" label="<%= true %>" message="offlinetaskactivity.csv.export" method="get" url="<%=exportURL%>" />
	
							
				<portlet:renderURL var="viewUrlPopImportGrades" windowState="<%= LiferayWindowState.POP_UP.toString() %>">   
					<portlet:param name="actId" value="<%=String.valueOf(activity.getActId()) %>" />      
		            <portlet:param name="jspPage" value="/html/offlinetaskactivity/popups/importGrades.jsp" />           
		        </portlet:renderURL>
		        
				<portlet:renderURL var="viewUrlPopGrades" windowState="<%= LiferayWindowState.POP_UP.toString() %>">   
					<portlet:param name="actId" value="<%=String.valueOf(activity.getActId()) %>" />      
		            <portlet:param name="jspPage" value="/html/offlinetaskactivity/popups/grades.jsp" />           
		        </portlet:renderURL>
		        
		        <portlet:renderURL var="setGradesURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">   
					<portlet:param name="actId" value="<%=String.valueOf(activity.getActId()) %>" /> 
					<portlet:param name="ajaxAction" value="setGrades" />      
		            <portlet:param name="jspPage" value="/html/offlinetaskactivity/popups/grades.jsp" />           
		        </portlet:renderURL>

				<script type="text/javascript">
			    <!--


				    function <portlet:namespace />showPopupImportGrades()
				    {
						AUI().use('aui-dialog','liferay-portlet-url','event', function(A){
							window.<portlet:namespace />popupImportGrades = new A.Dialog({
								id:'<portlet:namespace />showPopupImportGrades',
					            title: '<liferay-message key="offlinetaskactivity.import.grades" />',
						    	centered: true,
					            modal: true,
					            width: 450,
					            height: 220,
					            after: {   
						          	close: function(event){ 
						          		document.getElementById('<portlet:namespace />studentsearch').submit();
					            	}
					            }
					        }).plug(A.Plugin.IO, {
					            uri: '<%= viewUrlPopImportGrades %>'
					        }).render();
							window.<portlet:namespace />popupImportGrades.show();   
						});
				    }

				    function <portlet:namespace />doClosePopupImportGrades()
				    {
				        AUI().use('aui-dialog', function(A) {
				        	window.<portlet:namespace />popupImportGrades.close();
				        });
				    }


				    function <portlet:namespace />doImportGrades()
				    {
						var importGradesDIV=document.getElementById('<portlet:namespace />import_frame').
											contentDocument.getElementById('<portlet:namespace />importErrors');
						if(importGradesDIV){
							document.getElementById('<portlet:namespace />importErrors').innerHTML=importGradesDIV.innerHTML;
						}
						else {
							document.getElementById('<portlet:namespace />importErrors').innerHTML='';
						}
				    }


				    function <portlet:namespace />showPopupGrades(studentId)
				    {

						AUI().use('aui-dialog','liferay-portlet-url', function(A){
							var renderUrl = Liferay.PortletURL.createRenderURL();							
							renderUrl.setWindowState('<%= LiferayWindowState.POP_UP.toString() %>');
							renderUrl.setPortletId('<%=portletDisplay.getId()%>');
							renderUrl.setParameter('actId', '<%=String.valueOf(activity.getActId()) %>');
							renderUrl.setParameter('studentId', studentId);
							renderUrl.setParameter('jspPage', '/html/offlinetaskactivity/popups/grades.jsp');

							window.<portlet:namespace />popupGrades = new A.Dialog({
								id:'<portlet:namespace />showPopupGrades',
					            title: '<%=LanguageUtil.format(pageContext, "offlinetaskactivity.set.grades", new Object[]{""})%>',
					            centered: true,
					            modal: true,
					            width: 470,
					            height: 400,
					            after: {   
						          	close: function(event){ 
						          		document.getElementById('<portlet:namespace />studentsearch').submit();
					            	}
					            }
					        }).plug(A.Plugin.IO, {
					            uri: renderUrl.toString(),
					            parseContent: true
					        }).render();
							window.<portlet:namespace />popupGrades.show();   
						});
				    }

				    function <portlet:namespace />doClosePopupGrades()
				    {
				        AUI().use('aui-dialog', function(A) {
				        	window.<portlet:namespace />popupGrades.close();
				        });
				    }

				    function <portlet:namespace />doSaveGrades()
				    {
				        AUI().use('aui-io-request','io-form', function(A) {
				            A.io.request('<%= setGradesURL %>', { 
				                method : 'POST', 
				                form: {
				                    id: '<portlet:namespace />fn_grades'
				                },
				                dataType : 'html', 
				                on : { 
				                    success : function() { 
				                    	A.one('.aui-dialog-bd form').set('innerHTML',A.Node.create('<div>'+this.get('responseData')+'</div>').one('form').get('innerHTML'));	
				                    	createValidator();			                    	
				                    } 
				                } 
				            });
				        });
				    }
			
				    //-->
				</script>

				<liferay-ui:icon
				image="add"
				label="<%= true %>"
				message="offlinetaskactivity.import.grades"
				url='<%="javascript:"+renderResponse.getNamespace() + "showPopupImportGrades();" %>'
				/>
				<% } %>
				<h5><liferay-ui:message key="offlinetaskactivity.description" />  </h5>
				<p><%=activity.getDescription(themeDisplay.getLocale()) %></p>
				
				
				<% if(isTeacher){ 
					String criteria = request.getParameter("criteria");
					String gradeFilter = request.getParameter("gradeFilter");

					if (criteria == null) criteria = "";	
					if (gradeFilter == null) gradeFilter = "";	
					
					PortletURL portletURL = renderResponse.createRenderURL();
					portletURL.setParameter("jspPage","/html/offlinetaskactivity/view.jsp");
					portletURL.setParameter("criteria", criteria); 
					portletURL.setParameter("gradeFilter", gradeFilter);
				
				%>
				
				<liferay-portlet:renderURL var="returnurl" />
				
				<h5><liferay-ui:message key="studentsearch"/></h5>
				<aui:form name="studentsearch" action="<%=returnurl %>" method="post">
					<aui:fieldset>
						<aui:column>
							<aui:input label="studentsearch.text.criteria" name="criteria" size="25" value="<%=criteria %>" />	
						</aui:column>	
						<aui:column>
							<aui:select label="offlinetaskactivity.status" name="gradeFilter" onchange='<%="document.getElementById(\'" + renderResponse.getNamespace() + "studentsearch\').submit();" %>'>
								<aui:option selected='<%= gradeFilter.equals("") %>' value=""><liferay-ui:message key="offlinetaskactivity.all" /></aui:option>
								<aui:option selected='<%= gradeFilter.equals("nocalification") %>' value="nocalification"><liferay-ui:message key="offlinetaskactivity.status.passed" /></aui:option>
								<aui:option selected='<%= gradeFilter.equals("passed") %>' value="passed"><liferay-ui:message key="offlinetaskactivity.passed" /></aui:option>
								<aui:option selected='<%= gradeFilter.equals("failed") %>' value="failed"><liferay-ui:message key="offlinetaskactivity.failed" /></aui:option>
							</aui:select>
						</aui:column>	
						<aui:column>
							<aui:button name="searchUsers" value="search" type="submit" />
						</aui:column>
					</aui:fieldset>
				</aui:form>
				
					
					<liferay-ui:search-container iteratorURL="<%=portletURL%>" emptyResultsMessage="there-are-no-results" delta="10" deltaConfigurable="true">

				   	<liferay-ui:search-container-results>
						<%
							String middleName = null;
					
							LinkedHashMap<String,Object> params = new LinkedHashMap<String,Object>();
							
							params.put("usersGroups", new Long(themeDisplay.getScopeGroupId()));
							if(gradeFilter.equals("passed")) {
								params.put("passed",new CustomSQLParam(OfflineActivity.ACTIVITY_RESULT_PASSED_SQL,actId));
							}
							else {
								if(gradeFilter.equals("failed")) {
									params.put("failed",new CustomSQLParam(OfflineActivity.ACTIVITY_RESULT_FAIL_SQL,actId));
								} else {
									if (gradeFilter.equals("nocalification")) {
										params.put("nocalification",new CustomSQLParam(OfflineActivity.ACTIVITY_RESULT_NO_CALIFICATION_SQL,actId));
									}
								}
							}
							
							
						
														
							OrderByComparator obc = new UserFirstNameComparator(true);
							
							List<User> userListPage = UserLocalServiceUtil.search(themeDisplay.getCompanyId(), criteria, WorkflowConstants.STATUS_ANY, params, searchContainer.getStart(), searchContainer.getEnd(), obc);
							int userCount = UserLocalServiceUtil.searchCount(themeDisplay.getCompanyId(), criteria, WorkflowConstants.STATUS_ANY, params);
									
							pageContext.setAttribute("results", userListPage);
						    pageContext.setAttribute("total", userCount);
						%>
					</liferay-ui:search-container-results>
					
					<liferay-ui:search-container-row className="com.liferay.portal.model.User" keyProperty="userId" modelVar="user">
					<liferay-ui:search-container-column-text name="name">
						<liferay-ui:user-display userId="<%=user.getUserId() %>"></liferay-ui:user-display>
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="calification">
						<% LearningActivityResult learningActivityResult = LearningActivityResultLocalServiceUtil.getByActIdAndUserId(actId, user.getUserId()); 
						   if((learningActivityResult!=null)&&(learningActivityResult.getResult()!=0)) {	   
							   if (learningActivityResult.getResult()!=0) {
								   Object  [] arg =  new Object[]{learningActivityResult.getResult(),activity.getPasspuntuation()};
								   if(learningActivityResult.getPassed()){
									   %><liferay-ui:message key="offlinetaskactivity.student.passed"  arguments="<%=arg %>" /><%
								   }
								   else {
									   %><liferay-ui:message key="offlinetaskactivity.student.failed"  arguments="<%=arg %>" /><%
								   }
							   }
							   else {
								   %><liferay-ui:message key="offlinetaskactivity.student.without.qualification" /><% 
							   }
			               } %>
			            <p class="see-more">
							<a href="javascript:<portlet:namespace />showPopupGrades(<%=Long.toString(user.getUserId()) %>);">
								<liferay-ui:message key="offlinetaskactivity.set.grades"/>
							</a>
						</p>
					</liferay-ui:search-container-column-text>
					</liferay-ui:search-container-row>
					
				 	<liferay-ui:search-iterator />
				 	
				</liferay-ui:search-container>
				
				
				<% } %>	
				
				<div class="nota"> 

<%if ((result!=null)&&(result.getResult()>0)){ %>
	<h2><liferay-ui:message key="offlinetaskactivity.result.title" /></h2>
	<%if (!result.getComments().trim().equals("")){ %>
		<p><liferay-ui:message key="offlinetaskactivity.result.teachercoment" /> <span class="destacado"><%=result.getComments() %></span></p>
	<% } %>
	<p><liferay-ui:message key="offlinetaskactivity.result.youresult" /> <span class="destacado"><%= (arguments.length>0) ? arguments[0]+"%":"" %></span></p>
	<%
	if(LearningActivityResultLocalServiceUtil.userPassed(actId,themeDisplay.getUserId())){
	%>
		<p class="nota_superado"><liferay-ui:message key="offlinetaskactivity.result.pass" /></p>
	<%
	}else{
		Object  [] arg =  new Object[]{activity.getPasspuntuation()};
	%>	
		<p class="nota_nosuperado"><liferay-ui:message key="offlinetaskactivity.result.notpass"  arguments="<%=arg %>" /></p>
	<%
		
	}
}else {
%>
	<p class="nota_nocorregida"><liferay-ui:message key="offlinetaskactivity.not.qualificated.activity" /></p>
<% 
	
}%>

</div>
			
			</div>
			<%
		}
	}
%>