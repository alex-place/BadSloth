package com.badsloth.debug;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import net.SomeResponse;

public class DebugClientListener extends Listener {
	Logger LOGGER = LogManager.getLogger(DebugClientListener.class);

	@Override
	public void received(Connection connection, Object object) {
		if (object instanceof SomeResponse) {
			SomeResponse request = (SomeResponse) object;
			LOGGER.info(request.text);
		}
	}
}
