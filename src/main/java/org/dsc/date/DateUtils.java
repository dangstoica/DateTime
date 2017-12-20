package org.dsc.date;

import org.dsc.logger.Logger;

import java.util.stream.IntStream;


/**
 * @author dan.stoica
 *
 */
public class DateUtils
{
		public static final int START_YEAR = 1900;
		static Logger logger = Logger.create(DateUtils.class);

		/**
		 * Algorithm
		 * <p>
		 * The following pseudocode determines whether a year is a leap year or
		 * a common year in the Gregorian calendar (and in the proleptic Gregorian calendar before 1582).
		 * The year variable being tested is the integer representing the number of the year in the Gregorian calendar,
		 * and the tests are arranged to dispatch the most common cases first.
		 * Care should be taken in translating mathematical integer divisibility into specific programming languages.
		 * <p>
		 * <p>
		 * if (year is not divisible by 4) then (it is a common year)
		 * else if (year is not divisible by 100) then (it is a leap year)
		 * else if (year is not divisible by 400) then (it is a common year)
		 * else (it is a leap year)
		 *
		 * @param year
		 * @return true if it's a leap year
		 */
		public static boolean isLeapYear(int year)
		{
				return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
		}

		public static int getDaysToYear(int year)
		{
				return getDaysToAndIncludingYear(year - 1);
		}

		public static int getDaysToAndIncludingYear(int year)
		{
				int leapYears = getLeapYears(year);
				int days = leapYears * 366 + (year - leapYears- START_YEAR) * 365;
				return days;
		}

		public static int getLeapYears(int year)
		{
				long sum = IntStream.range(START_YEAR, year + 1).parallel().filter(w -> isLeapYear(w)).count();
				return (int) sum;
		}

		/**
		 * Calculate the number of full days elapsed in between the two start and end dates or an event.
		 * The first and the last day are considered partial days and never counted.
		 * Following this logic, an event that has run from 07/11/1972 and 08/11/1972 should return 0,
		 * because there are no fully elapsed days contained in between those dates, and 01/01/2000 to 03/01/2000 should return 1.
		 *
		 * @param firstDate
		 * @param secondDate
		 * @return the number of full days elapsed in between the two dates
		 */
		public static int daysBetween(MyDate firstDate, MyDate secondDate)
		{
				logger.log("first date:" + firstDate + ". secondDate:" + secondDate);
				return Math.abs(secondDate.getDays() - firstDate.getDays()) - 1;
		}
}
