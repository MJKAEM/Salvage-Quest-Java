package jdivers.playmenu;

import jdivers.AbstractMenu;
import jdivers.Global;
import jdivers.textbox.BasicTextBox;
import jdivers.textbox.ClickHandler;
import jdivers.textbox.ClickTextBox;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class BankMenu extends AbstractMenu
{
	private ClickTextBox exitBox;

	public BankMenu()
	{
		exitBox = new ClickTextBox(
				"Exit",
				Global.width - BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
				0,
				BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
				BasicTextBox.DEFAULT_TEXTBOX_HEIGHT,
				Color.darkGray,
				new Color(128, 128, 255, 100),
				new Color(128, 128, 255, 200),
				Color.white,
				Color.yellow);
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
		switch (index)
		{
			case -1:

				break;
		}
	}
};
