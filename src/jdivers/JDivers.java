package jdivers;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class JDivers extends StateBasedGame
{
	public static final String gamename = "Divers 0.1A";
	public static final int menu = 0;
	public static final int play = 1;
	public static int width = 800;
	public static int height = 600;
	public static boolean fullScreen = false;
	public static boolean vSync = false;

	public JDivers(final String gameName)
	{
		super(gameName);
		
		addState(new MainMenuState(menu));
	}

	@Override
	public void initStatesList(final GameContainer gc) throws SlickException
	{
		ContentLoader.loadAllContent();
		
		getState(menu).init(gc, this);
		enterState(menu);
	}

	public static void main(String[] args)
	{
		AppGameContainer appgc;
		try
		{
			appgc = new AppGameContainer(new JDivers(gamename));
			appgc.setDisplayMode(width, height, fullScreen);
			appgc.setTargetFrameRate(60);
			appgc.setShowFPS(false);
			appgc.setVSync(vSync);
			appgc.start();
		}
		catch (SlickException e)
		{
			e.printStackTrace();
		}
	}
};
