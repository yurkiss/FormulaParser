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
 * An exception that is thrown if an function call with illegal argument count
 * or argument types is encountered during parsing.
 * @author Einar Pehrson
 */
public class IllegalFunctionCallException extends FormulaCompilationException {

	/** The serialVersionUID of the IllegalFunctionCallException.java */
	private static final long serialVersionUID = 1960534028676316836L;

	/** The function call */
	private Function function;

	/** The parameter that was not matched */
	private FunctionParameter parameter;

	/** The argument that failed to match */
	private Expression argument;

	/**
	 * Creates a new function call exception.
	 * @param function the function that was called
	 * @param parameter the parameter that was not matched
	 * @param argument the argument that failed to match
	 */
	public IllegalFunctionCallException(Function function,
										FunctionParameter parameter, Expression argument) {
		this.function = function;
		this.parameter = parameter;
		this.argument = argument;
	}

	/**
	 * Returns the function that was called.
	 * @return the function that was called
	 */
	public Function getFunction() {
		return function;
	}

	/**
	 * Returns the parameter that was not matched.
	 * @return the parameter that was not matched
	 */
	public FunctionParameter getParameter() {
		return parameter;
	}

	/**
	 * Returns the argument that failed to match.
	 * @return the argument that failed to match
	 */
	public Expression getArgument() {
		return argument;
	}

	/**
	 * Returns a message describing the exception.
	 * @return a message describing the exception
	 */
	public String getMessage() {
		String s = "Illegal function call: ";
		if (parameter == null)
			s += "too many arguments (" + argument + " did not match).";
		else if (argument == null)
			s += "missing argument " + parameter.getName() + ".";
		return s;
	}

	/**
	 * Returns a string representation of the exception.
	 * @return a string representation of the exception
	 */
	public String toString() {
		return getMessage();
	}
}