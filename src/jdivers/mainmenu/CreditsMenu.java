package jdivers.mainmenu;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import jdivers.Global;
import jdivers.MainMenuState;
import jdivers.Menu;
import jdivers.textbox.AbstractTextbox;
import jdivers.textbox.ClickTextbox;

public class CreditsMenu extends Menu
{
	private ClickTextbox exitBox;

	public CreditsMenu()
	{
		super();

		exitBox = new ClickTextbox("Exit",
				Global.halfWidth - AbstractTextbox.DEFAULT_TEXTBOX_HALF_WIDTH,
				Global.quarterHeight,
				AbstractTextbox.DEFAULT_TEXTBOX_WIDTH,
				AbstractTextbox.DEFAULT_TEXTBOX_HEIGHT);
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
	}

	@Override
	public void mouseReleased()
	{
		exitBox.mouseReleased();
	}
};
