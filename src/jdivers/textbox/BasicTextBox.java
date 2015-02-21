package jdivers.textbox;

import java.util.IllegalFormatException;

import jdivers.Global;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;


/**
 * A text box that contains text inside of a box. The box can be either
 * transparent or colored, depending on the input in the constructor. The text
 * box can be rendered onto the screen.
 * 
 * @author Artanis Margatroid
 *
 */
public class BasicTextBox
{
	public static final int DEFAULT_TEXTBOX_HEIGHT = 50;
	public static final int DEFAULT_TEXTBOX_WIDTH = 100;

	public static final int DEFAULT_TEXTBOX_HALF_HEIGHT = DEFAULT_TEXTBOX_HEIGHT >> 1;
	public static final int DEFAULT_TEXTBOX_HALF_WIDTH = DEFAULT_TEXTBOX_WIDTH >> 1;

	private String text;
	private Color textColor, boxBorderColor, boxFillColor;

	private int boxPosX, boxPosY;
	private int boxWidth, boxHeight;

	/**
	 * Empty constructor that will never be used.
	 */
	@SuppressWarnings("unused")
	private BasicTextBox()
	{
		
	}
	
	/**
	 * Constructs a text box that contains text inside an enclosed box.
	 * 
	 * @param text
	 *            the text to display in the box
	 * @param boxPosX
	 *            the x-axis position of the left side of box
	 * @param boxPosY
	 *            the y-axis position of top side the box
	 * @param boxWidth
	 *            the size of the box, extending to the right
	 * @param boxHeight
	 *            the size of the box, extending downward
	 */
	protected BasicTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, Color.black, null,
				Color.white);
	}

	/**
	 * Constructs a text box that contains text inside an enclosed box.
	 * 
	 * @param text
	 *            the text to display in the box
	 * @param boxPosX
	 *            the x-axis position of the left side of box
	 * @param boxPosY
	 *            the y-axis position of top side the box
	 * @param boxWidth
	 *            the size of the box, extending to the right
	 * @param boxHeight
	 *            the size of the box, extending downward
	 * @param boxBorderColor
	 *            the color of the outside area of the box; if <code>null</code>
	 *            , it will be transparent
	 * @param boxFillColor
	 *            the color of the inside area of the box; if <code>null</code>,
	 *            it will be transparent
	 * @param textColor
	 *            the color of the text in the box
	 * @throws IllegalArgumentException
	 *             if textColor is <code>null</code>
	 */
	protected BasicTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxBorderColor, final Color boxFillColor,
			final Color textColor)
	{
		if (textColor == null)
		{
			throw new IllegalArgumentException(
					"The textColor input cannot be null!");
		}

		this.text = text;
		this.boxPosX = boxPosX;
		this.boxPosY = boxPosY;
		this.boxWidth = boxWidth;
		this.boxHeight = boxHeight;
		this.boxBorderColor = boxBorderColor;
		this.boxFillColor = boxFillColor;
		this.textColor = textColor;
		
		//setTextColor(null);
	}

	/**
	 * Displays text inside of a box, which is either transparent or filled
	 * depending on the input of the constructor.
	 * 
	 * @param g
	 *            Graphics
	 */
	public void show(final Graphics g)
	{
		// Set line width. This can also test if graphics is passed as null.
		//
		try
		{
			g.setLineWidth(1);
		}
		catch (NullPointerException e)
		{
			System.err.printf("%nNullPointerException! " +
					"Graphics input is null!%n%s", toString());
			System.exit(Global.NULL_POINTER_EXCEPTION_CODE);
		}

		// Draw the box perimeter. If it is null, it will be transparent.
		//
		if (getBoxBorderColor() != null)
		{
			g.setColor(getBoxBorderColor());

			g.drawRect(getBoxPosX(), getBoxPosY(), getBoxWidth(),
					getBoxHeight());
		}

		// Color the inside of the box. If it is null, it will be
		// transparent.
		//
		if (getBoxFillColor() != null)
		{
			g.setColor(getBoxFillColor());

			g.fillRect(getBoxPosX() + 1, getBoxPosY() + 1,
					getBoxWidth() - 2, getBoxHeight() - 2);
		}

		// Draws the text after setting its color. If text is null, then it will
		// not render.
		//
		if (getText() != null)
		{
			try
			{
				g.setColor(getTextColor());
			}
			catch (NullPointerException e)
			{
				System.err.printf("%nNullPointerException! " +
						"The textColor is null!%n%s", toString());
				System.exit(Global.NULL_POINTER_EXCEPTION_CODE);
			}

			try
			{
				g.drawString(
						getText(),
						getStartTextXTextBox(g.getFont(), getText(),
								getBoxPosX(), getBoxWidth()),
						getStartTextYTextBox(g.getFont(), getText(),
								getBoxPosY(), getBoxHeight()));
			}
			catch (NullPointerException e)
			{
				System.err.printf("%nNullPointerException! " +
						"The font is null!%n%s", toString());
				System.exit(Global.NULL_POINTER_EXCEPTION_CODE);
			}
		}
	}

	@Override
	public String toString()
	{
		try
		{
			return String
					.format("BasicTextBox " +
							"[text=%s, " +
							"boxPosX=%d, boxPosY=%d, boxWidth=%d, boxHeight=%d]",
							getText(), getBoxPosX(), getBoxPosY(),
							getBoxWidth(), getBoxHeight());
		}
		catch (IllegalFormatException e)
		{
			System.err.printf("%nIllegalFormatException! " +
					"The formatting toString system failed!%n\"%s\"",
					getClass());
			System.exit(Global.ILLEGAL_FORMAT_EXCEPTION_CODE);

			// Unreachable code, just to please Java.
			//
			throw e;
		}
	}

	//
	// Getters / Setters
	//

	public String getText()
	{
		return text;
	}

	public void setText(final String text)
	{
		this.text = text;
	}

	public final int getBoxPosX()
	{
		return boxPosX;
	}

	public final void setBoxPosX(final int boxPosX)
	{
		this.boxPosX = boxPosX;
	}

	public final int getBoxPosY()
	{
		return boxPosY;
	}

	public final void setBoxPosY(final int boxPosY)
	{
		this.boxPosY = boxPosY;
	}

	public final int getBoxWidth()
	{
		return boxWidth;
	}

	public final void setBoxWidth(final int boxWidth)
	{
		this.boxWidth = boxWidth;
	}

	public final int getBoxHeight()
	{
		return boxHeight;
	}

	public final void setBoxHeight(final int boxHeight)
	{
		this.boxHeight = boxHeight;
	}

	public final Color getBoxBorderColor()
	{
		return boxBorderColor;
	}

	public final void setBoxBorderColor(final Color boxBorderColor)
	{
		this.boxBorderColor = boxBorderColor;
	}

	public final Color getTextColor()
	{
		return textColor;
	}

	public final void setTextColor(final Color textColor)
	{
		if (textColor == null)
		{
			throw new IllegalArgumentException(
					"The textColor input cannot be null!");
		}
		
		this.textColor = textColor;
	}

	public final Color getBoxFillColor()
	{
		return boxFillColor;
	}

	public final void setBoxFillColor(final Color boxFillColor)
	{
		this.boxFillColor = boxFillColor;
	}

	/**
	 * Returns an integer that properly places text in its proper x-axis
	 * position in a text box.
	 * 
	 * @param font
	 *            font used in the text
	 * @param text
	 *            text written out in the box
	 * @param boxPosX
	 *            x-axis position of the box
	 * @param boxWidth
	 *            width of the box
	 * @return an integer
	 */
	public static int getStartTextXTextBox(final Font font,
			final String text, final int boxPosX, final int boxWidth)
	{
		final int textWidth = font.getWidth(text);
		final int centerBox = boxPosX + (boxWidth / 2);

		final int centerTextAndBox = centerBox - (textWidth / 2);

		return centerTextAndBox;
	}

	/**
	 * Returns an integer that properly places text in its proper y-position in
	 * a text box.
	 * 
	 * @param font
	 *            font used in the text
	 * @param text
	 *            text written out in the box
	 * @param boxPosY
	 *            y-position of the box
	 * @param boxHeight
	 *            height of the box
	 * @return an integer
	 */
	public static int getStartTextYTextBox(final Font font,
			final String text, final int boxPosY, final int boxHeight)
	{
		final int textHeight = font.getHeight(text);
		final int centerBox = boxPosY + (boxHeight / 2);

		final int centerTextAndBox = centerBox - (textHeight / 2);

		return centerTextAndBox;
	}

	/**
	 * Unfinished.
	 */
	public static int getStartTextYTextBox(final Font font, final String text,
			final int boxPosX, final int boxPosY, final int boxWidth,
			final int boxHeight)
	{

		final int textPosX = getStartTextXTextBox(font, text, boxPosX, boxWidth);

		// if()
		final int textHeight = font.getHeight(text);
		final int centerBox = boxPosY + (boxHeight / 2);

		final int centerTextAndBox = centerBox - (textHeight / 2);
		throw new UnsupportedOperationException("Not implemented.");
		// return centerTextAndBox;
	}
};
