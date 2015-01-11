package jdivers.textbox;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class ClickTextbox extends AbstractTextbox
{
	private boolean mouseOver;

	public ClickTextbox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight)
	{
		super(text, boxPosX, boxPosY, boxWidth, boxHeight);
	}

	@Override
	public void show(final Graphics g)
	{
		if (mouseOver)
		{
			g.setColor(Color.black);
		}
		else
		{
			g.setColor(Color.white);
		}
		
		g.drawString(
				getText(),
				getStartTextXTextBox(g.getFont(), getText(), getBoxPosX(),
						getBoxWidth()),
				getStartTextYTextBox(g.getFont(), getText(), getBoxPosY(),
						getBoxHeight()));
		g.fillRect(getBoxPosX(), getBoxPosY(), getBoxWidth(), getBoxHeight());
	}

	public void update()
	{
		mouseOver = mouseInBox();

		System.out.println(mouseOver);
		
		if (mouseOver)
		{
			if (Mouse.isButtonDown(1))
			{
				
			}
		}
	}

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
		return (Mouse.getY() > getBoxPosY() && Mouse.getY() < getBoxPosY() + getBoxHeight());
	}
};
