package systems;

import com.badlogic.ashley.core.EntityListener;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;

public abstract class BaseSystem extends IteratingSystem implements EntityListener{

	public BaseSystem(Family family) {
		super(family);
	}

}
