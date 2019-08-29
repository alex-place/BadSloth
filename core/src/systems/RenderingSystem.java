package systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import components.PositionComponent;
import components.RenderableComponent;
import game.Bag;
import game.Logger;

public class RenderingSystem extends BaseSystem {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	Logger LOGGER = Bag.getLogger(RenderingSystem.class);

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
		float adjustedY = position.y;
		if(position.x % 2 == 0) {
			adjustedY += 0.5f;
		}
		float adjustedX = position.x;
		if(position.x % 2 == 0) {
			adjustedX += 0.25f;
		}
		
		if(position.x > 1) {
			adjustedX -= 0.5f;
		}
		
		if(position.x > 3) {
			adjustedX -= 0.5f;
		}
		
		if(position.x > 5) {
			adjustedX -= 0.5f;
		}
		
//		adjustedY += -.1f * (position.x);
//		adjustedX += -.1f * (position.y);

		batch.draw(visual.region, adjustedX, adjustedY, visual.width, visual.height);
		LOGGER.debug(position.x + " " + position.y);
	}

	@Override
	public void entityAdded(Entity entity) {
		LOGGER.debug("entity added");

	}

	@Override
	public void entityRemoved(Entity entity) {

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