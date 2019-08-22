package systems;

import java.util.Comparator;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;

import components.PositionComponent;
import components.RenderableComponent;

public class RenderingSystem extends SortedIteratingSystem {
	private ComponentMapper<RenderableComponent> rm;

	public RenderingSystem() {
		super(Family.all(RenderableComponent.class, PositionComponent.class).get(), new ZComparator());

		rm = ComponentMapper.getFor(RenderableComponent.class);
	}

	protected void processEntity(Entity entity, float deltaTime) {
		// Render the entity
	}

	private static class ZComparator implements Comparator<Entity> {
		private ComponentMapper<PositionComponent> pm = ComponentMapper.getFor(PositionComponent.class);
		
		@Override
		public int compare(Entity e1, Entity e2) {
			return (int)Math.signum(pm.get(e1).z - pm.get(e2).z);
		}
	}
}