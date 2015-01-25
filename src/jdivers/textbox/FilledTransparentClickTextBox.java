package jdivers.textbox;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

@Deprecated
public class FilledTransparentClickTextBox extends SpecialClickTextBox
{
	private Color innerBoxCol;

	public FilledTransparentClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxCol)
	{
		this(text, boxPosX, boxPosY, boxWidth, boxHeight, boxCol, null);
	}

	public FilledTransparentClickTextBox(final String text, final int boxPosX,
			final int boxPosY, final int boxWidth, final int boxHeight,
			final Color boxCol, final Color textCol)
	{
		super(text, boxPosX, boxPosY, boxWidth, boxHeight, boxCol, textCol);

		this.innerBoxCol = boxCol;

		if (innerBoxCol == null)
		{
			this.innerBoxCol = new Color(255, 255, 255, 100);
		}
		else
		{
			innerBoxCol = new Color(innerBoxCol.getRed(),
					innerBoxCol.getGreen(), innerBoxCol.getBlue(), 100);
		}
	}

	@Override
	public void show(final Graphics g)
	{
		g.setColor(getInnerBoxCol());
		g.fillRect(
				getBoxPosX() + 1,
				getBoxPosY() + 1,
				getBoxWidth() - 2,
				getBoxHeight() - 2);

		super.show(g);
	}

	//
	// Getters and Setters
	//

	public Color getInnerBoxCol()
	{
		return innerBoxCol;
	}

	public void setInnerBoxCol(Color innerBoxCol)
	{
		this.innerBoxCol = innerBoxCol;
	}
};
