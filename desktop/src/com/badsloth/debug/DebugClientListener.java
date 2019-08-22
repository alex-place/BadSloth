package com.badsloth.debug;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import game.Bag;
import game.Logger;
import net.SomeResponse;

public class DebugClientListener extends Listener {
	Logger LOGGER = Bag.getLogger(DebugClientListener.class);

	@Override
	public void received(Connection connection, Object object) {
		if (object instanceof SomeResponse) {
			SomeResponse request = (SomeResponse) object;
			LOGGER.info(request.text);
		}
	}
}
