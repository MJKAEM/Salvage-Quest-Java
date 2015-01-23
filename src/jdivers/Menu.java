package jdivers;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Menu
{
	/**
	 * Displays the menu graphics on the screen.
	 * 
	 * @param g
	 *            the graphics
	 */
	public abstract void show(final Graphics g);

	public abstract void update(final StateBasedGame sbg);

	/**
	 * The action taken after a mouse press is released.
	 */
	public abstract void mouseReleased();
};
