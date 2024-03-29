/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.lms.model.impl;

import com.liferay.lms.model.SCORMContent;
import com.liferay.lms.model.SCORMContentModel;
import com.liferay.lms.model.SCORMContentSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the SCORMContent service. Represents a row in the &quot;Lms_SCORMContent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.lms.model.SCORMContentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SCORMContentImpl}.
 * </p>
 *
 * @author TLS
 * @see SCORMContentImpl
 * @see com.liferay.lms.model.SCORMContent
 * @see com.liferay.lms.model.SCORMContentModel
 * @generated
 */
public class SCORMContentModelImpl extends BaseModelImpl<SCORMContent>
	implements SCORMContentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a s c o r m content model instance should use the {@link com.liferay.lms.model.SCORMContent} interface instead.
	 */
	public static final String TABLE_NAME = "Lms_SCORMContent";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "scormId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP },
			{ "title", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "index_", Types.VARCHAR },
			{ "ciphered", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table Lms_SCORMContent (uuid_ VARCHAR(75) null,scormId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,title VARCHAR(75) null,description TEXT null,index_ VARCHAR(75) null,ciphered BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table Lms_SCORMContent";
	public static final String ORDER_BY_JPQL = " ORDER BY scormContent.scormId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Lms_SCORMContent.scormId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.lms.model.SCORMContent"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.lms.model.SCORMContent"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.lms.model.SCORMContent"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long USERID_COLUMN_BITMASK = 4L;
	public static long UUID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static SCORMContent toModel(SCORMContentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SCORMContent model = new SCORMContentImpl();

		model.setUuid(soapModel.getUuid());
		model.setScormId(soapModel.getScormId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());
		model.setTitle(soapModel.getTitle());
		model.setDescription(soapModel.getDescription());
		model.setIndex(soapModel.getIndex());
		model.setCiphered(soapModel.getCiphered());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<SCORMContent> toModels(SCORMContentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SCORMContent> models = new ArrayList<SCORMContent>(soapModels.length);

		for (SCORMContentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.lms.model.SCORMContent"));

	public SCORMContentModelImpl() {
	}

	public long getPrimaryKey() {
		return _scormId;
	}

	public void setPrimaryKey(long primaryKey) {
		setScormId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_scormId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return SCORMContent.class;
	}

	public String getModelClassName() {
		return SCORMContent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("scormId", getScormId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("index", getIndex());
		attributes.put("ciphered", getCiphered());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long scormId = (Long)attributes.get("scormId");

		if (scormId != null) {
			setScormId(scormId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String index = (String)attributes.get("index");

		if (index != null) {
			setIndex(index);
		}

		Boolean ciphered = (Boolean)attributes.get("ciphered");

		if (ciphered != null) {
			setCiphered(ciphered);
		}
	}

	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	public long getScormId() {
		return _scormId;
	}

	public void setScormId(long scormId) {
		_columnBitmask = -1L;

		_scormId = scormId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusByUserName;
		}
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getIndex() {
		if (_index == null) {
			return StringPool.BLANK;
		}
		else {
			return _index;
		}
	}

	public void setIndex(String index) {
		_index = index;
	}

	public boolean getCiphered() {
		return _ciphered;
	}

	public boolean isCiphered() {
		return _ciphered;
	}

	public void setCiphered(boolean ciphered) {
		_ciphered = ciphered;
	}

	/**
	 * @deprecated {@link #isApproved}
	 */
	public boolean getApproved() {
		return isApproved();
	}

	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isDraft() {
		if ((getStatus() == WorkflowConstants.STATUS_DRAFT) ||
				(getStatus() == WorkflowConstants.STATUS_DRAFT_FROM_APPROVED)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			SCORMContent.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SCORMContent toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (SCORMContent)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		SCORMContentImpl scormContentImpl = new SCORMContentImpl();

		scormContentImpl.setUuid(getUuid());
		scormContentImpl.setScormId(getScormId());
		scormContentImpl.setCompanyId(getCompanyId());
		scormContentImpl.setGroupId(getGroupId());
		scormContentImpl.setUserId(getUserId());
		scormContentImpl.setStatus(getStatus());
		scormContentImpl.setStatusByUserId(getStatusByUserId());
		scormContentImpl.setStatusByUserName(getStatusByUserName());
		scormContentImpl.setStatusDate(getStatusDate());
		scormContentImpl.setTitle(getTitle());
		scormContentImpl.setDescription(getDescription());
		scormContentImpl.setIndex(getIndex());
		scormContentImpl.setCiphered(getCiphered());

		scormContentImpl.resetOriginalValues();

		return scormContentImpl;
	}

	public int compareTo(SCORMContent scormContent) {
		int value = 0;

		if (getScormId() < scormContent.getScormId()) {
			value = -1;
		}
		else if (getScormId() > scormContent.getScormId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		SCORMContent scormContent = null;

		try {
			scormContent = (SCORMContent)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = scormContent.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		SCORMContentModelImpl scormContentModelImpl = this;

		scormContentModelImpl._originalUuid = scormContentModelImpl._uuid;

		scormContentModelImpl._originalCompanyId = scormContentModelImpl._companyId;

		scormContentModelImpl._setOriginalCompanyId = false;

		scormContentModelImpl._originalGroupId = scormContentModelImpl._groupId;

		scormContentModelImpl._setOriginalGroupId = false;

		scormContentModelImpl._originalUserId = scormContentModelImpl._userId;

		scormContentModelImpl._setOriginalUserId = false;

		scormContentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SCORMContent> toCacheModel() {
		SCORMContentCacheModel scormContentCacheModel = new SCORMContentCacheModel();

		scormContentCacheModel.uuid = getUuid();

		String uuid = scormContentCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			scormContentCacheModel.uuid = null;
		}

		scormContentCacheModel.scormId = getScormId();

		scormContentCacheModel.companyId = getCompanyId();

		scormContentCacheModel.groupId = getGroupId();

		scormContentCacheModel.userId = getUserId();

		scormContentCacheModel.status = getStatus();

		scormContentCacheModel.statusByUserId = getStatusByUserId();

		scormContentCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = scormContentCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			scormContentCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			scormContentCacheModel.statusDate = statusDate.getTime();
		}
		else {
			scormContentCacheModel.statusDate = Long.MIN_VALUE;
		}

		scormContentCacheModel.title = getTitle();

		String title = scormContentCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			scormContentCacheModel.title = null;
		}

		scormContentCacheModel.description = getDescription();

		String description = scormContentCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			scormContentCacheModel.description = null;
		}

		scormContentCacheModel.index = getIndex();

		String index = scormContentCacheModel.index;

		if ((index != null) && (index.length() == 0)) {
			scormContentCacheModel.index = null;
		}

		scormContentCacheModel.ciphered = getCiphered();

		return scormContentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", scormId=");
		sb.append(getScormId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", index=");
		sb.append(getIndex());
		sb.append(", ciphered=");
		sb.append(getCiphered());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.liferay.lms.model.SCORMContent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scormId</column-name><column-value><![CDATA[");
		sb.append(getScormId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>index</column-name><column-value><![CDATA[");
		sb.append(getIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ciphered</column-name><column-value><![CDATA[");
		sb.append(getCiphered());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SCORMContent.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			SCORMContent.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _scormId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private String _title;
	private String _description;
	private String _index;
	private boolean _ciphered;
	private long _columnBitmask;
	private SCORMContent _escapedModelProxy;
}