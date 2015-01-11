package jdivers.textbox;

import jdivers.MouseFix;

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
		
		g.fillRect(getBoxPosX(), getBoxPosY(), getBoxWidth(), getBoxHeight());
		
		g.setColor(Color.black);
		g.drawString(
				getText(),
				getStartTextXTextBox(g.getFont(), getText(), getBoxPosX(),
						getBoxWidth()),
				getStartTextYTextBox(g.getFont(), getText(), getBoxPosY(),
						getBoxHeight()));
	}

	public void update()
	{
		mouseOver = mouseInBox();
		System.out.println(mouseInY());
		
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
		return (MouseFix.getMouseY() > getBoxPosY() && MouseFix.getMouseY() < getBoxPosY() + getBoxHeight());
	}
};
