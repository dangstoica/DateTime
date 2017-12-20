package org.dsc.date;

public class TestErrorLogger
{
		public final static void log(String message, Exception e)
		{
				System.out.println(message);
				e.printStackTrace();
		}

		public final static void success(String message)
		{
				System.out.println("Success::" + message);
		}

}
