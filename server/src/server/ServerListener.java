package server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import core.pojos.SomeRequest;
import core.pojos.SomeResponse;

public class ServerListener extends Listener {
	
	Logger LOGGER = LogManager.getLogger(ServerListener.class);

	@Override
	public void received(Connection connection, Object object) {
		if (object instanceof SomeRequest) {
			SomeRequest request = (SomeRequest) object;
			LOGGER.info(request.text);

			SomeResponse response = new SomeResponse();
			response.text = "Thanks";
			connection.sendTCP(response);
		}
	}

}
