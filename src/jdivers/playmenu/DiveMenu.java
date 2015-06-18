package jdivers.playmenu;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import jdivers.AbstractMenu;
import jdivers.ContentLoader;
import jdivers.Global;
import jdivers.textbox.BasicTextBox;
import jdivers.textbox.ClickHandler;
import jdivers.textbox.ClickItemBox;
import jdivers.textbox.ClickTextBox;

public class DiveMenu extends AbstractMenu
{
	public static final int SEARCH = 1;

	private static Image backgroundImage = ContentLoader.backgroundImages[4];

	private ClickTextBox ascendBox, searchBox;
	private ClickItemBox foundBox;

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

		searchBox = new ClickTextBox(
				"Search",
				Global.halfWidth - BasicTextBox.DEFAULT_TEXTBOX_HALF_WIDTH,
				Global.halfHeight,
				BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
				BasicTextBox.DEFAULT_TEXTBOX_HEIGHT,
				Color.darkGray,
				Global.mouseOffColor,
				Global.mouseOnColor,
				Color.white,
				Color.yellow);

		foundBox = new ClickItemBox(
				"",
				null,
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

		ascendBox.show(g);
		searchBox.show(g);

		if (foundBox.getItemEnum() != null)
		{
			foundBox.show(g);
		}
	}

	@Override
	public void update()
	{
		ascendBox.update();
		searchBox.update();

		if (foundBox.getItemEnum() != null)
		{
			foundBox.update();
		}
	}

	@Override
	public void mouseReleased()
	{
		ascendBox.mouseReleased();
		searchBox.mouseReleased();

		if (foundBox.getItemEnum() != null)
		{
			foundBox.mouseReleased();
		}
	}

	@Override
	public void setClickHandler(final ClickHandler clickHandler, final int index)
	{
		switch (index)
		{
			case AbstractMenu.GO_BACK:
				ascendBox.setClickHandler(clickHandler);
				break;

			case DiveMenu.SEARCH:
				searchBox.setClickHandler(clickHandler);
				break;
		}
	}

};
