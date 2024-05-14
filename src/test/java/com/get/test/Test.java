package com.get.test;

import com.get.lib.Logging.Loggy;
import com.get.lib.Logging.Loggy.Level;

public class Test {

	public static void mainny(String...strings) throws InterruptedException {
		Loggy l = Loggy.getLoggy(null, true, true);
		
		l.log(Level.ALL, l);
		l.log(Level.TRACE, l);
		l.log(Level.DEBUG, l);
		l.log(Level.INFO, l);
		l.log(Level.WARN, l);
		l.log(Level.ERROR, l);
		l.log(Level.FATAL, l);
		
		Thread.sleep(1000L);
		
		l.log(Level.ALL, l, l, l);
		l.log(Level.TRACE, l, l, l);
		l.log(Level.DEBUG, l, l, l);
		l.log(Level.INFO, l, l, l);
		l.log(Level.WARN, l, l, l);
		l.log(Level.ERROR, l, l, l);
		l.log(Level.FATAL, l, l, l);
	}
}
