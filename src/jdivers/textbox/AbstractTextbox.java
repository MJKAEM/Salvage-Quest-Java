package jdivers.textbox;

import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public abstract class AbstractTextbox
{
	private String text;
	private int boxPosX, boxPosY;
	private int boxWidth, boxHeight;

	protected AbstractTextbox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight)
	{
		this.text = text;
		this.boxPosX = boxPosX;
		this.boxPosY = boxPosY;
		this.boxWidth = boxWidth;
		this.boxHeight = boxHeight;
	}
	
	public void show(final Graphics g)
	{
		g.drawString(text,
				getStartTextXTextBox(g.getFont(), text, boxPosX, boxWidth),
				getStartTextYTextBox(g.getFont(), text, boxPosY, boxHeight));
		g.drawRect(boxPosX, boxPosY, boxWidth, boxHeight);
	}
	
	/**
	 * Returns an integer that properly places text in its proper x-position in
	 * a text box.
	 * 
	 * @param font
	 *            font used in the text
	 * @param text
	 *            text written out in the box
	 * @param boxPosX
	 *            x-position of the box
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
	
	public static int getStartTextYTextBox(final Font font,
			final String text, final int boxPosX, final int boxPosY, final int boxWidth, final int boxHeight)
	{
		
		
		final int textPosX = getStartTextXTextBox(font, text, boxPosX, boxWidth);
		
		//if()
		final int textHeight = font.getHeight(text);
		final int centerBox = boxPosY + (boxHeight / 2);

		final int centerTextAndBox = centerBox - (textHeight / 2);
		throw new NotImplementedException();
		//return centerTextAndBox;
	}
};
