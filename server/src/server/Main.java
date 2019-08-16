package server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

	public static void main(String[] args) throws Exception {
		ExceptionListener listener = new ExceptionListener();
		Thread.setDefaultUncaughtExceptionHandler(listener);
		Logger LOGGER = LogManager.getLogger(Main.class);
		LOGGER.info("Launching Sloth Server");
		SlothServer server = new SlothServer();
		server.addListener(new ServerListener());
		server.init();
	}

}
