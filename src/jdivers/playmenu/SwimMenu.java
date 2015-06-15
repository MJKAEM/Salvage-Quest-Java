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

public class SwimMenu extends AbstractMenu
{
	public static final int GO_DIVE = 0;

	private static Image backgroundImage = ContentLoader.backgroundImages[3];

	private ClickTextBox backBox, diveBox;

	public SwimMenu()
	{
		backBox = new ClickTextBox(
				"Go Back",
				0,
				0,
				BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
				BasicTextBox.DEFAULT_TEXTBOX_HEIGHT,
				Color.darkGray,
				Global.mouseOffColor,
				Global.mouseOnColor,
				Color.white,
				Color.yellow);

		diveBox = new ClickTextBox(
				"Dive",
				Global.halfWidth - BasicTextBox.DEFAULT_TEXTBOX_HALF_WIDTH,
				Global.halfHeight,
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

		backBox.show(g);
		diveBox.show(g);
	}

	@Override
	public void update()
	{
		backBox.update();
		diveBox.update();
	}

	@Override
	public void mouseReleased()
	{
		backBox.mouseReleased();
		diveBox.mouseReleased();
	}

	@Override
	public void setClickHandler(final ClickHandler clickHandler, final int index)
	{
		switch (index)
		{
			case AbstractMenu.GO_BACK:
				backBox.setClickHandler(clickHandler);
				break;

			case SwimMenu.GO_DIVE:
				diveBox.setClickHandler(clickHandler);
				break;
		}
	}

};
