package com.liferay.lms.learningactivity;

import java.io.IOException;

import javax.portlet.PortletResponse;

import com.liferay.lms.asset.SurveyAssetRenderer;
import com.liferay.lms.model.LearningActivity;
import com.liferay.lms.model.LearningActivityTry;
import com.liferay.lms.service.ClpSerializer;
import com.liferay.lms.service.LearningActivityTryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetRenderer;

public class SurveyLearningActivityType extends BaseLearningActivityType {

	public static String PORTLET_ID = 
			PortalUtil.getJsSafePortletId(
					"surveyactivity" + PortletConstants.WAR_SEPARATOR + ClpSerializer.getServletContextName());
	
	@Override
	public AssetRenderer getAssetRenderer(LearningActivity larn) {
		return new SurveyAssetRenderer(larn);
	}

	@Override
	public String getName() {
		
		return "learningactivity.survey";
	}

	@Override
	public long getTypeId() {
		return 4;
	}
	
	
	@Override
	public String getMesageEditDetails() {
		return "surveyactivity.editquestions";
	}
	
	@Override
	public void setExtraContent(UploadRequest uploadRequest,
			PortletResponse portletResponse, LearningActivity learningActivity)
			throws PortalException, SystemException, DocumentException,IOException {
		
	    DynamicQuery dq=DynamicQueryFactoryUtil.forClass(LearningActivityTry.class);
	  	Criterion criterion=PropertyFactoryUtil.forName("actId").eq(learningActivity.getActId());
		dq.add(criterion);
		
	    if(LearningActivityTryLocalServiceUtil.dynamicQueryCount(dq)==0) {
		
			String team = ParamUtil.getString(uploadRequest, "team");
			long teamId = 0;
			if(!team.equalsIgnoreCase("0")){
				teamId = Long.parseLong(team);
			}
			
			Document document = null;
			Element rootElement = null;
			if((learningActivity.getExtracontent()==null)||(learningActivity.getExtracontent().trim().length()==0)){
				document = SAXReaderUtil.createDocument();
				rootElement = document.addElement("survey");
			}
			else
			{
				document=SAXReaderUtil.read(learningActivity.getExtracontent());
				rootElement =document.getRootElement();
			}
						
			Element teamElement=rootElement.element("team");
			if(teamElement!=null)
			{
				teamElement.detach();
				rootElement.remove(teamElement);
			}
			if(teamId!=0){
				teamElement = SAXReaderUtil.createElement("team");
				teamElement.setText(Long.toString(teamId));
				rootElement.add(teamElement);
			}
			learningActivity.setExtracontent(document.formattedString());
	    }	
	}
	
	@Override
	public String getDescription() {
		return "learningactivity.survey.helpmessage";
	}
	
	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}

}
