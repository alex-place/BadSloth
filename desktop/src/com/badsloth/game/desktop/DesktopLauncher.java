package com.badsloth.game.desktop;

import java.io.IOException;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import render.GdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) throws IOException {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		 cfg.title = "BadSloth Debug Client";
	      cfg.useGL30 = false;
	      cfg.width = 480;
	      cfg.height = 320;
		new LwjglApplication(new GdxGame(), cfg);
	}
}
