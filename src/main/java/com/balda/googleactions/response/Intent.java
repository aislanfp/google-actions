/*
 * Copyright 2017 Marco Stornelli <playappassistance@gmail.com>
 * 
 * This file is part of Google Actions project
 *
 * AirTask Desktop is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * AirTask Desktop is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with AirTask Desktop.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.balda.googleactions.response;

public enum Intent {
	//@formatter:off
	TEXT("actions.intent.TEXT", null),
	PERMISSION("actions.intent.PERMISSION", "type.googleapis.com/google.actions.v2.PermissionValueSpec"),
	MAIN("actions.intent.MAIN", null),
	SIGN_IN("actions.intent.SIGN_IN", null),
	OPTION("actions.intent.OPTION", "type.googleapis.com/google.actions.v2.OptionValueSpec"),
	DATETIME("actions.intent.DATETIME", "type.googleapis.com/google.actions.v2.DateTimeValueSpec"),
	DELIVERY_ADDRESS("actions.intent.DELIVERY_ADDRESS", "type.googleapis.com/google.actions.v2.DeliveryAddressValueSpec"),
	TRANSACTION_REQ_CHECK("actions.intent.TRANSACTION_REQUIREMENTS_CHECK", "type.googleapis.com/google.actions.v2.TransactionRequirementsCheckSpec"),
	TRANSACTION_DECISION("actions.intent.TRANSACTION_DECISION", "type.googleapis.com/google.actions.v2.TransactionDecisionValueSpec"),
	CONFIRMATION("actions.intent.confirmation", "type.googleapis.com/google.actions.v2.ConfirmationValueSpec");
	//@formatter:on

	private String action;
	private String type;

	private Intent(String a, String t) {
		action = a;
		type = t;
	}

	public String getAction() {
		return action;
	}

	public String getType() {
		return type;
	}
}
