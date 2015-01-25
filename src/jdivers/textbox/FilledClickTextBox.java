package jdivers.textbox;

import org.newdawn.slick.Color;

public class FilledClickTextBox extends TransparentClickTextBox
{
	public FilledClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxCol)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, boxCol, null);
	}

	public FilledClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxCol, final Color textCol)
	{
		super(text, boxPosX, boxPosY, boxWidth, boxHeight, boxCol, textCol);
	}

};
