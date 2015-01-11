package jdivers;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class JDivers extends StateBasedGame
{
	public static final int menu = 0;
	public static final int play = 1;

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
			appgc = new AppGameContainer(new JDivers(Global.gamename));
			appgc.setDisplayMode(Global.width, Global.height, Global.fullScreen);
			appgc.setTargetFrameRate(60);
			appgc.setShowFPS(false);
			appgc.setVSync(Global.vSync);
			appgc.start();
		}
		catch (SlickException e)
		{
			e.printStackTrace();
		}
	}
};
