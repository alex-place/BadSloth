package game;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Screen;

import components.PositionComponent;
import components.RenderableComponent;
import components.VelocityComponent;
import render.GdxGame;

public class Bag extends PooledEngine {

	public static Bag engine;
	public static GdxGame game;

	private void Bag() {
	}

	public static final ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
	public static final ComponentMapper<VelocityComponent> vm = ComponentMapper.getFor(VelocityComponent.class);
	public static final ComponentMapper<RenderableComponent> rm = ComponentMapper.getFor(RenderableComponent.class);
	public static Screen activeScreen;
	private static Logger LOGGER = null;

	public void setScreen(Screen screen) {
		activeScreen = screen;
	}

	public static void init(Screen screen, GdxGame gdxGame) {
		game = gdxGame;
		engine = new Bag();
		activeScreen = screen;
		activeScreen.show();
	}

	public void dispose() {
		activeScreen.dispose();

	}

	public void render(float delta) {
		activeScreen.render(delta);
	}

	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class clazz) {
		if (LOGGER == null) {
			LOGGER = new Logger();
		}
		LOGGER.setClassName(clazz.getName());
		return LOGGER;
	}

}