package jdivers.textbox;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class SpecialClickTextBox extends ClickTextBox
{
	public SpecialClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, null);
	}

	public SpecialClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color textCol)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, null, textCol);
	}

	public SpecialClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxCol, final Color textCol)
	{
		super(text, boxPosX, boxPosY, boxWidth, boxHeight, boxCol, textCol);

		if (boxCol == null)
		{
			setBoxBorderColor(new Color(255, 255, 255, 100));
		}
		else
		{
			setBoxBorderColor(new Color(getBoxBorderColor().getRed(), getBoxBorderColor().getGreen(),
					getBoxBorderColor().getBlue(), 200));
		}
	}

	/**
	 * Displays text in two partially transparent horizontal lines. The text
	 * changes to yellow.
	 */
	@Override
	public void show(final Graphics g)
	{
		try
		{
			if (mouseInBox())
			{
				g.setColor(Color.yellow);
			}
			else
			{
				g.setColor(getTextColor());
			}

			g.drawString(
					getText(),
					getStartTextXTextBox(g.getFont(), getText(), getBoxPosX(),
							getBoxWidth()),
					getStartTextYTextBox(g.getFont(), getText(), getBoxPosY(),
							getBoxHeight()));

			g.setLineWidth(2);

			// Draws the outline of the box.
			//
			g.setColor(getBoxBorderColor());

			g.drawLine(getBoxPosX(), getBoxPosY(),
					getBoxPosX() + getBoxWidth(),
					getBoxPosY());
			g.drawLine(getBoxPosX(), getBoxPosY() + getBoxHeight(),
					getBoxPosX() + getBoxWidth(), getBoxPosY() + getBoxHeight());
		}
		catch (NullPointerException e)
		{
			System.err.println("NullPointerException " +
					"TextBox Error\n" + toString());
			System.exit(1);
		}
	}
};
