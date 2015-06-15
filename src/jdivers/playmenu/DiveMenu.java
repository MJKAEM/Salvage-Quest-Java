package jdivers.playmenu;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import jdivers.AbstractMenu;
import jdivers.ContentLoader;
import jdivers.Global;
import jdivers.textbox.BasicTextBox;
import jdivers.textbox.ClickHandler;
import jdivers.textbox.ClickTextBox;

public class DiveMenu extends AbstractMenu
{
	private static Image backgroundImage = ContentLoader.backgroundImages[4];
	
	private ClickTextBox ascendBox;

	public DiveMenu()
	{
		ascendBox = new ClickTextBox(
				"Ascend",
				0,
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
	public void show(final Graphics g)
	{
		showBackground(g, backgroundImage);
		ascendBox.show(g);
	}

	@Override
	public void update()
	{
		ascendBox.update();
	}

	@Override
	public void mouseReleased()
	{
		ascendBox.mouseReleased();
	}

	@Override
	public void setClickHandler(final ClickHandler clickHandler, final int index)
	{
		switch (index)
		{
			case AbstractMenu.GO_BACK:
				ascendBox.setClickHandler(clickHandler);
				break;
		}
	}

};
