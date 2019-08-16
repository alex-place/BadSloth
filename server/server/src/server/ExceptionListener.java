package server;

import java.lang.Thread.UncaughtExceptionHandler;

import org.apache.log4j.Logger;

public class ExceptionListener implements UncaughtExceptionHandler{

	Logger LOGGER = Logger.getLogger(ExceptionListener.class);
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		LOGGER.fatal(e.getClass().getName() + " was thrown thread: " + t.getName() , e);
	}

}
