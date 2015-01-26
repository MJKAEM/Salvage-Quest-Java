package jdivers.textbox;

import jdivers.Global;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class SpecialClickTextBox extends ClickTextBox
{
	public SpecialClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, Color.black, null,
				Color.white);
	}

	public SpecialClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxBorderColor, final Color boxFillColor,
			final Color textColor)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, boxBorderColor,
				boxFillColor, boxFillColor, textColor, Color.yellow);
	}

	public SpecialClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxBorderColor, final Color boxFillColor,
			final Color boxMouseOverColor, final Color textColor,
			final Color textMouseOverColor)
	{
		super(text, boxPosX, boxPosY, boxWidth, boxHeight, boxBorderColor,
				boxFillColor, boxMouseOverColor, textColor, textMouseOverColor);
	}

	/**
	 * Displays text in two partially transparent horizontal lines. The text
	 * changes when the mouse hovers over it.
	 */
	@Override
	public void show(final Graphics g)
	{
		try
		{
			g.setColor(getCurrentTextColor());
		}
		catch (NullPointerException e)
		{
			System.err.printf("%nNullPointerException! " +
					"Graphics input is null!%n%s", toString());
			System.exit(Global.NULL_POINTER_EXCEPTION_CODE);
		}

		if (getText() != null)
		{
			try
			{
				g.setColor(getCurrentTextColor());
			}
			catch (NullPointerException e)
			{
				System.err.printf("%nNullPointerException! " +
						"textColor is null!%n%s", toString());
				System.exit(Global.NULL_POINTER_EXCEPTION_CODE);
			}

			try
			{
				g.drawString(
						getText(),
						getStartTextXTextBox(g.getFont(), getText(),
								getBoxPosX(),
								getBoxWidth()),
						getStartTextYTextBox(g.getFont(), getText(),
								getBoxPosY(),
								getBoxHeight()));
			}
			catch (NullPointerException e)
			{
				System.err.printf("%nNullPointerException! " +
						"The font is null!%n%s", toString());
				System.exit(Global.NULL_POINTER_EXCEPTION_CODE);
			}
		}

		// Draws the outline of the box.
		//
		if (getBoxBorderColor() != null)
		{
			g.setLineWidth(2);

			g.setColor(getBoxBorderColor());

			g.drawLine(getBoxPosX(), getBoxPosY(),
					getBoxPosX() + getBoxWidth(), getBoxPosY());
			g.drawLine(getBoxPosX(), getBoxPosY() + getBoxHeight(),
					getBoxPosX() + getBoxWidth(),
					getBoxPosY() + getBoxHeight());
		}

		if (getCurrentBoxFillColor() != null)
		{
			g.setColor(getCurrentBoxFillColor());

			g.fillRect(getBoxPosX() + 1, getBoxPosY() + 2,
					getBoxWidth() - 1, getBoxHeight() - 2);
		}
	}
};
