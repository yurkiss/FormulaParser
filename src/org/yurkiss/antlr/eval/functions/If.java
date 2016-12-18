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


import org.yurkiss.antlr.eval.*;

/**
 * A function that emulates the if-then-else statement.
 * @author Einar Pehrson
 */
public class If implements Function {

	/** The function's three parameters: condition, result and alternative */
	public static final FunctionParameter[] parameters = new FunctionParameter[] {
		new FunctionParameter(Value.Type.BOOLEAN, "Condition", false,
			"A condition to evaluate before proceeding"),
		new FunctionParameter(Value.Type.UNDEFINED, "Then", false,
			"A value to return if the condition was met"),
		new FunctionParameter(Value.Type.UNDEFINED, "Else", true,
			"A value to return otherwise")
	};

	/**
	 * Creates a new instance of the IF function.
	 */
	public If() {}

	public String getIdentifier() {
		return "IF";
	}

	public Value applyTo(Expression[] arguments) throws IllegalValueTypeException {
		if (arguments[0].evaluate().toBoolean())
			return arguments[1].evaluate();
		else if (arguments.length == 3)
			return arguments[2].evaluate();
		else
			return new Value();
	}

	public FunctionParameter[] getParameters() {
		return parameters;
	}

	public boolean isVarArg() {
		return false;
	}
}