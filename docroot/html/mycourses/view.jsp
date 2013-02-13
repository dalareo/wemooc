
<%@page import="com.liferay.lms.service.CourseLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.Course"%>
<%@page import="com.liferay.lms.service.ModuleResultLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.ModuleResult"%>
<%@page import="com.liferay.lms.model.Module"%>
<%@page import="com.liferay.lms.service.ModuleLocalServiceUtil"%>

<%@ include file="/init.jsp"%>
<%

java.util.List<Group> groups= GroupLocalServiceUtil.getUserGroups(themeDisplay.getUserId());
	
for(Group groupCourse:groups)
{
	
	
	Course course=CourseLocalServiceUtil.fetchByGroupCreatedId(groupCourse.getGroupId());
	if(course!=null)
	{
	long passed=ModuleLocalServiceUtil.modulesUserPassed(groupCourse.getGroupId(),themeDisplay.getUserId());
	long modulescount=ModuleLocalServiceUtil.countByGroupId(groupCourse.getGroupId());
	if(modulescount>0)
	{
		%>
		<div class="course option-more">
		<%
		if(groupCourse.getPublicLayoutSet().getLogo())
		{
			long logoId = groupCourse.getPublicLayoutSet().getLogoId();
			%>
			<img src="/image/layout_set_logo?img_id=<%=logoId%>">
			<%
		}
				
		%>
			<a href="/web/<%=course.getFriendlyURL()%>"><%=course.getTitle(themeDisplay.getLocale()) %></a> <span class="challenges"><%=passed %>/<%= modulescount%> terminados</span><span class="ico-desplegable"></span>
			<div class="collapsable">
				<table class="moduleList">
		<%
			java.util.List<Module> theModules=ModuleLocalServiceUtil.findAllInGroup(groupCourse.getGroupId());
			
				for(Module theModule:theModules)
				{
					ModuleResult moduleResult=ModuleResultLocalServiceUtil.getByModuleAndUser(theModule.getModuleId(),themeDisplay.getUserId());
					long done=0;
					if(moduleResult!=null)
					{
						done=moduleResult.getResult();
					}
					%>

					<tr>
			
					<td class="title">
					<%
						long retoplid=themeDisplay.getPlid();
						for(Layout theLayout:LayoutLocalServiceUtil.getLayouts(groupCourse.getGroupId(),false))
						{
					
							if(theLayout.getFriendlyURL().equals("/reto"))
							{
								retoplid=theLayout.getPlid();
								
							}
						}
						
						%>
						<liferay-portlet:renderURL plid="<%=retoplid %>" portletName="lmsactivitieslist_WAR_liferaylmsportlet" var="gotoModuleURL">
						<liferay-portlet:param name="moduleId" value="<%=Long.toString(theModule.getModuleId()) %>"></liferay-portlet:param>
						</liferay-portlet:renderURL>
						<%if(!ModuleLocalServiceUtil.isLocked(theModule.getModuleId(),themeDisplay.getUserId()))
							{
							%>
					<a href="<%=gotoModuleURL.toString()%>"><%=theModule.getTitle(themeDisplay.getLocale()) %></a>
					<%
							}
						else
						{
							%>
							<a><%=theModule.getTitle(themeDisplay.getLocale()) %></a>
							<%
						}
					%>
					</td>
				<td class="result">
					
					<%=done %>% hecho
					</td>
			
					</tr>
					
				<%
				}
				%>
				</table>
			</div>
		</div>
<%
		}
	}
}
%>
	
