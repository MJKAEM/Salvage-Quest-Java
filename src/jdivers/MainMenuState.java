package jdivers;

import jdivers.events.MenuSelectedEvent;
import jdivers.mainmenu.MainMenu;
import jdivers.mainmenu.OptionMenu;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState
{
	public static final int MAIN_MENU = 1;
	public static final int OPTION_MENU = 2;
	public static final int CREDITS_MENU = 3;
	public static final int LOAD_MENU = 4;

	private static MainMenu mainMenu;
	private static OptionMenu optionMenu;

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
		optionMenu = new OptionMenu();

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
	}

	@Override
	public void mouseReleased(int button, int x, int y)
	{
		switch (button)
		{
			case 0: // Left mouse click
				currentMenu.mouseReleased();
				break;
		}
	}

	@Override
	public int getID()
	{
		return 0;
	}
};
