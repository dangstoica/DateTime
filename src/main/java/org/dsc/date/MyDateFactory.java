package org.dsc.date;

/**
 * @author dan.stoica
 */

class MyDateFactory
{
		MyDate createDate(String formatedDate)
		{
				return new MyDate(getAsInteger(formatedDate, 0, 2), getAsInteger(formatedDate, 3, 5), getAsInteger(formatedDate, 6, 10));
		}

		private static int getAsInteger(String dateString, int startIndex, int endIndex)
		{
				return Integer.parseInt(dateString.substring(startIndex, endIndex));
		}
}
