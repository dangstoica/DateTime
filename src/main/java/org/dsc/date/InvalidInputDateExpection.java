package org.dsc.date;

public class InvalidInputDateExpection extends RuntimeException
{
		private static final long serialVersionUID = 0L;

		public InvalidInputDateExpection()
		{
		}

		public InvalidInputDateExpection(String message)
		{
				super(message);
		}

}
