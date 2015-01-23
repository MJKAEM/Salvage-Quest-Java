package jdivers.textbox;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class TransparentClickTextbox extends ClickTextbox
{
	public TransparentClickTextbox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, null);
	}

	public TransparentClickTextbox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color textCol)
	{
		super(text, boxPosX, boxPosY, boxWidth, boxHeight, null, textCol);
	}

	@Override
	public void show(final Graphics g)
	{
		g.setColor(getTextCol());

		if (mouseInBox())
		{
			g.setColor(Color.yellow);
		}
		else
		{
			g.setColor(Color.white);
		}

		g.drawString(
				getText(),
				getStartTextXTextBox(g.getFont(), getText(), getBoxPosX(),
						getBoxWidth()),
				getStartTextYTextBox(g.getFont(), getText(), getBoxPosY(),
						getBoxHeight()));

		g.setLineWidth(2);

		g.setColor(new Color(255, 255, 255, 100));

		g.drawLine(getBoxPosX(), getBoxPosY(), getBoxPosX() + getBoxWidth(),
				getBoxPosY());
		g.drawLine(getBoxPosX(), getBoxPosY() + getBoxHeight(),
				getBoxPosX() + getBoxWidth(), getBoxPosY() + getBoxHeight());

	}
};
