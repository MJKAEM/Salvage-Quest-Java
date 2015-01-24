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

	/**
	 * Displays text in two partially transparent horizontal lines. The text changes to yellow 
	 */
	@Override
	public void show(final Graphics g)
	{
		if (mouseInBox())
		{
			g.setColor(Color.yellow);
		}
		else
		{
			g.setColor(getTextCol());
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
