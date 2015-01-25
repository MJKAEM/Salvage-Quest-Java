package jdivers.textbox;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class TransparentClickTextBox extends ClickTextBox
{
	public TransparentClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, null);
	}

	public TransparentClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color textCol)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, null, textCol);
	}

	public TransparentClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxCol, final Color textCol)
	{
		super(text, boxPosX, boxPosY, boxWidth, boxHeight, boxCol, textCol);

		if (boxCol == null)
		{
			setBoxCol(new Color(255, 255, 255, 100));
		}
		else
		{
			getBoxCol().a = 100;
		}
	}

	/**
	 * Displays text in two partially transparent horizontal lines. The text
	 * changes to yellow.
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

		g.setColor(getBoxCol());

		g.drawLine(getBoxPosX(), getBoxPosY(), getBoxPosX() + getBoxWidth(),
				getBoxPosY());
		g.drawLine(getBoxPosX(), getBoxPosY() + getBoxHeight(),
				getBoxPosX() + getBoxWidth(), getBoxPosY() + getBoxHeight());

	}
};
