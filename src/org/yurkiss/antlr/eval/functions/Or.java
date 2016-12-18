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
 * A function that returns true if any of its arguments are true.
 * @author Einar Pehrson
 */
public class Or implements Function {

	/** The only (but repeatable) parameter: a boolean expression */
	public static final FunctionParameter[] parameters = new FunctionParameter[] {
		new FunctionParameter(Value.Type.BOOLEAN, "Boolean expression", false,
			"A boolean expression to include")
	};

	/**
	 * Creates a new instance of the OR function.
	 */
	public Or() {}

	public String getIdentifier() {
		return "OR";
	}

	public Value applyTo(Expression[] arguments) throws IllegalValueTypeException {
		for (Expression argument : arguments)
			if (argument.evaluate().toBoolean())
				return new Value(true);
		return new Value(false);
	}

	public FunctionParameter[] getParameters() {
		return parameters;
	}

	public boolean isVarArg() {
		return true;
	}
}