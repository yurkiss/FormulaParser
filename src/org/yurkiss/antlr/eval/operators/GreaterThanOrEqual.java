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


import org.yurkiss.antlr.eval.Value;

/**
 * A relational greater-than-oe-equal operator.
 * @author Einar Pehrson
 */
public class GreaterThanOrEqual extends RelationalOperator {

	/** The unique version identifier used for serialization */
	private static final long serialVersionUID = -894273828901600176L;

	/**
	 * Creates a new relational greater-than-oe-equal operator.
	 */
	public GreaterThanOrEqual() {}

	public <T> boolean compare(Comparable<T> left, T right) {
		return left.compareTo(right) >= 0;
	}

	public String getIdentifier() {
		return ">=";
	}

	public Value.Type getOperandValueType() {
		return Value.Type.NUMERIC;
	}

	public String toString() {
		return getIdentifier();
	}
}