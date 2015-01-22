package jdivers;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Menu
{
	public abstract void show(final Graphics g);

	public abstract void update(StateBasedGame sbg);
	
	public abstract void mouseReleased();
};
