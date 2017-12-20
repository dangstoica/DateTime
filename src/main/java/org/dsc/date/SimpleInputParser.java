package org.dsc.date;

public class SimpleInputParser implements InputParser<String>
{
		@Override
		public String[] parse(String input) throws InvalidInputDateExpection
		{
				return new String[] { input.substring(0, 10), input.substring(13, 23) };
		}
}
