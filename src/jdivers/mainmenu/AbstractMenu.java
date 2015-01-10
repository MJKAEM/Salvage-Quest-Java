package jdivers.mainmenu;

import org.newdawn.slick.Graphics;

public abstract class AbstractMenu
{
	protected AbstractMenu()
	{
	}

	public abstract void show(final Graphics g);

	public abstract void update();
};
