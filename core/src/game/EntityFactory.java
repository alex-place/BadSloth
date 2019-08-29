package game;


import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import components.PositionComponent;
import components.RenderableComponent;

public class EntityFactory {

	static Logger LOGGER = Bag.getLogger(EntityFactory.class);
	public static Entity createUnit(Component... components) {
		Entity entity = new Entity();
		for (Component component : components) {
			entity.add(component);
		}
		return entity;
	}
	
	public static void createAndRegisterUnit(Component...components) {
		Bag.engine.addEntity(createUnit(components));
	}

	private static void makeHex(int x, int y, TextureRegion hex) {
		RenderableComponent component = new RenderableComponent(hex, 1, 1);
		component.color = x % 2 == 1 ? Color.RED : Color.BLACK;
		createAndRegisterUnit(new PositionComponent((float) x, (float) y), component);
	}

	public static void createBoard(TextureRegion hex) {
		for (int y = 0; y < GameBoard.boardHeight; y++) {
			for (int x = 0; x < GameBoard.boardWidth; x++) {
				makeHex(x, y, hex);
				LOGGER.debug("placing hexes at ------ x: " + x + " y: " + y);
			}
		}
	}

	public static Entity circle() {
		return createUnit(new PositionComponent(0, 0), new RenderableComponent(new TextureRegion(new Texture("circle.png")), 1,1));
	}

}
