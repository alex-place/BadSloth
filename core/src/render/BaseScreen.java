package render;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector3;

public abstract class BaseScreen implements Screen,Component, InputProcessor{
	
	Vector3 tp = new Vector3();

}
