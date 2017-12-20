package org.dsc.date;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DateUtilsTest
{
		public Integer[] LEAP_YEARS = { 1904, 1908, 1912, 1916, 1920, 1924, 1928, 1932, 1936, 1940, 1944, 1948, 1952, 1956, 1960, 1964, 1968, 1972,
						1976, 1980, 1984, 1988, 1992, 1996, 2000, 2004, 2008, 2012, 2016, 2020
		};

		@Test
		public void testIsLeapYear() throws Exception
		{
				List<Integer> leapYears = IntStream.range(1901, 2021).parallel().filter(w -> DateUtils.isLeapYear((Integer) w)).boxed()
								.collect(Collectors.toList());

				assertEquals("\nFound :" + leapYears.size() + " leap years. Expected:" + LEAP_YEARS.length + " \nExpected Leap Years:" + Arrays
								.asList(LEAP_YEARS) + ".\n***Found Leap Years:" + leapYears, LEAP_YEARS.length, leapYears.size());

				assertArrayEquals("\nExpected Leap Years:" + Arrays.asList(LEAP_YEARS) + ". \n***Found Leap Years:" + leapYears, leapYears.toArray(),
								LEAP_YEARS);
				TestErrorLogger.success("Test 'IsLeapYear' Successful");
		}

		@Test
		public void testGetDaysToAndIncludingYear() throws Exception
		{
				for (int i = 1901; i < 2021; i++)
				{
						int daysToNextYear = DateUtils.getDaysToYear(i + 1);
						int daysToThisYear = DateUtils.getDaysToYear(i);
						int diffDays = daysToNextYear - daysToThisYear;
						boolean isLeapFirstYear = DateUtils.isLeapYear(i);
						boolean isLeapSecondYear = DateUtils.isLeapYear(i + 1);

						if (!isLeapFirstYear && !isLeapSecondYear)
						{
								assertEquals(diffDays + "." + daysToNextYear + " daysToNextYear. and " + daysToThisYear + " till this year.", 365,
												diffDays);
						}

						if (isLeapFirstYear && !isLeapSecondYear)
						{
								assertEquals(diffDays + "." + daysToNextYear + " daysToNextYear. and " + daysToThisYear + " till this year.", 366,
												diffDays);
						}

						if (!isLeapFirstYear && isLeapSecondYear)
						{
								assertEquals(diffDays + "." + daysToNextYear + " daysToNextYear. and " + daysToThisYear + " till this year.", 365,
												diffDays);
						}

				}

		}

		@Test
		public void testGetLeapYears() throws Exception
		{
				int leapYears = DateUtils.getLeapYears(2020);

				if (leapYears != LEAP_YEARS.length)
				{
						throw new Exception("Until 2020 we Found:" + leapYears + " leap years. Expected " + LEAP_YEARS.length);
				}
		}


}
