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

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * A call to a function in a formula.
 * @author Einar Pehrson
 */
public class FunctionCall implements Expression {

	/** The unique version identifier used for serialization */
	private static final long serialVersionUID = 1666675675246822233L;

	/** The function that is called */
	private transient Function function;

	/** The arguments passed to the function */
	private Expression[] args;

	/**
	 * Creates a new function call.
	 * @param function the function that is called
	 * @param args the arguments passed to the function
	 * @throws IllegalFunctionCallException if the arguments passed to the function did not match its parameters
	 */
	public FunctionCall(Function function, Expression... args) throws IllegalFunctionCallException {
		// Stores members
		this.function = function;
		this.args = args;

		// Checks arguments against parameters
		FunctionParameter[] params = function.getParameters();
		for (int i = 0; i < args.length; i++)
			if (params.length <= i && !function.isVarArg())
				// Too many arguments
				throw new IllegalFunctionCallException(function, null, args[i]);
		for (int i = params.length - 1; i >= 0; i--)
			if (i >= args.length && !params[i].isOptional())
				// Too few arguments
				throw new IllegalFunctionCallException(function, params[i], null);
	}

	public Value evaluate() throws IllegalValueTypeException {
		return function.applyTo(args);
	}

	/**
	 * Returns the function that is called.
	 * @return the function that is called
	 */
	public Function getFunction() {
		return function;
	}

	/**
	 * Returns the arguments passed to the function.
	 * @return the arguments passed to the function
	 */
	public Expression[] getArguments() {
		return args;
	}

	public Object accept(ExpressionVisitor visitor) {
		return visitor.visitFunctionCall(this);
	}

	public String toString() {
		String string = function.getIdentifier().toUpperCase() + "(";
		for (int i = 0; i < args.length; i++) {
			string += args[i];
			if (i + 1 < args.length)
				string += "; ";
		}
		string += ")";
		return string;
	}

	/**
	 * Customizes deserialization by fetching the function from the language
	 * using the stored identifier.
	 * @param stream the object input stream from which the object is to be read
	 * @throws IOException If any of the usual Input/Output related exceptions occur
	 * @throws ClassNotFoundException If the class of a serialized object cannot be found.
	 */
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		String identifier = (String)stream.readObject();
		try {
			function = Language.getInstance().getFunction(identifier);
		} catch (UnknownElementException e) {
			throw new IOException(e.toString());
		}
	}

	/**
	 * Customizes serialization by only writing the identifer of the function.
	 * @param stream the object output stream to which the object is to be written
	 * @throws IOException If any of the usual Input/Output related exceptions occur
	 */
	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		stream.writeObject(function.getIdentifier());
	}
}