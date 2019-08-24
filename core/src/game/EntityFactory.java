package game;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import components.PositionComponent;
import components.RenderableComponent;

public class EntityFactory {

	static Logger LOGGER = Bag.getLogger(EntityFactory.class);
	
	public static Entity createUnit(Component... components) {
		Entity entity = new Entity();
		for (Component component : components)
			entity.add(component);
		Bag.engine.addEntity(entity);
		return entity;
	}

	private static void makeHex(int x, int y, TextureRegion hex) {
		createUnit(new PositionComponent((float) x, (float) y), new RenderableComponent(hex));
	}

	public static void createBoard(TextureRegion hex) {
		for (int y = 0; y < GameBoard.boardHeight; y++) {
			for (int x = 0; x < GameBoard.boardWidth; x++) {
				makeHex(x, y, hex);
				LOGGER.debug("x: " + x + " y: " + y);
			}
		}
	}

}
