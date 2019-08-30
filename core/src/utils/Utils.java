package utils;

import com.badlogic.gdx.math.Vector2;

public class Utils {

	
	public static Vector2 worldToPixel(float x, float y) {
		float adjustedY = y;
		float adjustedX = x;

		if(x % 2 != 1) {
			adjustedY += 0.5f;
		}
		if(x % 2 != 1) {
			adjustedX += 0.25f;
		}
		
		
		
		
		
		if(x > 1) {
			adjustedX -= 0.5f;
		}
		
		if(x > 3) {
			adjustedX -= 0.5f;
		}
		
		if(x > 5) {
			adjustedX -= 0.5f;
		}
		
		return new Vector2(adjustedX, adjustedY);
	}
	
}
