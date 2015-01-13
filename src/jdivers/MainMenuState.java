package jdivers;

import jdivers.mainmenu.MainMenu;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState
{
	private static Menu currentMenu;
	private AngelCodeFont font1;

	public MainMenuState(int state)
	{
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException
	{
		currentMenu = new MainMenu();
		font1 = ContentLoader.fonts[0];
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException
	{
		g.setFont(font1);
		currentMenu.show(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException
	{
		currentMenu.update(sbg);
		
		MouseFix.updateMouseY();
		Global.updateMouseDown();
	}

	@Override
	public int getID()
	{
		return 0;
	}
};
