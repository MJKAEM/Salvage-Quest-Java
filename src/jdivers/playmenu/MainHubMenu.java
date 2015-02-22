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

	private ClickTextBox shopBox, stashBox, swimBox, sellBox, fishingBox;

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

		stashBox = new ClickTextBox(
				"Stash",
				Global.halfWidth - BasicTextBox.DEFAULT_TEXTBOX_HALF_WIDTH,
				0,
				BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
				BasicTextBox.DEFAULT_TEXTBOX_HEIGHT,
				Color.darkGray,
				Global.mouseOffColor,
				Global.mouseOnColor,
				Color.white,
				Color.yellow);

		swimBox = new ClickTextBox("Go Swim",
				Global.width - BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
				0,
				BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
				BasicTextBox.DEFAULT_TEXTBOX_HEIGHT,
				Color.darkGray,
				Global.mouseOffColor,
				Global.mouseOnColor,
				Color.white,
				Color.yellow);

		sellBox = new ClickTextBox("Sell",
				0,
				Global.halfHeight >> 1,
				BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
				BasicTextBox.DEFAULT_TEXTBOX_HEIGHT,
				Color.darkGray,
				Global.mouseOffColor,
				Global.mouseOnColor,
				Color.white,
				Color.yellow);

		fishingBox = new ClickTextBox("Fishing",
				Global.width - BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
				Global.halfHeight >> 1,
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
		stashBox.show(g);
		swimBox.show(g);
		sellBox.show(g);
		fishingBox.show(g);
	}

	@Override
	public void update()
	{
		shopBox.update();
		stashBox.update();
		swimBox.update();
		sellBox.update();
		fishingBox.update();
	}

	@Override
	public void mouseReleased()
	{
		shopBox.mouseReleased();
		stashBox.mouseReleased();
		swimBox.mouseReleased();
		sellBox.mouseReleased();
		fishingBox.mouseReleased();
	}

	/**
	 * {@inheritDoc} <b> 0 = shopBox<br>
	 * 1 = stashBox<br>
	 * 2 = swimBox<br>
	 * 3 = sellBox<br>
	 * 4 = fishingBox</b>
	 * 
	 * @param clickHandler
	 *            - The clickHandler used for the text box upon clicking
	 * @param index
	 *            - Index of box to modify
	 */
	@Override
	public void setListener(ClickHandler clickHandler, int index)
	{
		switch (index)
		{
			case 0:
				shopBox.setClickHandler(clickHandler);
				break;

			case 1:
				stashBox.setClickHandler(clickHandler);
				break;

			case 2:
				swimBox.setClickHandler(clickHandler);
				break;

			case 3:
				sellBox.setClickHandler(clickHandler);
				break;

			case 4:
				fishingBox.setClickHandler(clickHandler);
				break;
		}
	}
};
