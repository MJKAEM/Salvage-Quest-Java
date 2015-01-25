package jdivers.textbox;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
	 * Constructs a text box that contains text inside an enclosed box.
	 * 
	 * @param text
	 *            the text to display in the box
	 * @param boxPosX
	 *            the x-axis position of the left side of box
	 * @param boxPosY
	 *            the y-axis position of top side the box
	 */
	protected BasicTextBox(final String text, final int boxPosX,
			final int boxPosY)
	{
		this(text, boxPosX, boxPosY, BasicTextBox.DEFAULT_TEXTBOX_WIDTH,
				BasicTextBox.DEFAULT_TEXTBOX_HEIGHT);
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
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, null);
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
	 */
	protected BasicTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxBorderColor)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, boxBorderColor, null);
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
	 * @param textColor
	 *            the color of the text in the box; if <code>null</code>, it
	 *            will be white
	 */
	protected BasicTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxBorderColor, final Color textColor)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, boxBorderColor, null,
				textColor);
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
	 *            the color of the text in the box; if <code>null</code>, it
	 *            will be white
	 */
	protected BasicTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxBorderColor, final Color boxFillColor,
			final Color textColor)
	{
		this.text = text;
		this.boxPosX = boxPosX;
		this.boxPosY = boxPosY;
		this.boxWidth = boxWidth;
		this.boxHeight = boxHeight;
		this.boxBorderColor = boxBorderColor;

		// In case textCol is null, the text color will be set to the default
		// color white.
		//
		if (textColor == null)
		{
			this.textColor = Color.white;
		}
		else
		{
			this.textColor = textColor;
		}

		this.boxFillColor = boxFillColor;
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
		try
		{
			g.setLineWidth(1);

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

			// Draws the text after setting its color.
			//
			g.setColor(getTextColor());

			g.drawString(
					getText(),
					getStartTextXTextBox(g.getFont(), getText(), getBoxPosX(),
							getBoxWidth()),
					getStartTextYTextBox(g.getFont(), getText(), getBoxPosY(),
							getBoxHeight()));
		}
		catch (NullPointerException e)
		{
			System.err.println("NullPointerException " +
					"TextBox Error\n" + toString());
			System.exit(1);
		}
	}

	@Override
	public String toString()
	{
		return String.format("Text: \"%s\"%n%s",
				getText(),
				super.toString());
	}

	//
	// Getters and Setters
	//

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public int getBoxPosX()
	{
		return boxPosX;
	}

	public void setBoxPosX(int boxPosX)
	{
		this.boxPosX = boxPosX;
	}

	public int getBoxPosY()
	{
		return boxPosY;
	}

	public void setBoxPosY(int boxPosY)
	{
		this.boxPosY = boxPosY;
	}

	public int getBoxWidth()
	{
		return boxWidth;
	}

	public void setBoxWidth(int boxWidth)
	{
		this.boxWidth = boxWidth;
	}

	public int getBoxHeight()
	{
		return boxHeight;
	}

	public void setBoxHeight(int boxHeight)
	{
		this.boxHeight = boxHeight;
	}

	public Color getBoxBorderColor()
	{
		return boxBorderColor;
	}

	public void setBoxBorderColor(Color boxBorderColor)
	{
		this.boxBorderColor = boxBorderColor;
	}

	public Color getTextColor()
	{
		return textColor;
	}

	public void setTextColor(Color textColor)
	{
		this.textColor = textColor;
	}

	public Color getBoxFillColor()
	{
		return boxFillColor;
	}

	public void setBoxFillColor(Color boxFillColor)
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
		throw new NotImplementedException();
		// return centerTextAndBox;
	}
};
