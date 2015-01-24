package jdivers.mainmenu;

import jdivers.ContentLoader;
import jdivers.Global;
import jdivers.MainMenuState;
import jdivers.AbstractMenu;
import jdivers.textbox.AbstractTextbox;
import jdivers.textbox.ClickHandler;
import jdivers.textbox.ClickTextbox;
import jdivers.textbox.TransparentClickTextbox;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class MainMenu extends AbstractMenu
{
	private static final String titleName = "Divers";
	private static Image screenImage = ContentLoader.backgroundImages[0];

	private static AngelCodeFont titleFont;

	private ClickTextbox playBox, optionsBox, exitBox;
	private ClickHandler playHandler, optionsHandler;

	public MainMenu()
	{
		super();

		playBox = new TransparentClickTextbox(
				"Play",
				0,
				Global.halfHeight,
				AbstractTextbox.DEFAULT_TEXTBOX_WIDTH,
				AbstractTextbox.DEFAULT_TEXTBOX_HEIGHT);

		final int widthScreenPlacement = Global.width - AbstractTextbox.DEFAULT_TEXTBOX_WIDTH;

		optionsBox = new TransparentClickTextbox(
				"Options",
				widthScreenPlacement,
				Global.halfHeight,
				AbstractTextbox.DEFAULT_TEXTBOX_WIDTH,
				AbstractTextbox.DEFAULT_TEXTBOX_HEIGHT);

		exitBox = new TransparentClickTextbox("Exit",
				0,
				Global.threeFourthHeight,
				AbstractTextbox.DEFAULT_TEXTBOX_WIDTH,
				AbstractTextbox.DEFAULT_TEXTBOX_HEIGHT);

		exitBox.setListener(new ClickHandler()
		{
			@Override
			public void onClick()
			{
				System.exit(0);
			}
		});
	}

	@Override
	public void show(final Graphics g)
	{
		// Display background image.
		//
		showBackground(g, screenImage);

		// Display the clickable boxes.
		//
		playBox.show(g);
		optionsBox.show(g);
		exitBox.show(g);

		// Display the game name.
		//
		g.setColor(Color.white);
		g.setFont(titleFont);

		final int titleXPlacement = titleFont.getWidth(titleName) >> 1;

		g.drawString(titleName,
				Global.halfWidth - titleXPlacement,
				10);
	}

	@Override
	public void update()
	{
		playBox.update();
		optionsBox.update();
		exitBox.update();
	}

	@Override
	public void mouseReleased()
	{
		playBox.mouseReleased();
		optionsBox.mouseReleased();
		exitBox.mouseReleased();
	}

	/**
	 * Sets the listener for a text box.<br>
	 * <br>
	 * <b> 0 = playBox<br>
	 * 1 = optionsBox</b>
	 * 
	 * @param clickHandler
	 *            the clickHandler used for the text box upon clicking
	 * @param index
	 *            index of box to modify
	 */
	public void setListener(ClickHandler clickHandler, int index)
	{
		switch (index)
		{
			case 0:
				playBox.setListener(clickHandler);
				break;

			case 1:
				optionsBox.setListener(clickHandler);
				break;

			default:
				throw new IllegalArgumentException("Index is out of range!");
		}
	}

	public void setTitleFont(final AngelCodeFont font)
	{
		MainMenu.titleFont = font;
	}
};
