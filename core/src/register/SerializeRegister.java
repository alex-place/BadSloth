package register;


import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.Server;

import net.SomeRequest;
import net.SomeResponse;
import pojos.PositionComponent;

public class SerializeRegister {

	public static void register(Class type, EndPoint client_server) {
		if (client_server instanceof Server) {
			Server server = (Server) client_server;
			Kryo kryo = server.getKryo();
			kryo.register(SomeRequest.class);
			kryo.register(SomeResponse.class);
		}
		if (client_server instanceof Client) {
			Client client = (Client) client_server;
			Kryo kryo = client.getKryo();
			kryo.register(SomeRequest.class);
			kryo.register(SomeResponse.class);
		}
	}
	
	public static void init(Client client, Server server) {
		EndPoint endpoint = client != null ? client : server;
		if(endpoint == null)
			throw new IllegalArgumentException("Either a client or a server has to be in the param list");
		/**
		 * Begin registration of classes that are transmitted over the network. Please avoid nested objects and values at all costs.
		 * 
		 */
		register(SomeRequest.class, endpoint);
		register(SomeResponse.class, endpoint);
		register(PositionComponent.class, endpoint);
	}
}
