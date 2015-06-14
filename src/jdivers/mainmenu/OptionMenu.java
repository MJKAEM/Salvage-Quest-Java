package jdivers.mainmenu;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import jdivers.ContentLoader;
import jdivers.Global;
import jdivers.AbstractMenu;
import jdivers.textbox.BasicTextBox;
import jdivers.textbox.ClickHandler;
import jdivers.textbox.ClickTextBox;
import jdivers.textbox.SpecialClickTextBox;

public class OptionMenu extends AbstractMenu
{
	private static Image screenImage = ContentLoader.backgroundImages[1];

	private ClickTextBox exitBox;

	public OptionMenu()
	{
		super();

		final Color boxBorderColor = new Color(255, 255, 255, 100);

		exitBox = new SpecialClickTextBox("Exit",
				0,
				Global.threeFourthHeight,
				BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
				BasicTextBox.DEFAULT_TEXTBOX_HEIGHT,
				boxBorderColor,
				null,
				null,
				Color.white,
				Color.yellow);
	}

	@Override
	public void show(Graphics g)
	{
		// Display background image.
		//
		g.drawImage(screenImage, 0, 0, Global.width, Global.height, 0, 0, 800,
				600);

		// Display the clickable boxes.
		//
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
	public void setListener(final ClickHandler clickHandler, final int index)
	{
		switch (index)
		{
			case -1:
				exitBox.setClickHandler(clickHandler);
				break;

			default:
				throw new IllegalArgumentException("Index is out of range!");
		}
	}
};
