package org.dsc.date;

/**
 * @author dan.stoica
 */
public class Month
{
		public static int[] daysToMonth = { 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };
		public static int[] daysToMonthLeap = { 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366 };

		private final int month;

		protected Month(int month)
		{
				this.month = month;
		}

		public int getMonth()
		{
				return month;
		}

		protected int getDaysToMonth(boolean isLeapYear)
		{
				return isLeapYear ? daysToMonthLeap[month - 1] : daysToMonth[month - 1];
		}

		@Override
		public boolean equals(Object o)
		{
				if (this == o)
						return true;
				if (o == null || getClass() != o.getClass())
						return false;

				Month month1 = (Month) o;

				return month == month1.month;
		}

		@Override
		public int hashCode()
		{
				return month;
		}

		@Override
		public String toString()
		{
				return "Month{" + "month=" + month + '}';
		}
}
