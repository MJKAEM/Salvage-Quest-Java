package jdivers.playmenu;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import jdivers.ContentLoader;
import jdivers.AbstractMenu;
import jdivers.textbox.BasicTextBox;
import jdivers.textbox.ClickHandler;
import jdivers.textbox.ClickTextBox;
import jdivers.textbox.SpecialClickTextBox;

public class MainHubMenu extends AbstractMenu
{
	private static Image screenImage = ContentLoader.backgroundImages[0];

	private ClickTextBox shopBox;

	public MainHubMenu()
	{
		shopBox = new ClickTextBox("Shop",
				0,
				1,
				BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
				BasicTextBox.DEFAULT_TEXTBOX_HEIGHT,
				Color.darkGray,
				new Color(128, 128, 128, 100),
				new Color(128, 128, 128, 200),
				Color.white,
				Color.yellow);
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
		
	}

};
