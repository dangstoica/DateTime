package org.dsc.date;

public class Day
{
		private final int day;

		protected Day(int day)
		{
				this.day = day;
		}

		public int getDay()
		{
				return day;
		}

		@Override
		public boolean equals(Object o)
		{
				if (this == o)
						return true;
				if (o == null || getClass() != o.getClass())
						return false;

				Day day1 = (Day) o;

				return day == day1.day;
		}

		@Override
		public int hashCode()
		{
				return day;
		}

		@Override
		public String toString()
		{
				return "Day{" + "day=" + day + '}';
		}
}
