package jdivers.mainmenu;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

import jdivers.ContentLoader;
import jdivers.Global;
import jdivers.MainMenuState;
import jdivers.Menu;
import jdivers.textbox.ClickTextbox;

public class OptionMenu extends Menu
{
	private static Image screenImage = ContentLoader.backgroundImages[1];

	private ClickTextbox exitBox;

	public OptionMenu()
	{
		super();

		exitBox = new ClickTextbox("Exit",
				Global.halfWidth - 50,
				Global.halfHeight,
				100,
				100);
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
	public void update(StateBasedGame sbg)
	{
		exitBox.update();
	}

	@Override
	public void mouseReleased()
	{
		
	}
};
