package systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import components.PositionComponent;
import components.RenderableComponent;
import game.Bag;
import game.Logger;
import utils.Utils;

public class RenderingSystem extends BaseSystem {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	Logger LOGGER = Bag.getLogger(RenderingSystem.class);
	boolean one = true;

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
		Vector2 adjusted = new Vector2(position.x, position.y);// = Utils.worldToPixel(position.x, position.y);
		float adjustedY = adjusted.y - (visual.width / 2);
		float adjustedX = adjusted.x - (visual.height / 2);
		if (one)
			LOGGER.debug(adjustedX + " , " + adjustedY);

		batch.draw(visual.region, adjustedX, adjustedY, visual.width, visual.height);
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

		batch.begin();
		batch.setProjectionMatrix(camera.combined);

		for (int i = 0; i < getEntities().size(); ++i) {
			processEntity(getEntities().get(i), deltaTime);
		}
		batch.end();
		one = false;
	}

}