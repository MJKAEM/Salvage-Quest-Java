package jdivers;

import jdivers.textbox.ClickHandler;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public abstract class AbstractMenu
{
	public static final int GO_BACK = -1;
	
	/**
	 * Displays the menu graphics on the screen.
	 * 
	 * @param g
	 *            the graphics
	 */
	public abstract void show(final Graphics g);

	/**
	 * Updates all the information in the menu.
	 */
	public abstract void update();

	/**
	 * The action taken after a mouse press is released.
	 */
	public abstract void mouseReleased();

	/**
	 * Sets the listener for a text box.<br>
	 * <br>
	 * 
	 * @param clickHandler
	 *            the clickHandler used for the text box upon clicking
	 * @param index
	 *            index of box to modify
	 */
	public abstract void setClickHandler(final ClickHandler clickHandler, final int index);

	protected void showBackground(final Graphics g, final Image backgroundImage)
	{
		g.drawImage(backgroundImage, 0, 0, Global.width, Global.height, 0, 0,
				800,
				600);
	}
};
