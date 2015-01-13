package jdivers;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public interface Menu
{
	public void show(final Graphics g);

	public void update(StateBasedGame sbg);
};
