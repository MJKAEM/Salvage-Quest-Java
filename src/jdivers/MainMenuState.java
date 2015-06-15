package jdivers;

import jdivers.mainmenu.MainMenu;
import jdivers.mainmenu.OptionMenu;
import jdivers.textbox.ClickHandler;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState
{
	private MainMenu mainMenu;
	private OptionMenu optionMenu;

	private AbstractMenu currentMenu;
	private AngelCodeFont textboxFont, copyrightFont;

	private ClickHandler switchMainMenu, switchPlayState, switchOptionsMenu;
			

	public MainMenuState(int state)
	{
	}

	@Override
	public void init(final GameContainer gc, final StateBasedGame sbg)
			throws SlickException
	{
		mainMenu = new MainMenu();
		optionMenu = new OptionMenu();

		currentMenu = mainMenu;

		textboxFont = ContentLoader.fonts[0];
		copyrightFont = ContentLoader.fonts[1];
		mainMenu.setTitleFont(ContentLoader.fonts[2]);

		initMenuHandlerClickActions(sbg);
		initMenuHandlers();
	}

	@Override
	public void render(final GameContainer gc, final StateBasedGame sbg,
			final Graphics g) throws SlickException
	{
		g.setFont(textboxFont);
		currentMenu.show(g);
		g.setFont(copyrightFont);
		showAuthor(g);
	}

	@Override
	public void update(final GameContainer gc, final StateBasedGame sbg,
			final int delta) throws SlickException
	{
		currentMenu.update();

		MouseFix.updateMouseY();
	}

	@Override
	public void mouseReleased(final int button, final int x, final int y)
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
		return Global.menuStateValue;
	}

	public void showAuthor(final Graphics g)
	{
		final String copyright = "\u00A9Artanis Margatroid 2015";

		g.setColor(Color.black);
		g.drawString(copyright,
				Global.width - g.getFont().getWidth(copyright),
				Global.height - 20);
	}

	private void initMenuHandlerClickActions(final StateBasedGame sbg)
	{
		switchMainMenu = new ClickHandler()
		{
			@Override
			public void onClick()
			{
				currentMenu = mainMenu;
			}
		};

		switchPlayState = new ClickHandler()
		{
			@Override
			public void onClick()
			{
				sbg.enterState(Global.playStateValue);
			}
		};

		switchOptionsMenu = new ClickHandler()
		{
			@Override
			public void onClick()
			{
				currentMenu = optionMenu;
			}
		};
	}

	private void initMenuHandlers()
	{
		mainMenu.setClickHandler(switchPlayState, 0);
		mainMenu.setClickHandler(switchOptionsMenu, 1);
		optionMenu.setClickHandler(switchMainMenu, AbstractMenu.GO_BACK);
	}
};
