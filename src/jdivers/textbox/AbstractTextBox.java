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
public abstract class AbstractTextBox
{
	public static final int DEFAULT_TEXTBOX_HEIGHT = 50;
	public static final int DEFAULT_TEXTBOX_WIDTH = 100;

	public static final int DEFAULT_TEXTBOX_HALF_HEIGHT = DEFAULT_TEXTBOX_HEIGHT >> 1;
	public static final int DEFAULT_TEXTBOX_HALF_WIDTH = DEFAULT_TEXTBOX_WIDTH >> 1;

	private String text;
	private Color boxCol, textCol;
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
	protected AbstractTextBox(final String text, final int boxPosX,
			final int boxPosY)
	{
		this(text, boxPosX, boxPosY, AbstractTextBox.DEFAULT_TEXTBOX_WIDTH,
				AbstractTextBox.DEFAULT_TEXTBOX_HEIGHT);
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
	protected AbstractTextBox(final String text, final int boxPosX,
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
	 * @param boxCol
	 *            the color of the inside area of the box; if <code>null</code>,
	 *            it will be transparent
	 */
	protected AbstractTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxCol)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, boxCol, null);
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
	 * @param boxCol
	 *            the color of the inside area of the box; if <code>null</code>,
	 *            it will be transparent
	 * @param textCol
	 *            the color of the text in the box; if <code>null</code>, it
	 *            will be white
	 */
	protected AbstractTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxCol, final Color textCol)
	{
		this.text = text;
		this.boxPosX = boxPosX;
		this.boxPosY = boxPosY;
		this.boxWidth = boxWidth;
		this.boxHeight = boxHeight;
		this.boxCol = boxCol;

		// In case textCol is null, the text color will be set to the default
		// color white.
		//
		if (textCol == null)
		{
			this.textCol = Color.white;
		}
		else
		{
			this.textCol = textCol;
		}
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

			// Draw the box. If it is null, it will be transparent.
			//
			if (boxCol == null)
			{
				g.drawRect(getBoxPosX(), getBoxPosY(), getBoxWidth(),
						getBoxHeight());
			}
			else
			{
				g.fillRect(getBoxPosX(), getBoxPosY(), getBoxWidth(),
						getBoxHeight());
			}

			// Draws the text after setting its color.
			//
			g.setColor(textCol);

			g.drawString(
					getText(),
					getStartTextXTextBox(g.getFont(), getText(), getBoxPosX(),
							getBoxWidth()),
					getStartTextYTextBox(g.getFont(), getText(), getBoxPosY(),
							getBoxHeight()));
		}
		catch (NullPointerException e)
		{
			System.out.println("Null pointer error: " + toString());
			System.exit(1);
		}
	}

	@Override
	public String toString()
	{
		return String.format("%s; %s", 
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

	public Color getBoxCol()
	{
		return boxCol;
	}

	public void setBoxCol(Color boxCol)
	{
		this.boxCol = boxCol;
	}

	public Color getTextCol()
	{
		return textCol;
	}

	public void setTextCol(Color textCol)
	{
		this.textCol = textCol;
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
