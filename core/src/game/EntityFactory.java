package game;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import components.PhysicsComponent;
import components.PositionComponent;
import components.RenderableComponent;

public class EntityFactory {

	static Logger LOGGER = Bag.getLogger(EntityFactory.class);

	private static final float XPPM = 69;
	private static final float YPPM = 70;

	public static Entity createUnit(Component... components) {
		Entity entity = new Entity();
		for (Component component : components) {
			entity.add(component);
		}
		return entity;
	}

	public static void createAndRegisterUnit(Component... components) {
		Bag.engine.addEntity(createUnit(components));
	}

	public static void createBoardSensors(TiledMap map, TextureRegion hex) {
		BodyDef bdef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fdef = new FixtureDef();
		Body body;

		for (MapObject object : map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			bdef.type = BodyType.StaticBody;
			bdef.position.set((rect.getX() + rect.getWidth() / 2) / XPPM, ((rect.getY() + rect.getHeight() / 2) / YPPM) - 5.6f);

			body = Bag.world.createBody(bdef);

			shape.setAsBox(rect.getWidth() / 2, rect.getHeight() / 2);
			shape.setAsBox(0.1f, 0.1f);

			fdef.shape = shape;
			fdef.isSensor = true;
			body.createFixture(fdef);
			PhysicsComponent pc = new PhysicsComponent(body);
			createAndRegisterUnit(pc);

		}

	}
	
	public static void createBox(float x, float y, float size) {
		BodyDef bdef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fdef = new FixtureDef();
		Body body;
		
		Rectangle rect = new Rectangle(x, y, size, size);
		bdef.type = BodyType.StaticBody;
		bdef.position.set((rect.getX() + rect.getWidth() / 2) / XPPM, ((rect.getY() + rect.getHeight() / 2) / YPPM) - 5.6f);

		body = Bag.world.createBody(bdef);

		shape.setAsBox(rect.getWidth() / 2, rect.getHeight() / 2);
		shape.setAsBox(0.1f, 0.1f);

		fdef.shape = shape;
		fdef.isSensor = true;
		body.createFixture(fdef);
		PhysicsComponent pc = new PhysicsComponent(body);
		createAndRegisterUnit(pc);
	}

	public static Entity circle() {
		return createUnit(new PositionComponent(0, 0),
				new RenderableComponent(new TextureRegion(new Texture("circle.png")), 0.1f, 0.1f));
	}

}
