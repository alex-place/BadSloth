package game;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;

public class EntityFactory {

	public static Entity createUnit(Component... components) {
		Entity entity = new Entity();
		for (Component component : components)
			entity.add(component);
		Bag.engine.addEntity(entity);
		return entity;
	}

}
