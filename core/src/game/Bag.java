package game;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Screen;

import components.PositionComponent;
import components.VelocityComponent;

public class Bag {
	
	public static final ComponentMapper<PositionComponent> position = ComponentMapper.getFor(PositionComponent.class);
	public static final ComponentMapper<VelocityComponent> velocity = ComponentMapper.getFor(VelocityComponent.class);
	public static PooledEngine engine = new PooledEngine();
	public static Screen activeScreen;
	private static Logger LOGGER = new Logger();
	
	
	
	public static void setScreen(Screen screen) {
		activeScreen = screen;
	}



	public static void init(Screen screen) {
		activeScreen = screen;
		activeScreen.show();
	}



	public static void dispose() {
		activeScreen.dispose();
		
	}



	public static void render(float delta) {
		activeScreen.render(delta);
	}



	public static Logger getLogger(Class clazz) {
		LOGGER.setClassName(clazz.getName());
		return LOGGER;
	}

}