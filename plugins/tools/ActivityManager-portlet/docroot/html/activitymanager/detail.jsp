
<%@page import="com.liferay.lms.learningactivity.LearningActivityTypeRegistry"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.lms.model.LearningActivity"%>
<%@page import="com.liferay.lms.learningactivity.LearningActivityType"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.lms.service.LearningActivityServiceUtil"%>
<%@page import="com.liferay.lms.service.ModuleLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.Module"%>

<%@include file="/init.jsp" %>
<%@ include file="/html/head.jsp" %>

<portlet:actionURL var="fixAllURL" name="fix">
	<portlet:param name="action" value="all"/>
</portlet:actionURL>

<portlet:actionURL var="fixNotPassedURL" name="fix">
	<portlet:param name="action" value="notpassed"/>
</portlet:actionURL>

<portlet:actionURL var="fixUserURL" name="users">
	<portlet:param name="course" value="${course.courseId}"/>
</portlet:actionURL>

<portlet:actionURL var="recalculateURL" name="recalculate">
	<portlet:param name="course" value="${course.courseId}"/>
</portlet:actionURL>

<script type="text/javascript">
	var urlall = '${fixAllURL}';
	var urlnotpassed = '${fixNotPassedURL}';
	var urluser = '${fixUserURL}';
	var urlrecalculate = '${recalculateURL}';
	function removeAll(id){
		if(confirm('<liferay-ui:message key="actmanager.confirm-delete" />')){
			window.location.href = urlall+"&id="+id;
		}
	}
	function removeNotPassed(id){
		if(confirm('<liferay-ui:message key="actmanager.confirm-delete" />')){
			window.location.href = urlnotpassed+"&id="+id;
		}
	}
	function removeUser(id){
			window.location.href = urluser+"&id="+id;
	}
	function recalculate(moduleId){
		if(confirm('<liferay-ui:message key="actmanager.confirm-recalculate" />')){
			window.location.href = urlrecalculate+"&id="+moduleId;
		}
	}
</script>
<c:if test="${empty modules}"><liferay-ui:message key="there-are-no-results" />
</c:if>
<c:if test="${not empty modules}">
	<% LearningActivityTypeRegistry latr = new LearningActivityTypeRegistry(); %>
	<div class="lfr-search-container "><div class="yui3-widget aui-component aui-searchcontainer aui-searchcontainer-focused"><div class="results-grid aui-searchcontainer-content">
		<% int numModule = 0; String title = ""; %>
		<c:forEach var="module" items="${modules}">
			<% 
			numModule++; 
			title = LanguageUtil.format(pageContext, "actmanager.moduleTitle.chapter", new Object[]{numModule}); 
			pageContext.setAttribute("title", title);
			%>
			<c:if test="${module.getModuleId() eq activeModuleId }"><c:set var="state" value="open"></c:set></c:if>
			<c:if test="${module.getModuleId() ne activeModuleId }"><c:set var="state" value="closed"></c:set></c:if>
			<liferay-ui:panel id="${module.getModuleId()}" title="${title} ${module.getTitle(themeDisplay.locale)}" collapsible="true" defaultState="${state}">	
				<table class="taglib-search-iterator"><tbody>
					<tr class="portlet-section-header results-header">
					<th class="col-1 col-1 first"><%=LanguageUtil.get(pageContext, "activity")%></th>
					<th><%=LanguageUtil.get(pageContext, "actmanager.type") %></th>
					<th><%=LanguageUtil.get(pageContext, "actmanager.startdate") %></th>
					<th><%=LanguageUtil.get(pageContext, "actmanager.enddate") %></th>
					<th class="col-1 col-1 first align-left valign-middle">
						<div style="text-align: right;">
						<liferay-ui:icon-menu>
							<liferay-ui:icon cssClass="tag-items" image="recent_changes" message="actmanager.recalculate" onClick='recalculate(${module.moduleId})' url="#"  />
						</liferay-ui:icon-menu>
						</div>
					</th>
					</tr>
					<c:forEach var="activity" items="${learningActivities[module.moduleId]}">
						<%
						LearningActivity la = (LearningActivity)pageContext.getAttribute("activity");
						Long laId = new Long(la.getTypeId());
						LearningActivityType lat = latr.getLearningActivityType(laId);
						if(lat!=null){
							String laName = lat.getName();
							String laType = LanguageUtil.get(pageContext, laName);
							pageContext.setAttribute("laType", laType);
						%>
							<tr class="portlet-section-body results-row">
							<td class="align-left col-1 col-1 first valign-middle">${activity.getTitle(themeDisplay.locale)}</td>
							<td class="align-left col-1 col-1 first valign-middle">${laType}</td>
						
							<td class="align-left col-1 col-1 first valign-middle"><fmt:formatDate value="${activity.getStartdate()}" pattern="dd/MM/yyyy HH:mm" /></td>
							<td class="align-left col-1 col-1 first valign-middle"><fmt:formatDate value="${activity.getEnddate()}" pattern="dd/MM/yyyy HH:mm" /></td>
							<td class="align-left col-1 col-1 first valign-middle">
								<c:if test="${activity.isNew()}">
									<liferay-util:include page="/html/activitymanager/actions/module_actions.jsp" servletContext="<%=this.getServletContext() %>">
										<liferay-util:param name="activity" value="${activity.actId}" />
									</liferay-util:include>
								</c:if>
							</td>
							</tr>
						<%} %>
					</c:forEach>
				</tbody></table>
			</liferay-ui:panel>
		</c:forEach>
	</div></div></div>
</c:if>

<%@ include file="/html/activitymanager/audit.jspf" %>