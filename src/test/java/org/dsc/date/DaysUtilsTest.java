package org.dsc.date;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;

/**
 * Test cases:
 * (DD/MM/YYYY)
 * 1. 02/06/1983 - 22/06/1983: 19 days
 * 2. 04/07/1984 - 25/12/1984: 173 days
 * 3. 03/01/1989 - 03/08/1983: 1979 days
 * <p>
 * The first and the last day are considered partial days and never counted.
 * Following this logic, an event that has run from 07/11/1972 and 08/11/1972 should return 0,
 * because there are no fully elapsed days contained in between those dates, and 01/01/2000 to 03/01/2000 should return 1.
 * The solution needs to cater for all valid dates between 01/01/1901 and 31/12/2999.
 */

public class DaysUtilsTest
{
		private static final String[] testDate = { "02/06/1983 - 22/06/1983", "04/07/1984 - 25/12/1984", "03/01/1989 - 03/08/1983",
						"01/01/2000 - 03/01/2000", "07/11/1972 - 08/11/1972"
		};
		private static final Integer[] expectedDays = { 19, 173, 1979, 1, 0 };

		@Test
		public void testFindDays() throws Exception
		{
				DaysUtils finder = new DaysUtils();

				List<Integer> result = Arrays.stream(testDate).map(dateRange -> finder.findElapsedDays(dateRange)).collect(Collectors.toList());
				assertArrayEquals("Expected:" + Arrays.asList(expectedDays) + ". Found:" + result, expectedDays, result.toArray());
				TestErrorLogger.success("Test 'findDays' Successful");

		}

}