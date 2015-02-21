package jdivers.playmenu;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import jdivers.AbstractMenu;
import jdivers.Global;
import jdivers.textbox.BasicTextBox;
import jdivers.textbox.ClickHandler;
import jdivers.textbox.ClickTextBox;

public class ShopMenu extends AbstractMenu
{
	private ClickTextBox exitBox;
	private ClickTextBox pistolBox, rifleBox, ammoBox;

	public ShopMenu()
	{
		exitBox = new ClickTextBox(
				"Exit",
				Global.width - BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
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
		exitBox.show(g);
	}

	@Override
	public void update()
	{
		exitBox.update();
	}

	@Override
	public void mouseReleased()
	{
		exitBox.mouseReleased();
	}

	@Override
	public void setListener(ClickHandler clickHandler, int index)
	{
		switch (index)
		{
			case -1:
				exitBox.setClickHandler(clickHandler);
				break;
		}
	}

};
