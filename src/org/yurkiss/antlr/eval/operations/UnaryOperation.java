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
package org.yurkiss.antlr.eval.operations;


import org.yurkiss.antlr.eval.*;

/**
 * A unary operation in a formula.
 * @author Einar Pehrson
 */
public class UnaryOperation extends Operation<UnaryOperator> {

	/** The unique version identifier used for serialization */
	private static final long serialVersionUID = -1630292510063782201L;

	/** The operand */
	private Expression operand;

	/**
	 * Creates a new unary operation.
	 * @param operator the unary operator
	 * @param operand the operand
	 */
	public UnaryOperation(UnaryOperator operator, Expression operand) {
		super(operator);
		this.operand = operand;
	}

	public Value evaluate() throws IllegalValueTypeException {
		return operator.applyTo(operand);
	}

	/** 
	 * Returns the operand.
	 * @return an expression tree representing the operand
	 */
	public Expression getOperand() {
		return operand;
	}

	public Object accept(ExpressionVisitor visitor) {
		return visitor.visitUnaryOperation(this);
	}

	public String toString() {
		if (operator.isPrefix())
			return operator + operand.toString();
		else
			return operand + operator.toString();
	}
}