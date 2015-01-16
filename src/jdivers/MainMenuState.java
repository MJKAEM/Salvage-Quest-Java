package jdivers;

import jdivers.events.MenuSelectedEvent;
import jdivers.mainmenu.MainMenu;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState implements MenuSelectedEvent
{
	public static final int MAIN_MENU = 1;
	public static final int OPTION_MENU = 2;
	public static final int CREDITS_MENU = 3;
	public static final int LOAD_MENU = 4;
	
	private static MainMenu mainMenu;
	
	private static Menu currentMenu;
	private AngelCodeFont font1;

	public MainMenuState(int state)
	{
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException
	{
		mainMenu = new MainMenu();
		currentMenu = mainMenu;
		
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

	@Override
	public void switchMenu(int menu)
	{
		switch(menu)
		{
			case MainMenuState.MAIN_MENU:
				currentMenu = mainMenu;
				break;
				
			case MainMenuState.OPTION_MENU:
				break;
				
			case MainMenuState.CREDITS_MENU:
				break;
				
			case MainMenuState.LOAD_MENU:
				break;
		}
	}
};
