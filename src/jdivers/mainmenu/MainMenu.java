package jdivers.mainmenu;

import java.util.Enumeration;
import java.util.Vector;

import jdivers.ContentLoader;
import jdivers.Global;
import jdivers.MainMenuState;
import jdivers.Menu;
import jdivers.events.MenuSelectedEvent;
import jdivers.textbox.ClickTextbox;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu implements Menu
{
	private static Image screenImage = ContentLoader.backgroundImages[0];

	private Vector<MenuSelectedEvent> _listeners;
	private ClickTextbox playBox, optionsBox, creditsBox, exitBox;

	public MainMenu()
	{
		playBox = new ClickTextbox("Play",
				Global.quarterWidth - 50,
				Global.halfHeight,
				100,
				100);

		optionsBox = new ClickTextbox("Options",
				Global.threeFourthWidth - 50,
				Global.halfHeight,
				100,
				100);

		creditsBox = new ClickTextbox("Credits",
				Global.quarterWidth - 50,
				Global.threeFourthHeight,
				100,
				100);

		exitBox = new ClickTextbox("Exit",
				Global.threeFourthWidth - 50,
				Global.threeFourthHeight,
				100,
				100);
	}

	@Override
	public void show(final Graphics g)
	{
		// Display background image.
		//
		g.drawImage(screenImage, 0, 0, Global.width, Global.height, 0, 0, 800,
				600);

		// Display the clickable boxes.
		//
		playBox.show(g);
		optionsBox.show(g);
		creditsBox.show(g);
		exitBox.show(g);
	}

	@Override
	public void update(StateBasedGame sbg)
	{
		playBox.update();
		optionsBox.update();
		creditsBox.update();
		exitBox.update();

		// Perform an action if one of the boxes are clicked.
		//
		if (playBox.isClicked())
		{
			playBox.isClicked(false);
			fireMenuSwitchEvent(MainMenuState.LOAD_MENU);
		}
		else if (optionsBox.isClicked())
		{
			optionsBox.isClicked(false);
			fireMenuSwitchEvent(MainMenuState.OPTION_MENU);
		}
		else if (creditsBox.isClicked())
		{
			creditsBox.isClicked(false);
			fireMenuSwitchEvent(MainMenuState.CREDITS_MENU);
		}
		else if (exitBox.isClicked())
		{
			System.exit(0);
		}
	}

	public void addListener(MenuSelectedEvent listener)
	{
		if (_listeners == null)
		{
			_listeners = new Vector<MenuSelectedEvent>();
		}
		_listeners.addElement(listener);
	}

	public void fireMenuSwitchEvent(int menu)
	{
		if (_listeners != null)
		{
			for (MenuSelectedEvent temp : _listeners)
			{
				temp.switchMenu(menu);
			}
		}
	}
};
