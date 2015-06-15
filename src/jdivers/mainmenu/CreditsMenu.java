package jdivers.mainmenu;

import org.newdawn.slick.Graphics;

import jdivers.Global;
import jdivers.MainMenuState;
import jdivers.AbstractMenu;
import jdivers.textbox.BasicTextBox;
import jdivers.textbox.ClickHandler;
import jdivers.textbox.ClickTextBox;

@Deprecated
public class CreditsMenu extends AbstractMenu
{
	private ClickTextBox exitBox;

	public CreditsMenu()
	{
		super();

		exitBox = new ClickTextBox("Exit",
				Global.halfWidth - BasicTextBox.DEFAULT_TEXTBOX_HALF_WIDTH,
				Global.quarterHeight,
				BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
				BasicTextBox.DEFAULT_TEXTBOX_HEIGHT);
	}

	@Override
	public void show(Graphics g)
	{
		exitBox.show(g);
	}

	@Override
	public void update()
	{
		exitBox.update();
	}

	@Override
	public void mouseReleased()
	{
		exitBox.mouseReleased();
	}

	@Override
	public void setClickHandler(ClickHandler clickHandler, int index)
	{
		// TODO Auto-generated method stub
		
	}
};
