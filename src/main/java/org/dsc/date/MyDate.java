package org.dsc.date;

/**
 * @author dan.stoica
 */
public class MyDate
{
		private final Year year;
		private final Month month;
		private final Day day;

		public MyDate(int day, int month, int year)
		{
				this.year = new Year(year);
				this.month = new Month(month);
				this.day = new Day(day);
		}

		public Year getYear()
		{
				return year;
		}

		public Month getMonth()
		{
				return month;
		}

		public Day getDay()
		{
				return day;
		}

		/**
		 * @return total number of days days from 1900
		 */
		public int getDays()
		{
				return this.day.getDay() + this.month.getDaysToMonth(this.year.isLeapYear()) + DateUtils.getDaysToYear(this.year.getYear());
		}

		@Override
		public boolean equals(Object o)
		{
				if (this == o)
						return true;
				if (o == null || getClass() != o.getClass())
						return false;

				MyDate myDate = (MyDate) o;

				if (year != null ? !year.equals(myDate.year) : myDate.year != null)
						return false;
				if (month != null ? !month.equals(myDate.month) : myDate.month != null)
						return false;
				return day != null ? day.equals(myDate.day) : myDate.day == null;
		}

		@Override
		public int hashCode()
		{
				int result = year != null ? year.hashCode() : 0;
				result = 31 * result + (month != null ? month.hashCode() : 0);
				result = 31 * result + (day != null ? day.hashCode() : 0);
				return result;
		}

		@Override
		public String toString()
		{
				return "MyDate{" + "year=" + year + ", month=" + month + ", day=" + day + '}';
		}

}
