package jdivers.items;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

/**
 * Tests methods in the enum ItemEnum. If any of the tests fail, this test file
 * takes precedent over ID's.
 * 
 * @author Artanis Margatroid
 *
 */
public class ItemEnumTest
{
	private static Logger logger =
			Logger.getLogger(ItemEnumTest.class.getName());

	public static final int SAPPHIRE_ID = 1;
	public static final int RUBY_ID = 2;
	public static final int GOLD_ID = 3;
	public static final int DIAMOND_ID = 4;
	public static final int EMERALD_ID = 5;
	public static final int OIL_BARREL_ID = 6;
	public static final int O2_TANK_ID = 7;

	@Test
	public void correctIdTest()
	{
		ItemEnum[] itemArray = ItemEnum.values();

		for (ItemEnum item : itemArray)
		{
			int itemId = item.getId();
			boolean pass = false;

			switch (item)
			{
				case Sapphire:
					if (itemId == SAPPHIRE_ID)
					{
						pass = true;
					}
					break;

				case Ruby:
					if (itemId == RUBY_ID)
					{
						pass = true;
					}
					break;

				case Gold:
					if (itemId == GOLD_ID)
					{
						pass = true;
					}
					break;

				case Diamond:
					if (itemId == DIAMOND_ID)
					{
						pass = true;
					}
					break;

				case Emerald:
					if (itemId == EMERALD_ID)
					{
						pass = true;
					}
					break;

				case OilBarrel:
					if (itemId == OIL_BARREL_ID)
					{
						pass = true;
					}
					break;

				case O2Tank:
					if (itemId == O2_TANK_ID)
					{
						pass = true;
					}
					break;

				default:
					fail("You did not manually add the value " +
							item.toString() +
							" to this list.");
			}

			if (!pass)
			{
				final String failMessage = "You messed up on the ID of " +
						item.toString() + "!";

				fail(failMessage);
			}
		}
	}

	@Test
	public void correctIdTranslation()
	{
		for (int id = 1; id < ItemEnum.values().length; ++id)
		{
			ItemEnum item = ItemEnum.translateId(id);
			boolean pass = false;

			switch (id)
			{
				case SAPPHIRE_ID:
					if (item.equals(ItemEnum.Sapphire))
					{
						pass = true;
					}
					break;

				case RUBY_ID:
					if (item.equals(ItemEnum.Ruby))
					{
						pass = true;
					}
					break;

				case GOLD_ID:
					if (item.equals(ItemEnum.Gold))
					{
						pass = true;
					}
					break;

				case DIAMOND_ID:
					if (item.equals(ItemEnum.Diamond))
					{
						pass = true;
					}
					break;

				case EMERALD_ID:
					if (item.equals(ItemEnum.Emerald))
					{
						pass = true;
					}
					break;

				case OIL_BARREL_ID:
					if (item.equals(ItemEnum.OilBarrel))
					{
						pass = true;
					}
					break;

				case O2_TANK_ID:
					if (item.equals(ItemEnum.O2Tank))
					{
						pass = true;
					}
					break;

				default:
					logger.warning(("Index might be out of range."));
					break;
			}

			if (!pass)
			{
				fail("The translation method messed up!");
			}
		}
	}
};
