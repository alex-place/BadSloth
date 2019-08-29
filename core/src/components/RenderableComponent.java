package components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RenderableComponent implements PooledComponent{
	
	public TextureRegion region;
	public int width;
	public int height;
	public Color color;

	public RenderableComponent (TextureRegion region, int width, int height) {
		this.region = region;
		this.width = width;
		this.height = height;
		color = Color.WHITE;
	}

	@Override
	public void reset() {
		region = null;
	}

}
