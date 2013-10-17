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

package com.liferay.lms.service.base;

import com.liferay.lms.service.SCORMContentLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class SCORMContentLocalServiceClpInvoker {
	public SCORMContentLocalServiceClpInvoker() {
		_methodName0 = "addSCORMContent";

		_methodParameterTypes0 = new String[] {
				"com.liferay.lms.model.SCORMContent"
			};

		_methodName1 = "createSCORMContent";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteSCORMContent";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteSCORMContent";

		_methodParameterTypes3 = new String[] {
				"com.liferay.lms.model.SCORMContent"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "fetchSCORMContent";

		_methodParameterTypes9 = new String[] { "long" };

		_methodName10 = "getSCORMContent";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getSCORMContentByUuidAndGroupId";

		_methodParameterTypes12 = new String[] { "java.lang.String", "long" };

		_methodName13 = "getSCORMContents";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getSCORMContentsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateSCORMContent";

		_methodParameterTypes15 = new String[] {
				"com.liferay.lms.model.SCORMContent"
			};

		_methodName16 = "updateSCORMContent";

		_methodParameterTypes16 = new String[] {
				"com.liferay.lms.model.SCORMContent", "boolean"
			};

		_methodName127 = "getBeanIdentifier";

		_methodParameterTypes127 = new String[] {  };

		_methodName128 = "setBeanIdentifier";

		_methodParameterTypes128 = new String[] { "java.lang.String" };

		_methodName133 = "getBaseDir";

		_methodParameterTypes133 = new String[] {  };

		_methodName134 = "getBaseZipDir";

		_methodParameterTypes134 = new String[] {  };

		_methodName135 = "getDirScormzipPath";

		_methodParameterTypes135 = new String[] {
				"com.liferay.lms.model.SCORMContent"
			};

		_methodName136 = "getDirScormPath";

		_methodParameterTypes136 = new String[] {
				"com.liferay.lms.model.SCORMContent"
			};

		_methodName137 = "getSCORMContentOfGroup";

		_methodParameterTypes137 = new String[] { "long" };

		_methodName138 = "getSCORMContents";

		_methodParameterTypes138 = new String[] { "long" };

		_methodName139 = "countByGroupId";

		_methodParameterTypes139 = new String[] { "long" };

		_methodName140 = "delete";

		_methodParameterTypes140 = new String[] { "long" };

		_methodName141 = "updateSCORMContent";

		_methodParameterTypes141 = new String[] {
				"com.liferay.lms.model.SCORMContent",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName142 = "addSCORMContent";

		_methodParameterTypes142 = new String[] {
				"java.lang.String", "java.lang.String", "java.io.File",
				"boolean", "com.liferay.portal.service.ServiceContext"
			};

		_methodName143 = "getUrlManifest";

		_methodParameterTypes143 = new String[] {
				"com.liferay.lms.model.SCORMContent"
			};

		_methodName144 = "force";

		_methodParameterTypes144 = new String[] { "long", "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return SCORMContentLocalServiceUtil.addSCORMContent((com.liferay.lms.model.SCORMContent)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return SCORMContentLocalServiceUtil.createSCORMContent(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return SCORMContentLocalServiceUtil.deleteSCORMContent(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return SCORMContentLocalServiceUtil.deleteSCORMContent((com.liferay.lms.model.SCORMContent)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return SCORMContentLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return SCORMContentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return SCORMContentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return SCORMContentLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return SCORMContentLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return SCORMContentLocalServiceUtil.fetchSCORMContent(((Long)arguments[0]).longValue());
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return SCORMContentLocalServiceUtil.getSCORMContent(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return SCORMContentLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return SCORMContentLocalServiceUtil.getSCORMContentByUuidAndGroupId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return SCORMContentLocalServiceUtil.getSCORMContents(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return SCORMContentLocalServiceUtil.getSCORMContentsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return SCORMContentLocalServiceUtil.updateSCORMContent((com.liferay.lms.model.SCORMContent)arguments[0]);
		}

		if (_methodName16.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes16, parameterTypes)) {
			return SCORMContentLocalServiceUtil.updateSCORMContent((com.liferay.lms.model.SCORMContent)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName127.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
			return SCORMContentLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName128.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes128, parameterTypes)) {
			SCORMContentLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName133.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes133, parameterTypes)) {
			return SCORMContentLocalServiceUtil.getBaseDir();
		}

		if (_methodName134.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes134, parameterTypes)) {
			return SCORMContentLocalServiceUtil.getBaseZipDir();
		}

		if (_methodName135.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes135, parameterTypes)) {
			return SCORMContentLocalServiceUtil.getDirScormzipPath((com.liferay.lms.model.SCORMContent)arguments[0]);
		}

		if (_methodName136.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes136, parameterTypes)) {
			return SCORMContentLocalServiceUtil.getDirScormPath((com.liferay.lms.model.SCORMContent)arguments[0]);
		}

		if (_methodName137.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes137, parameterTypes)) {
			return SCORMContentLocalServiceUtil.getSCORMContentOfGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName138.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes138, parameterTypes)) {
			return SCORMContentLocalServiceUtil.getSCORMContents(((Long)arguments[0]).longValue());
		}

		if (_methodName139.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
			return SCORMContentLocalServiceUtil.countByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName140.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes140, parameterTypes)) {
			SCORMContentLocalServiceUtil.delete(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName141.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes141, parameterTypes)) {
			return SCORMContentLocalServiceUtil.updateSCORMContent((com.liferay.lms.model.SCORMContent)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName142.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes142, parameterTypes)) {
			return SCORMContentLocalServiceUtil.addSCORMContent((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.io.File)arguments[2],
				((Boolean)arguments[3]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName143.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes143, parameterTypes)) {
			return SCORMContentLocalServiceUtil.getUrlManifest((com.liferay.lms.model.SCORMContent)arguments[0]);
		}

		if (_methodName144.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
			return SCORMContentLocalServiceUtil.force(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName127;
	private String[] _methodParameterTypes127;
	private String _methodName128;
	private String[] _methodParameterTypes128;
	private String _methodName133;
	private String[] _methodParameterTypes133;
	private String _methodName134;
	private String[] _methodParameterTypes134;
	private String _methodName135;
	private String[] _methodParameterTypes135;
	private String _methodName136;
	private String[] _methodParameterTypes136;
	private String _methodName137;
	private String[] _methodParameterTypes137;
	private String _methodName138;
	private String[] _methodParameterTypes138;
	private String _methodName139;
	private String[] _methodParameterTypes139;
	private String _methodName140;
	private String[] _methodParameterTypes140;
	private String _methodName141;
	private String[] _methodParameterTypes141;
	private String _methodName142;
	private String[] _methodParameterTypes142;
	private String _methodName143;
	private String[] _methodParameterTypes143;
	private String _methodName144;
	private String[] _methodParameterTypes144;
}