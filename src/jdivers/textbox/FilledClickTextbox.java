package jdivers.textbox;

import org.newdawn.slick.Color;

public class FilledClickTextbox extends ClickTextbox
{
	public FilledClickTextbox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxCol)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, boxCol, null);
	}

	public FilledClickTextbox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxCol, final Color textCol)
	{
		super(text, boxPosX, boxPosY, boxWidth, boxHeight, boxCol, textCol);
	}

};
