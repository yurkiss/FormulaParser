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
package org.yurkiss.antlr.eval.functions;


import org.yurkiss.antlr.eval.Expression;

/**
 * An exception that is thrown when a division by zero is evaluated.
 * @author Einar Pehrson
 */
public class DivisionByZeroException extends Exception {

	/** The serialVersionUID of the DivisionByZeroException.java */
	private static final long serialVersionUID = -5387697381170031793L;

	/**
	 * Creates a new division-by-zero exception.
	 * @param expression the expression that evaluated to zero
	 */
	public DivisionByZeroException(Expression expression) {
		super("Illegal divisor (" + expression + "): division by 0 is undefined");
	}

	/**
	 * Returns a string representation of the exception.
	 * @return a string representation of the exception
	 */
	public String toString() {
		return "#DIV/0!";
	}
}