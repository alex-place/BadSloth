package systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;

import components.PhysicsComponent;
import game.Bag;
import game.Logger;

public class PhysicsSystem extends BaseSystem {
	
	Logger LOGGER = Bag.getLogger(PhysicsSystem.class);
	
	private ComponentMapper<PhysicsComponent> pm = ComponentMapper.getFor(PhysicsComponent.class);

	public PhysicsSystem() {
		super(Family.all(PhysicsComponent.class).get());
	}

	public void processEntity(Entity entity, float deltaTime) {
		PhysicsComponent p = pm.get(entity);
		//p.body.setTransform(0, 0, 0);
	}

	@Override
	public void entityAdded(Entity entity) {
	}

	@Override
	public void entityRemoved(Entity entity) {
	}
}