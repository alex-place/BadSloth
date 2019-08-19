package server;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.esotericsoftware.kryonet.Server;

import register.SerializeRegister;

public class SlothServer extends Server{

	Logger LOGGER = LogManager.getLogger(SlothServer.class);

	public void init() throws IOException {
		start();
		bind(45565, 45566);
		SerializeRegister.init(null, this);

	}

}