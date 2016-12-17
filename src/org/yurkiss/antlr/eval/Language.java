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

import java.util.ArrayList;
import java.util.List;

/**
 * A factory for creating certain types of language elements.
 * @author Einar Pehrson
 */
public class Language {

	/** The singleton instance */
	private static final Language instance = new Language();

	/** The name of the file in which language properties are stored */
	private static final String PROPERTIES_FILENAME = "res/language.props";

	/** The unary operators that are supported by the language */
//	private List<UnaryOperator> unaryOperators = new ArrayList<UnaryOperator>();

	/** The binary operators that are supported by the language */
	private List<BinaryOperator> binaryOperators = new ArrayList<BinaryOperator>();

	/** The functions that are supported by the language */
	private List<Function> functions = new ArrayList<Function>();

	/**
	 * Creates a new language.
	 */
	private Language() {
//		// Loads properties
//		Properties language = new Properties();
//		InputStream stream = CleanSheets.class.getResourceAsStream(PROPERTIES_FILENAME);
//		if (stream != null) {
//			try {
//				language.load(stream);
//			} catch (IOException e) {
//				System.err.println("An I/O error occurred when loading language"
//					+ " properties file (" + PROPERTIES_FILENAME + ").");
//				return;
//			} finally {
//				try {
//					if (stream != null)
//						stream.close();
//				} catch (IOException e) {}
//			}
//
//			// Loads elements
//			for (Object className : language.keySet()) {
//				// Loads class and instantiates element
//				Class elementClass;
//				Object element;
//				try {
//					elementClass = Class.forName(getClass().getPackage()
//						.getName() + "." + (String)className);
//					element = elementClass.newInstance();
//				} catch (Exception e) {
//					// Skip this element, regardless of what went wrong
//					continue;
//				}
//
//				// Stores element
//				if (Function.class.isAssignableFrom(elementClass))
//					functions.add(Function.class.cast(element));
//				if (BinaryOperator.class.isAssignableFrom(elementClass))
//					binaryOperators.add(BinaryOperator.class.cast(element));
//				if (UnaryOperator.class.isAssignableFrom(elementClass))
//					unaryOperators.add(UnaryOperator.class.cast(element));
//			}
//		} else
//			System.err.println("Could not find language properties file ("
//				+ PROPERTIES_FILENAME + ").");
//
//		// Loads static methods from java.lang.Math that use double precision
//		for (Method method : Math.class.getMethods())
//			if (Modifier.isStatic(method.getModifiers()) &&
//						method.getReturnType() == Double.TYPE)
//				functions.add(new NumericFunction(method));
	}

	/**
	 * Returns the singleton instance.
	 * @return the singleton instance
	 */
	public static Language getInstance() {
		return instance;
	}

	/**
	 * Returns the unary operator with the given identifier.
	 * @return the unary operator with the given identifier
	 */
//	public UnaryOperator getUnaryOperator(String identifier) throws UnknownElementException {
//		for (UnaryOperator operator : unaryOperators)
//			if (identifier.equalsIgnoreCase(operator.getIdentifier()))
//				return operator; // .clone()
//		throw new UnknownElementException(identifier);
//	}

	/**
	 * Returns the binary operator with the given identifier.
	 * @return the binary operator with the given identifier
	 */
	public BinaryOperator getBinaryOperator(String identifier) throws UnknownElementException {
		for (BinaryOperator operator : binaryOperators)
			if (identifier.equalsIgnoreCase(operator.getIdentifier()))
				return operator; // .clone()
		throw new UnknownElementException(identifier);
	}

	/**
	 * Returns the function with the given identifier.
	 * @return the function with the given identifier
	 */
	public Function getFunction(String identifier) throws UnknownElementException {
		for (Function function : functions)
			if (identifier.equalsIgnoreCase(function.getIdentifier()))
				return function; // .clone()
		throw new UnknownElementException(identifier);
	}

	/**
	 * Returns whether there is a function with the given identifier.
	 * @return whether there is a function with the given identifier
	 */
	public boolean hasFunction(String identifier) {
		try {
			return getFunction(identifier) != null;
		} catch (UnknownElementException e) {
			return false;
		}
	}

	/**
	 * Returns the functions that are supported by the syntax.
	 * @return the functions that are supported by the syntax
	 */
	public Function[] getFunctions() {
		return functions.toArray(new Function[functions.size()]);
	}
}