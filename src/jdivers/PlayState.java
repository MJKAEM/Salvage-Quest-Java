package jdivers;

import jdivers.output.OutputTextBox;
import jdivers.playmenu.DiveMenu;
import jdivers.playmenu.MainHubMenu;
import jdivers.playmenu.ShopMenu;
import jdivers.playmenu.StashMenu;
import jdivers.playmenu.SwimMenu;
import jdivers.textbox.ClickHandler;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
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
	private SwimMenu swimMenu;
	private DiveMenu diveMenu;

	private AbstractMenu currentMenu;

	private ClickHandler switchMainHub, switchShop, switchStash, switchSwim,
			switchDive, switchFishing;

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
		swimMenu = new SwimMenu();
		diveMenu = new DiveMenu();

		currentMenu = mainHubMenu;

		textboxFont = ContentLoader.fonts[0];
		outputTextFont = ContentLoader.fonts[3];

		initMenuHandlerClickActions();
		initMenuHandlers();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException
	{
		g.setFont(textboxFont);
		currentMenu.show(g);

		g.setFont(outputTextFont);
		outputTextbox.show(g);

		// Draw HUD.
		//
		g.setFont(outputTextFont);
		g.setColor(Color.black);
		g.drawString(playerData.getCurHealth() + " HP", 20,
				Global.threeFourthHeight - 40);
		g.drawString(playerData.getCurArmor() + " AP", 20,
				Global.threeFourthHeight - 20);
		g.drawString("$" + playerData.getCurMoney(), Global.threeFourthWidth,
				Global.threeFourthHeight - 20);
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

	private void initMenuHandlerClickActions()
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

		switchSwim = new ClickHandler()
		{
			@Override
			public void onClick()
			{
				currentMenu = swimMenu;
			}
		};
		
		switchDive = new ClickHandler()
		{
			@Override
			public void onClick()
			{
				currentMenu = diveMenu;
			}
		};
	}

	private void initMenuHandlers()
	{
		mainHubMenu.setClickHandler(switchShop, 0);
		mainHubMenu.setClickHandler(switchStash, 1);
		mainHubMenu.setClickHandler(switchSwim, 2);
		// mainHubMenu.setClickHandler(switchFishing, 4);
		shopMenu.setClickHandler(switchMainHub, AbstractMenu.GO_BACK);
		stashMenu.setClickHandler(switchMainHub, AbstractMenu.GO_BACK);
		swimMenu.setClickHandler(switchMainHub, AbstractMenu.GO_BACK);
		swimMenu.setClickHandler(switchDive, SwimMenu.GO_DIVE);
		diveMenu.setClickHandler(switchSwim, AbstractMenu.GO_BACK);
	}
};
