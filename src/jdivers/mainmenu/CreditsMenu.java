package jdivers.mainmenu;

import org.newdawn.slick.Graphics;

import jdivers.Global;
import jdivers.MainMenuState;
import jdivers.AbstractMenu;
import jdivers.textbox.AbstractTextbox;
import jdivers.textbox.ClickHandler;
import jdivers.textbox.ClickTextbox;

@Deprecated
public class CreditsMenu extends AbstractMenu
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
	public void setListener(ClickHandler clickHandler, int index)
	{
		// TODO Auto-generated method stub
		
	}
};
