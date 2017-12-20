package org.dsc.date;

/**
 * Extracts the start and end date from any input type.
 * Input type can be a string, a file, a stream or a remote web servies, RMI etc..
 *
 * @param <T>
 */
public interface InputParser<T>
{
		public String[] parse(T input) throws InvalidInputDateExpection;
}
