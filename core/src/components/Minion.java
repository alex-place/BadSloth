package components;

public class Minion implements PooledComponent{
	
	public float health = 1;
	public float speed = 1;

	@Override
	public void reset() {
		health = 1;
		speed = 1;
	}

}
