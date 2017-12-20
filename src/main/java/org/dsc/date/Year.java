package org.dsc.date;

/**
 * @author dan.stoica
 */
public class Year
{
		private final int year;

		protected Year(int year)
		{
				this.year = year;
		}

		public int getYear()
		{
				return year;
		}

		public boolean isLeapYear()
		{
				return DateUtils.isLeapYear(year);
		}

		@Override
		public boolean equals(Object o)
		{
				if (this == o)
						return true;
				if (o == null || getClass() != o.getClass())
						return false;

				Year year1 = (Year) o;

				return year == year1.year;
		}

		@Override
		public int hashCode()
		{
				return year;
		}

		@Override
		public String toString()
		{
				return "Year{" + "year=" + year + '}';
		}
}