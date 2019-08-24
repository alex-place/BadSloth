package components;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RenderableComponent implements PooledComponent{
	
	public TextureRegion region;

	public RenderableComponent (TextureRegion region) {
		this.region = region;
	}

	@Override
	public void reset() {
		region = null;
	}

}
