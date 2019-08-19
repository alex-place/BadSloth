package pojos;

import com.badlogic.ashley.core.Component;

public class VelocityComponent implements Component {

	public VelocityComponent(float x, float y) {
		this.y = y;
		this.x = x;
	}

	public float x;
	public float y;

}
