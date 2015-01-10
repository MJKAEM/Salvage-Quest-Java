package jdivers.textbox;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class ClickTextbox extends AbstractTextbox
{
	private boolean mouseOver;

	public ClickTextbox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight)
	{
		super(text, boxPosX, boxPosY, boxWidth, boxHeight);
	}

	@Override
	public void show(final Graphics g)
	{
		if (mouseOver)
		{

		}
		else
		{
			g.setColor(Color.white);
		}
		super.show(g);
	}
};
