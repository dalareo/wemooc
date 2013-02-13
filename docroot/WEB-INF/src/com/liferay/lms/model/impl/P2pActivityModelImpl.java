/**
 * Copyright (c)2013 Telefonica Learning Services. All rights reserved.
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

import com.liferay.lms.model.P2pActivity;
import com.liferay.lms.model.P2pActivityModel;
import com.liferay.lms.model.P2pActivitySoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
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
 * The base model implementation for the P2pActivity service. Represents a row in the &quot;Lms_P2pActivity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.lms.model.P2pActivityModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link P2pActivityImpl}.
 * </p>
 *
 * @author TLS
 * @see P2pActivityImpl
 * @see com.liferay.lms.model.P2pActivity
 * @see com.liferay.lms.model.P2pActivityModel
 * @generated
 */
@JSON(strict = true)
public class P2pActivityModelImpl extends BaseModelImpl<P2pActivity>
	implements P2pActivityModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a p2p activity model instance should use the {@link com.liferay.lms.model.P2pActivity} interface instead.
	 */
	public static final String TABLE_NAME = "Lms_P2pActivity";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "p2pActivityId", Types.BIGINT },
			{ "actId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "fileEntryId", Types.BIGINT },
			{ "countCorrections", Types.BIGINT },
			{ "description", Types.VARCHAR },
			{ "date_", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table Lms_P2pActivity (uuid_ VARCHAR(75) null,p2pActivityId LONG not null primary key,actId LONG,userId LONG,fileEntryId LONG,countCorrections LONG,description VARCHAR(75) null,date_ DATE null)";
	public static final String TABLE_SQL_DROP = "drop table Lms_P2pActivity";
	public static final String ORDER_BY_JPQL = " ORDER BY p2pActivity.countCorrections ASC, p2pActivity.p2pActivityId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Lms_P2pActivity.countCorrections ASC, Lms_P2pActivity.p2pActivityId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.lms.model.P2pActivity"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.lms.model.P2pActivity"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.lms.model.P2pActivity"),
			true);
	public static long ACTID_COLUMN_BITMASK = 1L;
	public static long USERID_COLUMN_BITMASK = 2L;
	public static long UUID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static P2pActivity toModel(P2pActivitySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		P2pActivity model = new P2pActivityImpl();

		model.setUuid(soapModel.getUuid());
		model.setP2pActivityId(soapModel.getP2pActivityId());
		model.setActId(soapModel.getActId());
		model.setUserId(soapModel.getUserId());
		model.setFileEntryId(soapModel.getFileEntryId());
		model.setCountCorrections(soapModel.getCountCorrections());
		model.setDescription(soapModel.getDescription());
		model.setDate(soapModel.getDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<P2pActivity> toModels(P2pActivitySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<P2pActivity> models = new ArrayList<P2pActivity>(soapModels.length);

		for (P2pActivitySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.lms.model.P2pActivity"));

	public P2pActivityModelImpl() {
	}

	public long getPrimaryKey() {
		return _p2pActivityId;
	}

	public void setPrimaryKey(long primaryKey) {
		setP2pActivityId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_p2pActivityId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return P2pActivity.class;
	}

	public String getModelClassName() {
		return P2pActivity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("p2pActivityId", getP2pActivityId());
		attributes.put("actId", getActId());
		attributes.put("userId", getUserId());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("countCorrections", getCountCorrections());
		attributes.put("description", getDescription());
		attributes.put("date", getDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long p2pActivityId = (Long)attributes.get("p2pActivityId");

		if (p2pActivityId != null) {
			setP2pActivityId(p2pActivityId);
		}

		Long actId = (Long)attributes.get("actId");

		if (actId != null) {
			setActId(actId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Long countCorrections = (Long)attributes.get("countCorrections");

		if (countCorrections != null) {
			setCountCorrections(countCorrections);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}
	}

	@JSON
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

	@JSON
	public long getP2pActivityId() {
		return _p2pActivityId;
	}

	public void setP2pActivityId(long p2pActivityId) {
		_columnBitmask = -1L;

		_p2pActivityId = p2pActivityId;
	}

	@JSON
	public long getActId() {
		return _actId;
	}

	public void setActId(long actId) {
		_columnBitmask |= ACTID_COLUMN_BITMASK;

		if (!_setOriginalActId) {
			_setOriginalActId = true;

			_originalActId = _actId;
		}

		_actId = actId;
	}

	public long getOriginalActId() {
		return _originalActId;
	}

	@JSON
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

	@JSON
	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	@JSON
	public long getCountCorrections() {
		return _countCorrections;
	}

	public void setCountCorrections(long countCorrections) {
		_columnBitmask = -1L;

		_countCorrections = countCorrections;
	}

	@JSON
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

	@JSON
	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			P2pActivity.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public P2pActivity toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (P2pActivity)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		P2pActivityImpl p2pActivityImpl = new P2pActivityImpl();

		p2pActivityImpl.setUuid(getUuid());
		p2pActivityImpl.setP2pActivityId(getP2pActivityId());
		p2pActivityImpl.setActId(getActId());
		p2pActivityImpl.setUserId(getUserId());
		p2pActivityImpl.setFileEntryId(getFileEntryId());
		p2pActivityImpl.setCountCorrections(getCountCorrections());
		p2pActivityImpl.setDescription(getDescription());
		p2pActivityImpl.setDate(getDate());

		p2pActivityImpl.resetOriginalValues();

		return p2pActivityImpl;
	}

	public int compareTo(P2pActivity p2pActivity) {
		int value = 0;

		if (getCountCorrections() < p2pActivity.getCountCorrections()) {
			value = -1;
		}
		else if (getCountCorrections() > p2pActivity.getCountCorrections()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getP2pActivityId() < p2pActivity.getP2pActivityId()) {
			value = -1;
		}
		else if (getP2pActivityId() > p2pActivity.getP2pActivityId()) {
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

		P2pActivity p2pActivity = null;

		try {
			p2pActivity = (P2pActivity)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = p2pActivity.getPrimaryKey();

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
		P2pActivityModelImpl p2pActivityModelImpl = this;

		p2pActivityModelImpl._originalUuid = p2pActivityModelImpl._uuid;

		p2pActivityModelImpl._originalActId = p2pActivityModelImpl._actId;

		p2pActivityModelImpl._setOriginalActId = false;

		p2pActivityModelImpl._originalUserId = p2pActivityModelImpl._userId;

		p2pActivityModelImpl._setOriginalUserId = false;

		p2pActivityModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<P2pActivity> toCacheModel() {
		P2pActivityCacheModel p2pActivityCacheModel = new P2pActivityCacheModel();

		p2pActivityCacheModel.uuid = getUuid();

		String uuid = p2pActivityCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			p2pActivityCacheModel.uuid = null;
		}

		p2pActivityCacheModel.p2pActivityId = getP2pActivityId();

		p2pActivityCacheModel.actId = getActId();

		p2pActivityCacheModel.userId = getUserId();

		p2pActivityCacheModel.fileEntryId = getFileEntryId();

		p2pActivityCacheModel.countCorrections = getCountCorrections();

		p2pActivityCacheModel.description = getDescription();

		String description = p2pActivityCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			p2pActivityCacheModel.description = null;
		}

		Date date = getDate();

		if (date != null) {
			p2pActivityCacheModel.date = date.getTime();
		}
		else {
			p2pActivityCacheModel.date = Long.MIN_VALUE;
		}

		return p2pActivityCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", p2pActivityId=");
		sb.append(getP2pActivityId());
		sb.append(", actId=");
		sb.append(getActId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", countCorrections=");
		sb.append(getCountCorrections());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", date=");
		sb.append(getDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.lms.model.P2pActivity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>p2pActivityId</column-name><column-value><![CDATA[");
		sb.append(getP2pActivityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actId</column-name><column-value><![CDATA[");
		sb.append(getActId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countCorrections</column-name><column-value><![CDATA[");
		sb.append(getCountCorrections());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = P2pActivity.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			P2pActivity.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _p2pActivityId;
	private long _actId;
	private long _originalActId;
	private boolean _setOriginalActId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _fileEntryId;
	private long _countCorrections;
	private String _description;
	private Date _date;
	private long _columnBitmask;
	private P2pActivity _escapedModelProxy;
}