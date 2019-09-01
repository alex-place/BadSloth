package components;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import game.Bag;

public class PhysicsComponent implements PooledComponent {

	public Body body;
	public BodyDef bdef;
	public PolygonShape shape;
	public FixtureDef fdef;

	public PhysicsComponent(Body body) {
		this.body = body;
	}

	@Override
	public void reset() {
		body = null;
		bdef = null;
		shape = null;
		fdef = null;
	}

//		mass
//		velocity
//		location
//		angles
//		fixtures
//			shape
//			density
//			friction
//			restitution (bounciness)

}
