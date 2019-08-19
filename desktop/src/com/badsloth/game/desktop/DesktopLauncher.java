package com.badsloth.game.desktop;

import org.apache.logging.log4j.core.impl.Log4jContextFactory;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import game.GdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		 cfg.title = "BadSloth Debug Client";
	      cfg.useGL30 = false;
	      cfg.width = 480;
	      cfg.height = 320;
		new LwjglApplication(new GdxGame(), cfg);
	}
}
