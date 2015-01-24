package jdivers;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class JDivers extends StateBasedGame
{
	public JDivers(final String gameName)
	{
		super(gameName);

		addState(new MainMenuState(Global.menuStateValue));
		addState(new PlayState(Global.playStateValue));
	}

	@Override
	public void initStatesList(final GameContainer gc) throws SlickException
	{
		ContentLoader.loadAllContent();

		getState(Global.menuStateValue).init(gc, this);
		getState(Global.playStateValue).init(gc, this);
		enterState(Global.menuStateValue);
	}

	public static void main(String[] args)
	{
		AppGameContainer appgc;

		try
		{
			appgc = new AppGameContainer(new JDivers(Global.GAMENAME));
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
