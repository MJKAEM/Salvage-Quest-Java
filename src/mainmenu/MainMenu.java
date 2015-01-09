package mainmenu;

import org.newdawn.slick.Graphics;

public class MainMenu extends AbstractMenu
{
	public MainMenu()
	{
	}
	
	@Override
	public void show(final Graphics g)
	{
		drawTextBox(g, "Hi!", 20, 20, 100, 100);
	}

	@Override
	public void update()
	{
	}
};
