package org.dsc.date;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

public class MyDateFactoryTest
{
		Random randomGen = ThreadLocalRandom.current();

		@Test
		public void testCreateDate() throws Exception
		{

				int day = randomGen.nextInt(31) + 1;
				int month = randomGen.nextInt(12) + 1;
				int year = randomGen.nextInt(1098) + 1901;

				MyDateFactory dateFactory = new MyDateFactory();
				MyDate date = dateFactory.createDate(day + "/" + month + "/" + year);
				assertEquals("Expected " + day + " Found: " + date.getDay(), day, date.getDay().getDay());
				assertEquals("Expected month" + month + " Found: " + date.getMonth(), month, date.getMonth().getMonth());
				assertEquals("Expected year:" + year + " Found: " + date.getYear(), year, date.getYear().getYear());
		}

}