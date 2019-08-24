package systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

import components.PositionComponent;
import components.VelocityComponent;
import game.Bag;
import game.Logger;

public class MovementSystem extends BaseSystem {
	
	Logger LOGGER = Bag.getLogger(MovementSystem.class);
	
	private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
	private ComponentMapper<VelocityComponent> vm = ComponentMapper.getFor(VelocityComponent.class);

	public MovementSystem() {
		super(Family.all(PositionComponent.class, VelocityComponent.class).get());
	}

	public void processEntity(Entity entity, float deltaTime) {
		PositionComponent position = pm.get(entity);
		VelocityComponent velocity = vm.get(entity);
		position.x += velocity.x * deltaTime;
		position.y += velocity.y * deltaTime;
		
		
		LOGGER.debug(position.x + " " + position.y);
		
	}

	@Override
	public void entityAdded(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void entityRemoved(Entity entity) {
		// TODO Auto-generated method stub
		
	}
}