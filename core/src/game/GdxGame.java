package game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GdxGame extends Game {
	
	DebugScreen screen;

	@Override
	public void create() {
		screen = new DebugScreen();
		setScreen(screen);
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionListener());
	}

	@Override
	public void render() {
		float delta = Gdx.graphics.getDeltaTime();
		Bag.engine.update(delta);
		screen.render(delta);
		
	}

	@Override
	public void dispose() {
		screen.dispose();
	}
	
	@Override
	public void setScreen(Screen screen) {
		Bag.setScreen(screen);
		super.setScreen(screen);
	}

}
