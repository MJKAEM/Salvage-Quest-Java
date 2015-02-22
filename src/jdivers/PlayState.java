package jdivers;

import jdivers.output.OutputTextBox;
import jdivers.playmenu.MainHubMenu;
import jdivers.playmenu.ShopMenu;
import jdivers.playmenu.StashMenu;
import jdivers.textbox.ClickHandler;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PlayState extends BasicGameState
{
	private AngelCodeFont textboxFont, outputTextFont;

	public static final OutputTextBox outputTextbox = new OutputTextBox();

	private PlayerData playerData;

	private MainHubMenu mainHubMenu;
	private ShopMenu shopMenu;
	private StashMenu stashMenu;

	private AbstractMenu currentMenu;

	private ClickHandler switchMainHub, switchShop, switchStash;

	public PlayState(int state)
	{

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException
	{
		playerData = new PlayerData("Anonymous");

		mainHubMenu = new MainHubMenu();
		shopMenu = new ShopMenu();
		stashMenu = new StashMenu();

		currentMenu = mainHubMenu;

		textboxFont = ContentLoader.fonts[0];
		outputTextFont = ContentLoader.fonts[3];

		initHandlers();

		mainHubMenu.setListener(switchShop, 0);
		mainHubMenu.setListener(switchStash, 1);
		shopMenu.setListener(switchMainHub, -1);
		stashMenu.setListener(switchMainHub, -1);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException
	{
		g.setFont(textboxFont);
		currentMenu.show(g);

		g.setFont(outputTextFont);
		outputTextbox.show(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException
	{
		MouseFix.updateMouseY();

		currentMenu.update();
	}

	@Override
	public void mouseReleased(int button, int x, int y)
	{
		switch (button)
		{
			case 0:
				currentMenu.mouseReleased();
				break;
		}
	}

	@Override
	public int getID()
	{
		return Global.playStateValue;
	}

	private void initHandlers()
	{
		switchMainHub = new ClickHandler()
		{
			@Override
			public void onClick()
			{
				currentMenu = mainHubMenu;
			}
		};

		switchShop = new ClickHandler()
		{
			@Override
			public void onClick()
			{
				currentMenu = shopMenu;
			}
		};

		switchStash = new ClickHandler()
		{
			@Override
			public void onClick()
			{
				currentMenu = stashMenu;
			}
		};
	}
};
