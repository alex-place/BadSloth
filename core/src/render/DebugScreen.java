package render;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import components.PositionComponent;
import game.Bag;
import game.EntityFactory;
import systems.MovementSystem;
import systems.RenderingSystem;

public class DebugScreen extends BaseScreen {

	SpriteBatch batch;
	OrthographicCamera cam;
	// TODO convert to use TextureAtlas
	Texture hex;
	Texture circle;

	Entity c;

	@Override
	public void show() {
		Gdx.input.setInputProcessor(this);
		batch = new SpriteBatch();
		// Constructs a new OrthographicCamera, using the given viewport width and
		// height
		// Height is multiplied by aspect ratio.
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		cam = new OrthographicCamera(8, (float) (8 * (h / w) + 1));

		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();

		hex = new Texture("hex.png");
		TextureRegion hexReg = new TextureRegion(hex);

		circle = new Texture("circle.png");
		TextureRegion circleReg = new TextureRegion(circle);

		Bag.engine.addSystem(new MovementSystem());
		RenderingSystem r = new RenderingSystem(batch, cam);
		r.priority = 10;
		Bag.engine.addSystem(r);

		EntityFactory.createBoard(new TextureRegion(hex));
		c = EntityFactory.circle();
		Bag.engine.addEntity(c);

		batch = new SpriteBatch(100);
		batch.setProjectionMatrix(cam.combined);

	}

	@Override
	public void render(float delta) {
		Bag.engine.update(delta);
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
