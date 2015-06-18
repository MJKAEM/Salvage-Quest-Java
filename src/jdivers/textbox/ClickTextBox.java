package jdivers.textbox;

import java.util.IllegalFormatException;

import jdivers.Global;
import jdivers.MouseFix;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 * A text box that contains text inside of a box. The box can be either
 * transparent or colored, depending on the input in the constructor. The text
 * box can be rendered onto the screen.<br>
 * <br>
 * When the mouse hovers over it, it will change into a mouse over state, which
 * will change the color of the box. Clicking the box will perform an action
 * based on the click handler.
 * 
 * @author Artanis Margatroid
 *
 */
public class ClickTextBox extends BasicTextBox
{
	private ClickHandler clickHandler;

	private Color boxMouseOverColor, currentBoxFillColor;
	private Color textMouseOverColor, currentTextColor;

	/**
	 * Constructs a text box that contains text inside an enclosed box. It
	 * changes color when the mouse hovers over it, and by clicking it, it will
	 * perform an action.
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
	 * @see jdivers.textbox.BasicTextBox#BasicTextBox(String, int, int, int,
	 *      int)
	 */
	public ClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, Color.black, null,
				Color.white);
	}

	/**
	 * Constructs a text box that contains text inside an enclosed box. It
	 * changes color when the mouse hovers over it; and by clicking it, it will
	 * perform an action.
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
	 * @see jdivers.textbox.BasicTextBox#BasicTextBox(String, int, int, int,
	 *      int, Color, Color, Color)
	 */
	public ClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxBorderColor, final Color boxFillColor,
			final Color textColor)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, boxBorderColor,
				boxFillColor, null, textColor, Color.yellow);
	}

	/**
	 * Constructs a text box that contains text inside an enclosed box. It
	 * changes color when the mouse hovers over it; and by clicking it, it will
	 * perform an action.
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
	 * @param boxMouseOverColor
	 *            the color of the inside area of the box when the mouse is
	 *            hovering over it; if <code>null</code>, it will be transparent
	 * @param textColor
	 *            the color of the text in the box; if <code>null</code>, it
	 *            will be white
	 * @param textMouseOverColor
	 *            the color of the text in the box when the mouse is hovering
	 *            over it; if <code>null</code>, it will be white
	 * @see jdivers.textbox.BasicTextBox#BasicTextBox(String, int, int, int,
	 *      int, Color, Color, Color)
	 */
	public ClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxBorderColor, final Color boxFillColor,
			final Color boxMouseOverColor, final Color textColor,
			final Color textMouseOverColor)
	{
		super(text, boxPosX, boxPosY, boxWidth, boxHeight, boxBorderColor,
				boxFillColor, textColor);

		// currentBoxFillColor = boxBorderColor;

		this.boxMouseOverColor = boxMouseOverColor;
		this.textMouseOverColor = textMouseOverColor;

		this.currentBoxFillColor = getBoxFillColor();
	}

	@Override
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
		try
		{
			if (getBoxBorderColor() != null)
			{
				g.setColor(getBoxBorderColor());

				g.drawRect(getBoxPosX(), getBoxPosY(), getBoxWidth(),
						getBoxHeight());
			}
		}
		catch (NullPointerException e)
		{
			System.err.printf("%nNullPointerException! " +
					"boxBorderColor is null!%n%s", toString());
			System.exit(Global.NULL_POINTER_EXCEPTION_CODE);
		}

		// Color the inside of the box. If it is null, it will be
		// transparent.
		//
		try
		{
			if (getCurrentBoxFillColor() != null)
			{
				g.setColor(getCurrentBoxFillColor());

				g.fillRect(getBoxPosX() + 1, getBoxPosY() + 1,
						getBoxWidth() - 1, getBoxHeight() - 1);
			}
		}
		catch (NullPointerException e)
		{
			System.err.printf("%nNullPointerException! " +
					"boxBorderColor is null!%n%s", toString());
			System.exit(Global.NULL_POINTER_EXCEPTION_CODE);
		}

		// Draws the text after setting its color. If text is null, then it will
		// not render.
		//
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

	public void update()
	{
		if (mouseInBox())
		{
			currentBoxFillColor = boxMouseOverColor;
			currentTextColor = textMouseOverColor;
		}
		else
		{
			currentBoxFillColor = getBoxFillColor();
			currentTextColor = getTextColor();
		}
	}

	public void mouseReleased()
	{
		try
		{
			if (mouseInBox())
			{
				clickHandler.onClick();
			}
		}
		catch (NullPointerException e)
		{
			System.err.printf("%nNullPointerException! " +
					"ClickHandler not set for:%n%s",
					toString());
			System.exit(1);
		}
	}

	@Override
	public String toString()
	{
		try
		{
			return String
					.format("ClickTextBox " +
							"[text=%s, " +
							"boxPosX=%d, boxPosY=%d, boxWidth=%d, boxHeight=%d]",
							getText(), getBoxPosX(), getBoxPosY(),
							getBoxWidth(), getBoxHeight());
		}
		catch (IllegalFormatException e)
		{
			System.err.printf("\nIllegalFormatException! " +
					"The formatting toString system failed!\n\"%s\"\n",
					getClass());
			System.exit(Global.ILLEGAL_FORMAT_EXCEPTION_CODE);

			// Unreachable code, just to please Java.
			//
			throw e;
		}
	}

	//
	// Mouse Methods
	//

	public boolean mouseInBox()
	{
		return mouseInX() && mouseInY();
	}

	private boolean mouseInX()
	{
		return (Mouse.getX() > getBoxPosX() && Mouse.getX() < getBoxPosX() + getBoxWidth());
	}

	private boolean mouseInY()
	{
		return (MouseFix.getMouseY() > getBoxPosY() && MouseFix.getMouseY() < getBoxPosY() + getBoxHeight());
	}

	//
	// Getter / Setters
	//

	public ClickHandler getClickHandler()
	{
		return clickHandler;
	}

	public void setClickHandler(ClickHandler clickHandler)
	{
		this.clickHandler = clickHandler;
	}

	public Color getBoxMouseOverColor()
	{
		return boxMouseOverColor;
	}

	public void setBoxMouseOverColor(Color boxMouseOverColor)
	{
		this.boxMouseOverColor = boxMouseOverColor;
	}

	public Color getCurrentBoxFillColor()
	{
		return currentBoxFillColor;
	}

	public void setCurrentBoxFillColor(Color currentBoxFillColor)
	{
		this.currentBoxFillColor = currentBoxFillColor;
	}

	public Color getTextMouseOverColor()
	{
		return textMouseOverColor;
	}

	public void setTextMouseOverColor(Color textMouseOverColor)
	{
		this.textMouseOverColor = textMouseOverColor;
	}

	public Color getCurrentTextColor()
	{
		return currentTextColor;
	}

	public void setCurrentTextColor(Color currentTextColor)
	{
		this.currentTextColor = currentTextColor;
	}
};
