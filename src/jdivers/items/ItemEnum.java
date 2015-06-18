package jdivers.items;

import jdivers.ContentLoader;
import jdivers.playmenu.MainHubMenu;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * Stores the information of all items into one Enum file. Used if the class
 * implementations of items is unnecessary.
 * 
 * @author Artanis Margatroid
 *
 */
public enum ItemEnum
{
	Sapphire(1, ContentLoader.itemImages[1], 1, true, MainHubMenu.class
			.getName(), 20),
	Ruby(2, ContentLoader.itemImages[2], 1, true, MainHubMenu.class.getName(),
			50),
	Gold(3, ContentLoader.itemImages[3], 1, true, MainHubMenu.class.getName(),
			100),
	Diamond(4, ContentLoader.itemImages[4], 1, true, MainHubMenu.class
			.getName(), 200),
	Emerald(5, ContentLoader.itemImages[5], 1),
	OilBarrel(6, null, 2, true, MainHubMenu.class.getName(), 175),
	O2Tank(7, null, 4);

	private final int id;
	private final Image image;
	private final boolean sellable;
	private final String menuSold;
	private final int moneyValue, spaceUsed;

	private ItemEnum(final int id, final Image image)
	{
		this(id, image, 1);
	}

	private ItemEnum(final int id, final Image image, final int spaceUsed)
	{
		this(id, image, spaceUsed, false, null, 0);
	}

	private ItemEnum(final int id, final Image image, final int spaceUsed,
			final boolean sellable, final String menuSold, final int moneyValue)
	{
		if (spaceUsed < 1)
		{
			throw new IllegalArgumentException(
					"Ha ha, wow. Don't make me laugh.");
		}

		this.id = id;
		this.spaceUsed = spaceUsed;
		this.moneyValue = moneyValue;
		this.menuSold = menuSold;
		this.sellable = sellable;
		this.image = image;
	}

	public void show(final Graphics g, final int x, final int y)
	{
		g.drawImage(image, x, y);
	}
	
	public static ItemEnum translateId(final int id)
	{
		switch (id)
		{
			case 0:
				return null;

			case 1:
				return Sapphire;

			case 2:
				return Ruby;

			case 3:
				return Gold;

			case 4:
				return Diamond;

			case 5:
				return Emerald;

			case 6:
				return OilBarrel;

			case 7:
				return O2Tank;

			default:
				throw new IllegalArgumentException("ID input is out of range!");
		}
	}

	//
	// Getters / Setters
	//
	
	public Image getImage()
	{
		return this.image;
	}

	public String getMenuSold()
	{
		return this.menuSold;
	}

	public int getMoneyValue()
	{
		return this.moneyValue;
	}

	public int getSpaceUsed()
	{
		return this.spaceUsed;
	}

	public boolean isSellable()
	{
		return this.sellable;
	}

	public int getId()
	{
		return this.id;
	}
};
