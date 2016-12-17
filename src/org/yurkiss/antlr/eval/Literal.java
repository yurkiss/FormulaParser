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
 * A literal value in a formula.
 * @author Einar Pehrson
 */
public class Literal implements Expression {

	/** The unique version identifier used for serialization */
	private static final long serialVersionUID = 7854180857828149858L;

	/** The value of the literal */
	private Value value;

	/**
	 * Creates a new literal.
	 * @param value the value of literal
	 */
	public Literal(Value value) {
		this.value = value;
	}

	public Value evaluate() {
		return value;
	}

	/**
	 * Returns the value of the literal.
	 * @return the value of the literal
	 */
	public Value getValue() {
		return value;
	}

	public Object accept(ExpressionVisitor visitor) {
		return visitor.visitLiteral(this);
	}

	public String toString() {
		if (value.getType() == Value.Type.TEXT
		 || value.getType() == Value.Type.DATE)
			return "\"" + value.toString() + "\"";
		else
			return value.toString();
	}
}