package org.dsc.date;

/**
 * @author dan.stoica
 *
 */

public class MyDateFactory
{
		public MyDate createDate(String formatedDate)
		{
				String[] parts = formatedDate.split("/");
				MyDate date = new MyDate(getAsInteger(parts[0]), getAsInteger(parts[1]), getAsInteger(parts[2]));
				return date;
		}

		public static int getAsInteger(String part)
		{
				return Integer.parseInt(part);
		}
}
