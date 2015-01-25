package jdivers.playmenu;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import jdivers.ContentLoader;
import jdivers.AbstractMenu;
import jdivers.textbox.AbstractTextBox;
import jdivers.textbox.ClickHandler;
import jdivers.textbox.TransparentClickTextBox;

public class MainHubMenu extends AbstractMenu
{
	private static Image screenImage = ContentLoader.backgroundImages[0];

	private TransparentClickTextBox shopBox;

	public MainHubMenu()
	{
		shopBox = new TransparentClickTextBox("Shop",
				0,
				1,
				AbstractTextBox.DEFAULT_TEXTBOX_WIDTH,
				AbstractTextBox.DEFAULT_TEXTBOX_HEIGHT, 
				Color.gray, 
				null);
	}

	@Override
	public void show(Graphics g)
	{
		showBackground(g, screenImage);

		shopBox.show(g);
	}

	@Override
	public void update()
	{
		shopBox.update();
	}

	@Override
	public void mouseReleased()
	{
		shopBox.mouseReleased();
	}

	@Override
	public void setListener(ClickHandler clickHandler, int index)
	{
		// TODO Auto-generated method stub

	}

};
