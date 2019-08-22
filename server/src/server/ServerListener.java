package server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import game.Bag;
import game.Logger;
import net.SomeRequest;
import net.SomeResponse;

public class ServerListener extends Listener {
	
	Logger LOGGER = Bag.getLogger(ServerListener.class);

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
