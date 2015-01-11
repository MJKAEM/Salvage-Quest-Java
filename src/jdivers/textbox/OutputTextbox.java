package jdivers.textbox;

import jdivers.Global;

import org.newdawn.slick.Graphics;

public class OutputTextbox extends AbstractTextbox
{
	public OutputTextbox()
	{
		// final int resPosYPlace = (int)(JDivers.height * 0.75);
		// final int resHeight = (int)(JDivers.height - 20)

		super(null,
				20,
				(int) (Global.height * 0.75),
				Global.width - 40,
				(int) (Global.height - (Global.height * 0.75) - 20));

	}

	@Override
	public void show(Graphics g)
	{
		g.drawRect(getBoxPosX(), getBoxPosY(), getBoxWidth(), getBoxHeight());
	}

	public void println(final String text)
	{
		System.out.println(text);
	}
};