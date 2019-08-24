package systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import components.PositionComponent;
import components.RenderableComponent;

public class RenderingSystem extends BaseSystem {
	private ComponentMapper<RenderableComponent> rm;
	private SpriteBatch batch;
	private OrthographicCamera camera;

	public RenderingSystem(SpriteBatch batch, OrthographicCamera camera) {
		super(Family.all(PositionComponent.class, RenderableComponent.class).get());
		this.batch = batch;
		this.camera = camera;
	}

	protected void processEntity(Entity entity, float deltaTime) {
		PositionComponent position;
		RenderableComponent visual;

		position = entity.getComponent(PositionComponent.class);
		visual = entity.getComponent(RenderableComponent.class);

		batch.draw(visual.region, position.x, position.y);
	}

	@Override
	public void entityAdded(Entity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void entityRemoved(Entity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float deltaTime) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.setProjectionMatrix(camera.combined);

		for (int i = 0; i < getEntities().size(); ++i) {
			processEntity(getEntities().get(i), deltaTime);
		}
		batch.end();
	}

}