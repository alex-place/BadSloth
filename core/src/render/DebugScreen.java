package render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import components.PositionComponent;
import components.RenderableComponent;
import components.VelocityComponent;
import game.EntityFactory;

public class DebugScreen extends BaseScreen {

	SpriteBatch batch;
	Texture img;

	@Override
	public void show() {
		EntityFactory.createUnit(new PositionComponent(0, 0), new VelocityComponent(0.1f, 0.1f));
		
		EntityFactory.createUnit(new PositionComponent(0, 0), new RenderableComponent());
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
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
		img.dispose();
	}

}
