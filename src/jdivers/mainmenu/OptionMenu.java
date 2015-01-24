package jdivers.mainmenu;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import jdivers.ContentLoader;
import jdivers.Global;
import jdivers.MainMenuState;
import jdivers.AbstractMenu;
import jdivers.textbox.AbstractTextbox;
import jdivers.textbox.ClickHandler;
import jdivers.textbox.ClickTextbox;
import jdivers.textbox.TransparentClickTextbox;

public class OptionMenu extends AbstractMenu
{
	private static Image screenImage = ContentLoader.backgroundImages[1];

	private ClickTextbox exitBox;

	public OptionMenu()
	{
		super();

		exitBox = new TransparentClickTextbox("Exit",
				0,
				Global.threeFourthHeight,
				AbstractTextbox.DEFAULT_TEXTBOX_WIDTH,
				AbstractTextbox.DEFAULT_TEXTBOX_HEIGHT);
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
				exitBox.setListener(clickHandler);
				break;

			default:
				throw new IllegalArgumentException("Index is out of range!");
		}
	}
};
