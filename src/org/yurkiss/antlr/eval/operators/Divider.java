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
package org.yurkiss.antlr.eval.operators;


import org.yurkiss.antlr.eval.BinaryOperator;
import org.yurkiss.antlr.eval.Expression;
import org.yurkiss.antlr.eval.IllegalValueTypeException;
import org.yurkiss.antlr.eval.Value;
import org.yurkiss.antlr.eval.functions.DivisionByZeroException;

/**
 * A divider.
 * @author Einar Pehrson
 */
public class Divider implements BinaryOperator {

	/** The unique version identifier used for serialization */
	private static final long serialVersionUID = -1518353526200870461L;

	/**
	 * Creates a new divider.
	 */
	public Divider() {}

	public Value applyTo(Expression leftOperand, Expression rightOperand) throws IllegalValueTypeException {
		double divisor = rightOperand.evaluate().toDouble();
		if (divisor != 0)
			return new Value(leftOperand.evaluate().toDouble() / divisor);
		else
			return new Value(new DivisionByZeroException(rightOperand));
	}

	public String getIdentifier() {
		return "/";
	}

	public Value.Type getOperandValueType() {
		return Value.Type.NUMERIC;
	}

	public String toString() {
		return getIdentifier();
	}
}