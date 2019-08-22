package components;

public class PositionComponent implements PooledComponent {
	
	public float x;
	public float y;
	public float z;

	public PositionComponent(float x, float y) {
		this(x,y,0);
	}
	
	public PositionComponent(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}

	@Override
	public void reset() {
	}

}
