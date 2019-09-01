package game;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import components.PhysicsComponent;
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
	public static final ComponentMapper<PhysicsComponent> physm = ComponentMapper.getFor(PhysicsComponent.class);
	public static Screen activeScreen;
	private static Logger LOGGER = null;
	public static World world;

	public void setScreen(Screen screen) {
		activeScreen = screen;
	}

	public static void init(Screen screen, GdxGame gdxGame) {
		world = new World(new Vector2(0,0), true);
		world.setContactListener(new ContactEventListener());
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
		world.step(1/60f, 6, 2);

	}

	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class clazz) {
		LOGGER = new Logger();
		LOGGER.setClassName(clazz.getName());
		return LOGGER;
	}

}