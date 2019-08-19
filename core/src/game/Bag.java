package game;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Screen;

import pojos.PositionComponent;
import pojos.VelocityComponent;

public class Bag {
	
	public static final ComponentMapper<PositionComponent> position = ComponentMapper.getFor(PositionComponent.class);
	public static final ComponentMapper<VelocityComponent> velocity = ComponentMapper.getFor(VelocityComponent.class);
	public static Engine engine = new Engine();
	public static Screen activeScreen;
	
	
	
	public static void setScreen(Screen screen) {
		activeScreen = screen;
	}

}