package jdivers.textbox;

import jdivers.Global;
import jdivers.items.ItemEnum;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class ClickItemBox extends ClickTextBox
{
	private ItemEnum itemEnum;

	public ClickItemBox(final String text, final ItemEnum itemEnum,
			final int boxPosX, final int boxPosY, final int boxWidth,
			final int boxHeight)
	{
		this(text, itemEnum, boxPosX, boxPosY, boxWidth, boxHeight,
				Color.black, null,
				Color.white);
	}

	public ClickItemBox(final String text, final ItemEnum itemEnum,
			final int boxPosX, final int boxPosY, final int boxWidth,
			final int boxHeight, final Color boxBorderColor,
			final Color boxFillColor, final Color textColor)
	{
		this(text, itemEnum, boxPosX, boxPosY, boxWidth, boxHeight,
				boxBorderColor, boxFillColor, null, textColor, Color.yellow);
	}

	public ClickItemBox(final String text, final ItemEnum itemEnum,
			final int boxPosX, final int boxPosY, final int boxWidth,
			final int boxHeight, final Color boxBorderColor,
			final Color boxFillColor, final Color boxMouseOverColor,
			final Color textColor, final Color textMouseOverColor)
	{
		super(text, boxPosX, boxPosY, boxWidth, boxHeight, boxBorderColor,
				boxFillColor, boxMouseOverColor, textColor, textMouseOverColor);

		this.itemEnum = itemEnum;
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

		// Displays the item in the box. If item is null, then it will not
		// render.
		//
		if (getItemEnum() != null)
		{
			g.setColor(Color.white);

			try
			{
				Image image = getItemEnum().getImage();

				g.drawImage(
						image,
						getProperImagePosX(image, getBoxPosX(),
								getBoxWidth()),
						getProperImagePosY(image, getBoxPosY(),
								getBoxHeight()));
			}
			catch (NullPointerException e)
			{
				System.err.printf("%nNullPointerException! " +
						"The image is null!%n%s", toString());
				System.exit(Global.NULL_POINTER_EXCEPTION_CODE);
			}
		}
	}

	public static float getProperImagePosX(final Image image,
			final int boxPosX, final int boxWidth)
	{
		final float centerX_1 = boxPosX + (boxWidth / 2.0f);
		final float centerX_2 = centerX_1 - (image.getWidth() / 2.0f);

		return centerX_2;
	}

	public static float getProperImagePosY(final Image image,
			final int boxPosY, final int boxHeight)
	{
		final float centerY_1 = boxPosY + (boxHeight / 2.0f);
		final float centerY_2 = centerY_1 - (image.getHeight() / 2.0f) - 5;

		return centerY_2;
	}

	//
	// Getters / Setters
	//

	public ItemEnum getItemEnum()
	{
		return this.itemEnum;
	}

	public void setItemEnumm(final ItemEnum itemEnum)
	{
		this.itemEnum = itemEnum;
	}
};
