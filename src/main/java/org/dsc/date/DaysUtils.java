package org.dsc.date;

/**
 * @author dan.stoica
 */
public class DaysUtils
{
		private MyDateFactory dateFactory = new MyDateFactory();
		private InputParser inputParser = new SimpleInputParser();

		public int findElapsedDays(String startDateIn, String endDateIn)
		{
				MyDate startDate = dateFactory.createDate(startDateIn);
				MyDate endDate = dateFactory.createDate(endDateIn);
				int days = DateUtils.daysBetween(endDate, startDate);

				return days > 0 ? days : 0;
		}

		public int findElapsedDays(String dates) throws InvalidInputDateExpection
		{
				String[] datesParts = inputParser.parse(dates);
				return findElapsedDays(datesParts[0], datesParts[1]);
		}

		public static void main(String[] args)
		{
				DaysUtils utils = new DaysUtils();
				System.out.println(utils.findElapsedDays(args[0], args[2]));
		}
}