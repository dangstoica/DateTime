package org.dsc.logger;

public class Logger
{
		public static boolean DEBUG = false;
		public String name;

		private Logger(String name)
		{
				this.name = name;
		}

		public final void log(String msg)
		{
				if (DEBUG)
				{
						System.out.println(name + "::" + msg);
				}
		}

		public static Logger create(Class clazz)
		{
				return new Logger(clazz.getName());
		}
}
