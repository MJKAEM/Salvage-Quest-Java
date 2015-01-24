package jdivers.playmenu;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import jdivers.ContentLoader;
import jdivers.Menu;
import jdivers.textbox.ClickHandler;

public class MainHubMenu extends Menu
{
	private static Image screenImage = ContentLoader.backgroundImages[0];

	public MainHubMenu()
	{
		
	}
	
	@Override
	public void show(Graphics g)
	{
		showBackground(g, screenImage);
	}

	@Override
	public void update(StateBasedGame sbg)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void setListener(ClickHandler clickHandler, int index)
	{
		// TODO Auto-generated method stub

	}

};
