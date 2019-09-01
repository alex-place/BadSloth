package components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RenderableComponent implements PooledComponent{
	
	public TextureRegion region;
	public float width;
	public float height;
	public Color color;

	public RenderableComponent (TextureRegion region, float f, float g) {
		this.region = region;
		this.width = f;
		this.height = g;
		color = Color.WHITE;
	}

	@Override
	public void reset() {
		region = null;
	}

}
