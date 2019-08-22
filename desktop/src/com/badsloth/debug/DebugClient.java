package com.badsloth.debug;

import java.io.IOException;

import com.esotericsoftware.kryonet.Client;

import game.Bag;
import game.Logger;
import net.SomeRequest;
import register.SerializeRegister;

public class DebugClient extends Client {

	Logger LOGGER = Bag.getLogger(DebugClient.class);

	public void init() throws IOException {
		start();
		connect(5000, "127.0.0.1", 45565, 45566);
		SerializeRegister.init(this, null);
	}

	public void testRequest() {
		SomeRequest request = new SomeRequest();
		request.text = "Here is the request";
		LOGGER.info(request.text);
		sendTCP(request);
	}

}
