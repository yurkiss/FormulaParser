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

import java.io.Serializable;
import java.text.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A typed value that a cell can contain.
 * @author Einar Pehrson
 */
public class Value implements Comparable<Value>, Serializable {

	/** The unique version identifier used for serialization */
	private static final long serialVersionUID = 7140236908025236588L;

	/** The recognized types of values */
	public enum Type {

		/** Denotes a value of undefined type */
		UNDEFINED,

		/** Denotes a numeric value, with or without decimals */
		NUMERIC,

		/** Denotes a text value, or a type of value derived from text */
		TEXT,

		/** Denotes a boolean value, i.e. true or false */
		BOOLEAN,

		/** Denotes a date, time or date/time value */
		DATE,

		/** Denotes a row vector, column vector or two-dimensional matrix of values */
		MATRIX,

		/** Denotes an error, e.g. a type mismatch */
		ERROR
	}

	/** The value */
	private Serializable value;

	/** The type of the value */
	private Type type = Type.UNDEFINED;

	/**
	 * Creates a null value.
	 */
	public Value() {}

	/**
	 * Creates a numeric value.
	 * @param number the number of the value
	 */
	public Value(Number number) {
		this.type = Type.NUMERIC;
		if ((number instanceof Float || number instanceof Double)
			&& number.doubleValue() == number.longValue())
			this.value = number.longValue();
		else
			this.value = number;
	}

	/**
	 * Creates a text value.
	 * @param text the text of the value
	 */
	public Value(String text) {
		this.type = Type.TEXT;
		this.value = text;
	}

	/**
	 * Creates a boolean value.
	 * @param booleanValue the boolean of the value
	 */
	public Value(Boolean booleanValue) {
		this.type = Type.BOOLEAN;
		this.value = booleanValue;
	}

	/**
	 * Creates a date value.
	 * @param date the date of the value
	 */
	public Value(Date date) {
		this.type = Type.DATE;
		this.value = date;
	}

	/**
	 * Creates a one-dimensional matrix value (vector).
	 * @param matrix the value vector
	 */
	public Value(Value[] matrix) {
		this(new Value[][] {matrix});
	}

	/**
	 * Creates a two-dimensional matrix value.
	 * @param matrix the value matrix
	 */
	public Value(Value[][] matrix) {
		this.type = Type.MATRIX;
		this.value = matrix;
	}

	/**
	 * Creates an error value.
	 * @param error the error of the value
	 */
	public Value(Throwable error) {
		this.type = Type.ERROR;
		this.value = error;
	}

	/**
	 * Returns the value in untyped form.
	 * @return the value
	 */
	public final Object toAny() {
		return value;
	}

	/**
	 * Returns the type of the value.
	 * @return the type of the value
	 */
	public final Type getType() {
		return type;
	}

	/**
	 * Returns whether the value is of the given type.
	 * @param type the type of value to check against
	 * @return whether the value is of the given type
	 */
	public final boolean isOfType(Type type) {
		return this.type == type;
	}

	/**
	 * Returns a numeric representation of the value.
	 * @return a numeric representation of the value
	 * @throws IllegalValueTypeException if the value cannot be converted to this type
	 */
	public Number toNumber() throws IllegalValueTypeException {
		if (type == Type.NUMERIC)
			return (Number)value;
		else
			throw new IllegalValueTypeException(this, Type.NUMERIC);
	}

	/**
	 * Returns a primitive numeric representation of the value.
	 * @return a primitive numeric representation of the value
	 * @throws IllegalValueTypeException if the value cannot be converted to this type
	 */
	public double toDouble() throws IllegalValueTypeException{
		return toNumber().doubleValue();
	}

	/**
	 * Returns a text representation of the value.
	 * @return a text representation of the value
	 * @throws IllegalValueTypeException if the value cannot be converted to this type
	 */
	public String toText() throws IllegalValueTypeException {
		if (type == Type.TEXT)
			return (String)value;
		else
			throw new IllegalValueTypeException(this, Type.TEXT);
	}

	/**
	 * Returns a boolean representation of the value.
	 * @return a boolean representation of the value
	 * @throws IllegalValueTypeException if the value cannot be converted to this type
	 */
	public Boolean toBoolean() throws IllegalValueTypeException {
		if (type == Type.BOOLEAN)
			return (Boolean)value;
		else
			throw new IllegalValueTypeException(this, Type.BOOLEAN);
	}

	/**
	 * Returns a date representation of the value.
	 * @return a date representation of the value
	 * @throws IllegalValueTypeException if the value cannot be converted to this type
	 */
	public Date toDate() throws IllegalValueTypeException {
		if (type == Type.DATE)
			return (Date)value;
		else
			throw new IllegalValueTypeException(this, Type.DATE);
	}

	/**
	 * Returns a matrix representation of the value.
	 * @return a matrix representation of the value
	 * @throws IllegalValueTypeException if the value cannot be converted to this type
	 */
	public Value[][] toMatrix() throws IllegalValueTypeException {
		if (type == Type.MATRIX)
			return (Value[][])value;
		else
			throw new IllegalValueTypeException(this, Type.MATRIX);
	}

	/**
	 * Returns an error representation of the value.
	 * @return an error representation of the value
	 * @throws IllegalValueTypeException if the value cannot be converted to this type
	 */
	public Throwable toError() throws IllegalValueTypeException {
		if (type == Type.ERROR)
			return (Throwable)value;
		else
			throw new IllegalValueTypeException(this, Type.ERROR);
	}

	/**
	 * Compares this value with the given value for order.
	 * @param otherValue the value to compare to
	 * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
	 */
	public int compareTo(Value otherValue) {
		if (type == otherValue.getType())
			try {
				switch (type) {
					case NUMERIC:
						return ((Double)toDouble()).compareTo(otherValue.toDouble());
					case TEXT:
						return toText().compareTo(otherValue.toText());
					case BOOLEAN:
						return toBoolean().compareTo(otherValue.toBoolean());
					case DATE:
						return toDate().compareTo(otherValue.toDate());
					case MATRIX:
						return Arrays.hashCode((Object[])otherValue.toAny()) - Arrays.hashCode((Object[])value);
					default:
						return 0;
				}
			} catch (IllegalValueTypeException e) {
				return -1;
			}
		else
			return type.compareTo(otherValue.getType());
	}

	/**
	 * Returns whether the other object is an identical value .
	 * @param other the object to check for equality
	 * @return true if the objects are equal
	 */
	public boolean equals(Object other) {
		if (!(other instanceof Value) || other == null)
			return false;
		Value otherValue = (Value)other;
		boolean nulls = value == null && otherValue.value == null;
		return type == otherValue.type 
		   && (nulls || (!nulls && value.equals(otherValue.value)));
	}

	/**
	 * Returns a string representation of the value.
	 * @return a string representation of the value
	 */
	public String toString() {
		if (value != null)
			switch (type) {
				case BOOLEAN:
					return value.toString().toUpperCase();
				case DATE:
					return DateFormat.getDateTimeInstance(
						DateFormat.SHORT, DateFormat.SHORT).format((Date)value);
				case MATRIX:
					Value[][] matrix = (Value[][])value;
					String string = "{";
					for (int row = 0; row < matrix.length; row++) {
						for (int column = 0; column < matrix[row].length; column++) {
							string += matrix[row][column];
							if (column + 1 < matrix[row].length)
								string += ";";
						}
						if (row + 1 < matrix.length)
							string += ";\n";
					}
					string += "}";
					return string;
				default:
					return value.toString();
			}
		else
			return "";
	}

	/**
	 * Returns a string representation of the value, using the given date or
	 * number format.
	 * @param format the format to use when converting the value 
	 * @return a string representation of the value
	 */
	public String toString(Format format) {
		if (value != null)
			switch (type) {
				case NUMERIC:
					if (format instanceof NumberFormat)
						return format.format((Number)value);
					else
						return value.toString();
				case DATE:
					if (format instanceof DateFormat)
						return format.format((Date)value);
				default:
					return value.toString();
			}
		return "";
	}

	/**
	 * Attempts to parse a value from the given string. The value is matched
	 * against the given types in order. If no types are supplied, conversion
	 * will be attempted to boolean, date and numeric values. If no other
	 * type matches, the value will be used as a string.
	 * @param value the value
	 * @param types the types for which parsing should be attempted
	 */
	public static Value parseValue(String value, Type... types) {
		// Uses default types
		if (types.length == 0)
			types = new Type[] {Type.BOOLEAN, Type.DATE, Type.NUMERIC};

		for (int i = 0; i < types.length; i++)
			switch (types[i]) {
				case BOOLEAN:
					try {
						return parseBooleanValue(value);
					} catch (ParseException e) {}
					break;

				case DATE:
					try {
						return parseDateValue(value);
					} catch (ParseException e) {}
					break;
	
				case NUMERIC:
					try {
						return parseNumericValue(value);
					} catch (ParseException e) {}
					break;
			}

		// Uses the string as the value
		return new Value(value);
	}

	/**
	 * Attempts to parse a number from the given string.
	 * @param value the value
	 * @return the numeric value that was found
	 * @throws IllegalValueTypeException if no numeric value was found
	 */
	public static Value parseNumericValue(String value) throws ParseException {
		ParsePosition position = new ParsePosition(0);
		Number number = NumberFormat.getInstance().parse(value, position);
		if (position.getIndex() == value.length())
			return new Value(number);
		throw new ParseException(value, position.getErrorIndex());
	}

	/**
	 * Attempts to parse a boolean from the given string.
	 * @param value the value
	 * @return the boolean value that was found
	 * @throws IllegalValueTypeException if no boolean value was found
	 */
	public static Value parseBooleanValue(String value) throws ParseException {
		if (value.equalsIgnoreCase("true"))
			return new Value(true);
		else if (value.equalsIgnoreCase("false"))
			return new Value(false);
		else
			throw new ParseException(value, 0);
	}

	/**
	 * Attempts to parse a date, time or date/time from the given string.
	 * @param value the value
	 * @return the date value that was found
	 * @throws IllegalValueTypeException if no date value was found
	 */
	public static Value parseDateValue(String value) throws ParseException {
		ParsePosition position = new ParsePosition(0);

		// Attempts to parse a date or date/time
		DateFormat[] dateFormats = new DateFormat[] {
			DateFormat.getDateInstance(DateFormat.SHORT),
			DateFormat.getDateInstance(DateFormat.MEDIUM),
			DateFormat.getDateInstance(DateFormat.LONG),
			DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT),
			DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT),
			DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM),
			DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM)
		};
		for (DateFormat format : dateFormats) {
			Date date = format.parse(value, position);
			if (position.getIndex() == value.length())
				return new Value(date);
			else if (position.getIndex() > 0)
				position.setIndex(0);
		}

		// Attempts to parse a time in the current day
		DateFormat[] timeFormats = new DateFormat[] {
			DateFormat.getTimeInstance(DateFormat.SHORT),
			DateFormat.getTimeInstance(DateFormat.MEDIUM),
			DateFormat.getTimeInstance(DateFormat.LONG)
		};
		for (int i = 0; i < timeFormats.length; i++) {
			Calendar datetime = new GregorianCalendar();
			Date date = timeFormats[i].parse(value, position);
			if (position.getIndex() == value.length()) {
				datetime.setTime(date);
				Calendar today = new GregorianCalendar();
				datetime.set(
					today.get(Calendar.YEAR), 
					today.get(Calendar.MONTH), 
					today.get(Calendar.DAY_OF_MONTH)
				);
				return new Value(datetime.getTime());
			} else if (position.getIndex() > 0)
				position.setIndex(0);
		}
		throw new ParseException(value, position.getErrorIndex());
	}
}