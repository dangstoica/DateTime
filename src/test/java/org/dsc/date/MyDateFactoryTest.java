package org.dsc.date;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;

public class MyDateFactoryTest
{
		private Random randomGen = ThreadLocalRandom.current();

		@Test
		public void testCreateDate() throws Exception
		{

				int day = randomGen.nextInt(21) + 10;
				int month = randomGen.nextInt(2) + 10;
				int year = randomGen.nextInt(1098) + 1901;

				MyDateFactory dateFactory = new MyDateFactory();
				do
				{
						doCreateDate(day, month, year, dateFactory);

						day = randomGen.nextInt(31) + 1;
						month = randomGen.nextInt(12) + 1;
						year = randomGen.nextInt(1098) + 1901;
						doCreateDate(day, month, year, dateFactory);

				}
				while (day > 9 || month > 9);
		}

		private void doCreateDate(int day, int month, int year, MyDateFactory dateFactory)
		{
				String formatedDate = (day < 10 ? "0" + day : day) + "/" + (month < 10 ? "0" + month : month) + "/" + year;
				MyDate date = dateFactory.createDate(formatedDate);
				assertEquals("Expected " + day + " Found: " + date.getDay(), day, date.getDay().getDay());
				assertEquals("Expected month" + month + " Found: " + date.getMonth(), month, date.getMonth().getMonth());
				assertEquals("Expected year:" + year + " Found: " + date.getYear(), year, date.getYear().getYear());
		}

}