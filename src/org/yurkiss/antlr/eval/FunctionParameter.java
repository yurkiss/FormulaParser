/*
 * Copyright (c) 2005 Einar Pehrson <einar@pehrson.nu>.
 *
 * This file is part of
 * CleanSheets - a spreadsheet application for the Java platform.
 *
 * CleanSheets is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * CleanSheets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package org.yurkiss.antlr.eval;

import java.io.Serializable;

/**
 * A parameter of a function, i.e. the definition of a valid argument.
 * @author Einar Pehrson
 */
public class FunctionParameter implements Serializable {

	/** The unique version identifier used for serialization */
	private static final long serialVersionUID = 1765109547537919342L;

	/** The value type of the argument */
	private Value.Type valueType;

	/** The name of the argument */
	private String name;

	/** Whether the parameter is optional */
	private boolean optional;

	/** The description of the argument */
	private String description;

	/**
	 * Creates a new function parameter.
	 * @param name the name of the argument
	 * @param optional whether the parameter is optional
	 * @param description the description of the argument
	 */
	public FunctionParameter(Value.Type valueType, String name,
							 boolean optional, String description) {
		this.valueType = valueType;
		this.name = name;
		this.optional = optional;
		this.description = description;
	}

	/**
	 * Returns the value type of the argument.
	 * @return the value type of the argument
	 */
	public Value.Type getValueType() {
		return valueType;
	}

	/**
	 * Returns the name of the argument.
	 * @return the name of the argument
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns whether the parameter is optional.
	 * @return whether the parameter is optional
	 */
	public boolean isOptional() {
		return optional;
	}

	/**
	 * Returns the description of the argument.
	 * @return the description of the argument
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns a string representation of the parameter.
	 * @return a string representation of the parameter
	 */
	public String toString() {
		return name; // + " (" + valueType + ")";
	}
}