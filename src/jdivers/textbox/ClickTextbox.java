package jdivers.textbox;

import jdivers.MouseFix;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 * A text box that displays a box and text. It can be clicked.
 * 
 * @author Artanis Margatroid
 *
 */
public class ClickTextbox extends AbstractTextbox
{
	private ClickHandler clickHandler;
	private boolean mouseOver;

	public ClickTextbox(final String text, final int boxPosX,
			final int boxPosY)
	{
		this(text, boxPosX, boxPosY, AbstractTextbox.DEFAULT_TEXTBOX_WIDTH,
				AbstractTextbox.DEFAULT_TEXTBOX_HEIGHT);
	}

	public ClickTextbox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, null);
	}

	public ClickTextbox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxCol)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, null, null);
	}

	public ClickTextbox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxCol, final Color textCol)
	{
		super(text, boxPosX, boxPosY, boxWidth, boxHeight, boxCol, textCol);
	}

	@Override
	public void show(final Graphics g)
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

		if (getTextCol() == null)
		{
			g.setColor(Color.white);

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

		g.setColor(Color.black);
		g.drawRect(getBoxPosX(), getBoxPosY(), getBoxWidth(), getBoxHeight());
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
