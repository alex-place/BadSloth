package server;

import game.Bag;
import game.Logger;

public class Main {

	public static void main(String[] args) throws Exception {
		ExceptionListener listener = new ExceptionListener();
		Thread.setDefaultUncaughtExceptionHandler(listener);
		Logger LOGGER = Bag.getLogger(Main.class);
		LOGGER.info("Launching Sloth Server");
		SlothServer server = new SlothServer();
		server.addListener(new ServerListener());
		server.init();
	}

}
