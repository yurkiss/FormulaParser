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

/**
 * A relational operator.
 * @author Einar Pehrson
 */
public abstract class RelationalOperator implements BinaryOperator {

	/**
	 * Creates a new relational operator.
	 */
	public RelationalOperator() {}

	public final Value applyTo(Expression leftOperand, Expression rightOperand) throws IllegalValueTypeException {
		Value leftValue = leftOperand.evaluate();
		switch (leftValue.getType()) {
			case NUMERIC:
				return new Value(compare(leftValue.toDouble(),
					rightOperand.evaluate().toDouble()));
			case TEXT:
				return new Value(compare(leftValue.toText(),
					rightOperand.evaluate().toText()));
			case BOOLEAN:
				return new Value(compare(leftValue.toBoolean(),
					rightOperand.evaluate().toBoolean()));
			case DATE:
				return new Value(compare(leftValue.toDate(),
					rightOperand.evaluate().toDate()));
			default:
				throw new IllegalValueTypeException(leftValue, Value.Type.NUMERIC);
		}
	}

	/**
	 * Applies the operator to the given operands and returns a boolean value.
	 * @param left the value of the left operand
	 * @param right the value of the right operand
	 * @return the result of the comparison
	 */
	public abstract <T> boolean compare(Comparable<T> left, T right);

	public Value.Type getOperandValueType() {
		return Value.Type.NUMERIC;
	}

	public String toString() {
		return getIdentifier();
	}
}