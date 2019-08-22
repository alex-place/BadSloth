package game;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;

import components.PositionComponent;

public class EntityFactory {

	public static Entity createUnit(Component... components) {
		Entity entity = new Entity();
		for (Component component : components)
			entity.add(component);
		Bag.engine.addEntity(entity);
		return entity;
	}
	
	private void makeHex(int index) {
		Entity hex = createUnit(new PositionComponent(index, index)); 
	}
	
	public void createBoard() {
		for(int i = 0; i < GameBoard.maxHex; i++) {
			makeHex(GameBoard.maxHex);
		}
	}

}
