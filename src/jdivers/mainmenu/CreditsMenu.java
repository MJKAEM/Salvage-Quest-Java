package jdivers.mainmenu;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import jdivers.Global;
import jdivers.MainMenuState;
import jdivers.Menu;
import jdivers.textbox.ClickTextbox;

public class CreditsMenu extends Menu
{
	private ClickTextbox exitBox;

	public CreditsMenu()
	{
		super();

		exitBox = new ClickTextbox("Exit",
				Global.halfWidth - 50,
				Global.quarterHeight,
				100,
				100);
	}

	@Override
	public void show(Graphics g)
	{
		exitBox.show(g);
	}

	@Override
	public void update(StateBasedGame sbg)
	{
		exitBox.update();

		if (exitBox.isClicked())
		{
			exitBox.isClicked(false);
		}
	}

	@Override
	public void mouseReleased()
	{
		exitBox.mouseReleased();
	}
};
