package com.badsloth.debug;

import com.badlogic.gdx.Gdx;

public class Profiler {
	
	public static long getJavaHeap() {
		return  Gdx.app.getJavaHeap();
	}
	public static long getNativeHeap() {
		return Gdx.app.getNativeHeap();
	}

}
