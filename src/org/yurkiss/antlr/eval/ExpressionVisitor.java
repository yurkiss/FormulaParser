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


import org.yurkiss.antlr.eval.operations.BinaryOperation;
import org.yurkiss.antlr.eval.operations.UnaryOperation;

/**
 * An interface for using the Visitor pattern for traversing expressions.
 * @author Einar Pehrson
 */
public interface ExpressionVisitor {

	/**
	 * Visits the given literal.
	 * @param literal the literal to visit
	 * @return an arbitrary object
	 */
	public Object visitLiteral(Literal literal);

	/**
	 * Visits the given unary expression.
	 * @param operation the operation to visit
	 * @return an arbitrary object
	 */
	public Object visitUnaryOperation(UnaryOperation operation);

	/**
	 * Visits the given binary expression.
	 * @param operation the operation to visit
	 * @return an arbitrary object
	 */
	public Object visitBinaryOperation(BinaryOperation operation);

	/**
	 * Visits the given cell reference.
	 * @param reference the reference to visit
	 * @return an arbitrary object
	 */
//	public Object visitReference(Reference reference);

	/**
	 * Visits the given function call.
	 * @param call the function call to visit
	 * @return an arbitrary object
	 */
	public Object visitFunctionCall(FunctionCall call);
}