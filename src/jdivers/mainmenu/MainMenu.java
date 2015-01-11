package jdivers.mainmenu;

import jdivers.ContentLoader;
import jdivers.textbox.ClickTextbox;
import jdivers.textbox.OutputTextbox;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class MainMenu extends AbstractMenu
{
	private static Image screenImage = ContentLoader.backgroundImages[0];

	private ClickTextbox box1;

	public MainMenu()
	{
		box1 = new ClickTextbox("Hi!", 20, 20, 100, 100);
	}

	@Override
	public void show(final Graphics g)
	{
		g.drawImage(screenImage, 0, 0);
		box1.show(g);
	}

	@Override
	public void update()
	{
		box1.update();
	}
};
