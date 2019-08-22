package components;

public class VelocityComponent implements PooledComponent {

	public VelocityComponent(float x, float y) {
		this.y = y;
		this.x = x;
	}

	public float x;
	public float y;

	@Override
	public void reset() {
	}

}
