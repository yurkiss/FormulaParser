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

/**
 * An exception that is thrown when an illegal value is encountered.
 * @author Einar Pehrson
 */
public class IllegalValueTypeException extends Exception {

	/** The serialVersionUID of the IllegalValueTypeException.java */
	private static final long serialVersionUID = 1642715350728576100L;

	/** The value */
	private Value value;

	/** The expected type of the value */
	private Value.Type expectedValueType;

	/**
	 * Creates a new illegal value type exception.
	 * @param value the value
	 * @param expectedValueType the expected type of the value
	 */
	public IllegalValueTypeException(Value value, Value.Type expectedValueType) {
		this.value = value;
		this.expectedValueType = expectedValueType;
	}

	/**
	 * Returns the value.
	 * @return the value
	 */
	public Value getValue() {
		return value;
	}

	/**
	 * Returns the expected type of the value.
	 * @return the expected type of the value
	 */
	public Value.Type getExpectedValueType() {
		return expectedValueType;
	}

	/**
	 * Returns a message describing the exception.
	 * @return a message describing the exception
	 */
	public String getMessage() {
		return "The value '" + value + "' was expected to be of type "
			+ expectedValueType.toString().toLowerCase() + ".";
	}

	/**
	 * Returns a string representation of the exception.
	 * @return a string representation of the exception
	 */
	public String toString() {
		if (value.toAny() == null)
			return "#NULL!";
		else
			return "#TYPE!";
	}
}