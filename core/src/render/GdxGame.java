package render;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import game.Bag;
import game.ExceptionListener;

public class GdxGame extends Game {
	
	@Override
	public void create() {
		Bag.init(new DebugScreen(), this);
		setScreen(Bag.activeScreen);
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionListener());
		
	}

	@Override
	public void render() {
		float delta = Gdx.graphics.getDeltaTime();
		Bag.engine.update(delta);
		Bag.engine.render(delta);
		
	}

	@Override
	public void dispose() {
		Bag.engine.dispose();
	}
	
	@Override
	public void setScreen(Screen screen) {
		Bag.engine.setScreen(screen);
		super.setScreen(screen);
	}

}
