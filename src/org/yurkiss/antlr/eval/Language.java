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

import org.yurkiss.antlr.eval.functions.If;
import org.yurkiss.antlr.eval.functions.NumericFunction;
import org.yurkiss.antlr.eval.functions.Or;
import org.yurkiss.antlr.eval.functions.Sum;
import org.yurkiss.antlr.eval.operators.*;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A factory for creating certain types of language elements.
 *
 * @author Einar Pehrson
 */
public class Language {

    /**
     * The singleton instance
     */
    private static final Language instance = new Language();

    /**
     * The name of the file in which language properties are stored
     */
    private static final String PROPERTIES_FILENAME = "res/language.props";

    /**
     * The unary operators that are supported by the language
     */
    private List<UnaryOperator> unaryOperators = new ArrayList<UnaryOperator>();

    /**
     * The binary operators that are supported by the language
     */
    private List<BinaryOperator> binaryOperators = new ArrayList<BinaryOperator>();

    /**
     * The functions that are supported by the language
     */
    private List<Function> functions = new ArrayList<Function>();

    /**
     * Creates a new language.
     */
    private Language() {

        List<Class<? extends BinaryOperator>> binClasses =
                Arrays.asList(
                        Adder.class, Subtracter.class, Multiplier.class, Divider.class,
                        LessThan.class, GreaterThan.class, GreaterThanOrEqual.class, LessThanOrEqual.class,
                        Equal.class, Equal2.class, NotEqual.class,
                        Exponentiator.class
                );

        List<Class<? extends Function>> funcClasses =
                Arrays.asList(
                        Sum.class, If.class, Or.class
                );

        try {
            for (Class<? extends BinaryOperator> clazz : binClasses) {
                BinaryOperator instance = clazz.newInstance();
                binaryOperators.add(instance);
            }

            for (Class<? extends Function> clazz : funcClasses) {
                Function instance = clazz.newInstance();
                functions.add(instance);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

		// Loads static methods from java.lang.Math that use double precision
		for (Method method : Math.class.getMethods())
			if (Modifier.isStatic(method.getModifiers()) &&
						method.getReturnType() == Double.TYPE)
				functions.add(new NumericFunction(method));
    }

    /**
     * Returns the singleton instance.
     *
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
     *
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
     *
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
     *
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
     *
     * @return the functions that are supported by the syntax
     */
    public Function[] getFunctions() {
        return functions.toArray(new Function[functions.size()]);
    }
}