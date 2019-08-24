package game;

import com.badlogic.gdx.Gdx;

public class Logger implements LogInterface{
	
	protected Logger() {
		
	}

	private String className;

	@Override
	public void info(String message) {
		Gdx.app.setLogLevel(INFO);
		Gdx.app.log(className, message);
	}

	@Override
	public void debug(String message) {
		Gdx.app.setLogLevel(DEBUG);
		Gdx.app.log(className, message);
	}

	@Override
	public void error(String message) {
		Gdx.app.setLogLevel(ERROR);
		Gdx.app.log(className, message);
	}

	@Override
	public void fatal(String message, Throwable e) {
		Gdx.app.setLogLevel(ERROR);
		Gdx.app.log(className, message);
	}
	
	public void setClassName(String name) {
		this.className = name;;
	}


}
