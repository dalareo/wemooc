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

import com.liferay.lms.model.CheckP2pMailing;
import com.liferay.lms.service.CheckP2pMailingLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the CheckP2pMailing service. Represents a row in the &quot;Lms_CheckP2pMailing&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CheckP2pMailingImpl}.
 * </p>
 *
 * @author TLS
 * @see CheckP2pMailingImpl
 * @see com.liferay.lms.model.CheckP2pMailing
 * @generated
 */
public abstract class CheckP2pMailingBaseImpl extends CheckP2pMailingModelImpl
	implements CheckP2pMailing {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a check p2p mailing model instance should use the {@link CheckP2pMailing} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			CheckP2pMailingLocalServiceUtil.addCheckP2pMailing(this);
		}
		else {
			CheckP2pMailingLocalServiceUtil.updateCheckP2pMailing(this);
		}
	}
}