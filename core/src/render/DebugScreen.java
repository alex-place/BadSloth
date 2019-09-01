package render;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.HexagonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import components.PositionComponent;
import game.Bag;
import game.EntityFactory;
import game.Logger;
import systems.MovementSystem;
import systems.PhysicsSystem;
import systems.RenderingSystem;

public class DebugScreen extends BaseScreen {
	
	Logger LOGGER = Bag.getLogger(DebugScreen.class);

	SpriteBatch batch;
	OrthographicCamera cam;
	// TODO convert to use TextureAtlas
	Texture hex;
	Texture circle;

	Entity c;

	TmxMapLoader mapLoader;
	TiledMap map;
	HexagonalTiledMapRenderer renderer;
	
	World world;
	Box2DDebugRenderer b2dRenderer;
	

	@Override
	public void show() {
		world = Bag.world;
		mapLoader = new TmxMapLoader();
		map = mapLoader.load("untitled.tmx");

		Gdx.input.setInputProcessor(this);
		batch = new SpriteBatch();
		renderer = new HexagonalTiledMapRenderer(map, 1 / 70f, batch);

		// Constructs a new OrthographicCamera, using the given viewport width and
		// height
		// Height is multiplied by aspect ratio.
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		cam = new OrthographicCamera(8, (float) (8 * (h / w) + 1));

		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();

		renderer.setView(cam);

		hex = new Texture("hex.png");

		circle = new Texture("circle.png");

		Bag.engine.addSystem(new MovementSystem());
		RenderingSystem r = new RenderingSystem(batch, cam);
		r.priority = 10;
		Bag.engine.addSystem(r);
		Bag.engine.addSystem(new PhysicsSystem());

		EntityFactory.createBoardSensors(map, new TextureRegion(hex));
		c = EntityFactory.circle();
		Bag.engine.addEntity(c);

		batch = new SpriteBatch(100);
		batch.setProjectionMatrix(cam.combined);
		
		b2dRenderer = new Box2DDebugRenderer();
		b2dRenderer.setDrawInactiveBodies(true);

	}

	@Override
	public void render(float delta) {
		cam.update();
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.setView(cam);
		renderer.render();
		Bag.engine.update(delta);
		b2dRenderer.render(world, cam.combined);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void dispose() {
		batch.dispose();
		hex.dispose();
		circle.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		touchDragged(screenX, screenY, pointer);
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// ignore if its not left mouse button or first touch pointer
		if (pointer > 0)
			return false;
		cam.unproject(tp.set(screenX, screenY, 0));
		c.add(new PositionComponent(tp.x, tp.y));
		cam.position.set(tp);
		LOGGER.debug(tp.x + "  --  " + tp.y);
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
