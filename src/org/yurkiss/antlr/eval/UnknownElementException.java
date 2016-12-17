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
 * An exception that is thrown if an unknown language element is requested.
 * @author Einar Pehrson
 */
public class UnknownElementException extends FormulaCompilationException {

	/** The serialVersionUID of the UnknownElementException.java */
	private static final long serialVersionUID = 1104385312243490098L;

	/** The identifier of the unknown element */
	private String identifier;

	/**
	 * Creates a new unknown identifier exception.
	 * @param identifier the identifier of the unknown element
	 */
	public UnknownElementException(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * Returns the identifier of the unknown element.
	 * @return the identifier of the unknown element
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * Returns a message describing the exception.
	 * @return a message describing the exception
	 */
	public String getMessage() {
		return "Unknown element identifier: " + identifier + ".";
	}

	/**
	 * Returns a string representation of the exception.
	 * @return a string representation of the exception
	 */
	public String toString() {
		return getMessage();
	}
}