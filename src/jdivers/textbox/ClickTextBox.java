package jdivers.textbox;

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
public class ClickTextBox extends AbstractTextBox
{
	private ClickHandler clickHandler;
	private boolean mouseOver;

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
	 * @see jdivers.textbox.AbstractTextBox#AbstractTextBox(String, int, int)
	 */
	public ClickTextBox(final String text, final int boxPosX,
			final int boxPosY)
	{
		this(text, boxPosX, boxPosY, AbstractTextBox.DEFAULT_TEXTBOX_WIDTH,
				AbstractTextBox.DEFAULT_TEXTBOX_HEIGHT);
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
	 * @see jdivers.textbox.AbstractTextBox#AbstractTextBox(String, int, int,
	 *      int, int)
	 */
	public ClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, null);
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
	 * @param boxCol
	 *            the color of the inside area of the box; if <code>null</code>,
	 *            it will be transparent
	 * @see jdivers.textbox.AbstractTextBox#AbstractTextBox(String, int, int,
	 *      int, int, Color)
	 * 
	 */
	public ClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxCol)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, null, null);
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
	 * @param boxCol
	 *            the color of the inside area of the box; if <code>null</code>,
	 *            it will be transparent
	 * @param textCol
	 *            the color of the text in the box; if <code>null</code>, it
	 *            will be white
	 * @see jdivers.textbox.AbstractTextBox#AbstractTextBox(String, int, int,
	 *      int, int, Color, Color)
	 */
	public ClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxCol, final Color textCol)
	{
		super(text, boxPosX, boxPosY, boxWidth, boxHeight, boxCol, textCol);
	}

	@Override
	public void show(final Graphics g)
	{
		try
		{
			g.setLineWidth(1);

			if (getBoxCol() == null)
			{
				g.drawRect(getBoxPosX(), getBoxPosY(), getBoxWidth(),
						getBoxHeight());
			}
			else
			{
				if (mouseOver)
				{
					g.setColor(Color.cyan);
				}
				else
				{
					g.setColor(getBoxCol());
				}

				g.fillRect(getBoxPosX(), getBoxPosY(), getBoxWidth(),
						getBoxHeight());
			}

			g.drawString(
					getText(),
					getStartTextXTextBox(g.getFont(), getText(), getBoxPosX(),
							getBoxWidth()),
					getStartTextYTextBox(g.getFont(), getText(), getBoxPosY(),
							getBoxHeight()));

			g.setColor(Color.black);
			g.drawRect(getBoxPosX(), getBoxPosY(), getBoxWidth(),
					getBoxHeight());
		}
		catch (NullPointerException e)
		{
			System.out.println("Null error: " + toString());
			System.exit(1);
		}
	}

	public void update()
	{
		mouseOver = mouseInBox();
	}

	public void mouseReleased()
	{
		if (isMouseOver())
		{
			clickHandler.onClick();
		}
	}

	public void setListener(ClickHandler clickHandler)
	{
		this.clickHandler = clickHandler;
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
	// Getters and Setters
	//

	public boolean isMouseOver()
	{
		return mouseOver;
	}

	public void setMouseOver(boolean mouseOver)
	{
		this.mouseOver = mouseOver;
	}
};
