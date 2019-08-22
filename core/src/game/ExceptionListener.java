package game;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionListener implements UncaughtExceptionHandler{

	Logger LOGGER = Bag.getLogger(ExceptionListener.class);
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		LOGGER.fatal(e.getClass().getName() + " was thrown thread: " + t.getName() , e);
	}

}
