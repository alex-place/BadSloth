package server;

import java.io.IOException;

import com.esotericsoftware.kryonet.Server;

import game.Bag;
import game.Logger;
import register.SerializeRegister;

public class SlothServer extends Server{

	Logger LOGGER = Bag.getLogger(SlothServer.class);

	public void init() throws IOException {
		start();
		bind(45565, 45566);
		SerializeRegister.init(null, this);

	}

}