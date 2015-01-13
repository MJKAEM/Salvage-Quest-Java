package jdivers.mainmenu;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import jdivers.Global;
import jdivers.Menu;
import jdivers.textbox.ClickTextbox;

public class OptionMenu implements Menu
{
	private ClickTextbox exitBox;

	public OptionMenu()
	{
		exitBox = new ClickTextbox("Exit",
				Global.quarterWidth - 50,
				Global.halfHeight,
				100,
				100);
	}

	@Override
	public void show(Graphics g)
	{

	}

	@Override
	public void update(StateBasedGame sbg)
	{
		// TODO Auto-generated method stub

	}

};
