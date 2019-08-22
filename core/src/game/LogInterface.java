package game;

public interface LogInterface {

	public int NONE = 0;
	public int ERROR = 1;
	public int INFO = 2;
	public int DEBUG = 3;

	public void info(String message);

	public void debug(String message);

	public void error(String message);

	void fatal(String message, Throwable e);

}
