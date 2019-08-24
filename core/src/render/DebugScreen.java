package render;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import components.PositionComponent;
import components.RenderableComponent;
import components.VelocityComponent;
import game.Bag;
import game.EntityFactory;
import systems.MovementSystem;
import systems.RenderingSystem;

public class DebugScreen extends BaseScreen {

	SpriteBatch batch;
	OrthographicCamera cam;
	RenderingSystem render;
	MovementSystem move;
	Texture hex;

	@Override
	public void show() {
		batch = new SpriteBatch();
		// Constructs a new OrthographicCamera, using the given viewport width and
		// height
		// Height is multiplied by aspect ratio.
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		cam = new OrthographicCamera(3000, 3000 * (h / w));

		cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();

		hex = new Texture("hex.png");

		Bag.engine.addSystem(move = new MovementSystem());
		Bag.engine.addSystem(render = new RenderingSystem(batch, cam));

		Entity entity = EntityFactory.createUnit(new PositionComponent(0, 0), new VelocityComponent(0.1f, 0.1f));
		EntityFactory.createUnit(new PositionComponent(0, 0), new RenderableComponent(new TextureRegion(hex)));
		EntityFactory.createBoard(new TextureRegion(hex));
		batch = new SpriteBatch(100);
		render = Bag.engine.getSystem(RenderingSystem.class);

	}

	@Override
	public void render(float delta) {
		render.update(delta);
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
	}

}
