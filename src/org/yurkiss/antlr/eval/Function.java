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
 * A function that can be used in a formula.
 * @author Einar Pehrson
 */
public interface Function {

	/**
	 * Returns the operator's string identirifer.
	 * @return a string representation of the operator.
	 */
	public String getIdentifier();

	/**
	 * Invokes the function using the given arguments and returns the result.
	 * @return the result of the operation
	 */
	public Value applyTo(Expression[] args) throws IllegalValueTypeException;

	/**
	 * Returns the parameters of the function.
	 * @return the parameters of the function
	 */
	public FunctionParameter[] getParameters();

	/**
	 * Returns whether the function accepts a variable number of arguments,
	 * i.e. whether the function's parameter list is unbounded.
	 * @return true if the function accepts a variable number of arguments
	 */
	public boolean isVarArg();
}