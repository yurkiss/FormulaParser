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
 * An exception that is thrown during compilation.
 * @author Einar Pehrson
 */
public class FormulaCompilationException extends Exception {

	/** The serialVersionUID of the FormulaCompilationException.java */
	private static final long serialVersionUID = -6141961615954639105L;

	/**
	 * Creates a new compilation exception.
	 */
	public FormulaCompilationException() {}

	/**
	 * Creates a new compilation exception.
	 * @param cause the throwable that caused the exception to be raised
	 */
	public FormulaCompilationException(Throwable cause) {
		super(cause);
	}

	/**
	 * Creates a new compilation exception.
	 * @param message a message that describes what happened
	 */
	public FormulaCompilationException(String message) {
		super(message);
	}

	/**
	 * Returns a string representation of the exception.
	 * @return a string representation of the exception
	 */
	public String toString() {
		return getMessage();
	}
}