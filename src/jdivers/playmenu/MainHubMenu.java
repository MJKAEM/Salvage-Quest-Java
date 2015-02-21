package jdivers.playmenu;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import jdivers.ContentLoader;
import jdivers.AbstractMenu;
import jdivers.Global;
import jdivers.textbox.BasicTextBox;
import jdivers.textbox.ClickHandler;
import jdivers.textbox.ClickTextBox;

public class MainHubMenu extends AbstractMenu
{
	private static Image screenImage = ContentLoader.backgroundImages[0];

	private ClickTextBox shopBox, bankBox;

	public MainHubMenu()
	{
		shopBox = new ClickTextBox("Shop",
				0,
				0,
				BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
				BasicTextBox.DEFAULT_TEXTBOX_HEIGHT,
				Color.darkGray,
				Global.mouseOffColor,
				Global.mouseOnColor,
				Color.white,
				Color.yellow);
		
		bankBox = new ClickTextBox("Bank",
				BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
				0,
				BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
				BasicTextBox.DEFAULT_TEXTBOX_HEIGHT,
				Color.darkGray,
				Global.mouseOffColor,
				Global.mouseOnColor,
				Color.white,
				Color.yellow);
	}

	@Override
	public void show(Graphics g)
	{
		showBackground(g, screenImage);

		shopBox.show(g);
		bankBox.show(g);
	}

	@Override
	public void update()
	{
		shopBox.update();
		bankBox.update();
	}

	@Override
	public void mouseReleased()
	{
		shopBox.mouseReleased();
		bankBox.mouseReleased();
	}

	@Override
	public void setListener(ClickHandler clickHandler, int index)
	{
		switch(index)
		{
			case 0:
				shopBox.setClickHandler(clickHandler);
				break;
				
			case 1:
				bankBox.setClickHandler(clickHandler);
				break;
		}
	}
};
