package jdivers.playmenu;

import jdivers.AbstractMenu;
import jdivers.ContentLoader;
import jdivers.Global;
import jdivers.textbox.BasicTextBox;
import jdivers.textbox.ClickHandler;
import jdivers.textbox.ClickTextBox;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class StashMenu extends AbstractMenu
{
	private static Image backgroundImage = ContentLoader.backgroundImages[2];

	private ClickTextBox exitBox;

	public StashMenu()
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
		showBackground(g, StashMenu.backgroundImage);

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
	public void setClickHandler(ClickHandler clickHandler, int index)
	{
		switch (index)
		{
			case -1:
				exitBox.setClickHandler(clickHandler);
				break;
		}
	}
};
