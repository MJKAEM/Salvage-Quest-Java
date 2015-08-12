package jdivers;

import java.util.ArrayList;
import java.util.List;

import jdivers.items.ItemEnum;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class PlayerData
{
	public static final int MAX_HEALTH = 100;
	public static final int MAX_ARMOR = 200;
	/**
	 * 999,999,999
	 */
	public static final int MAX_MONEY = 999999999;
	public static final int MAX_INVENTORY_SPACE = 2;

	private boolean unlockedFishing, unlocked;
	private boolean ownStunStick, ownPistol, ownRifle, ownShotgun, ownRPG;

	private String name;
	private int curHealth, curArmor;
	private int curMoney;
	private ItemEnum onHand, itemSelected;
	private List<ItemEnum> inventory;

	public PlayerData(final String name)
	{
		this(name, 100, 0, 0, null, new ArrayList<ItemEnum>(2));
	}

	public PlayerData(final String name, final int curHealth,
			final int curArmor, final int curMoney, final ItemEnum onHand,
			final List<ItemEnum> inventory)
	{
		this.name = name;
		this.curHealth = curHealth;
		this.curArmor = curArmor;
		this.curMoney = curMoney;
		this.onHand = onHand;
		this.inventory = inventory;
	}

	public void showInventory(final Graphics g)
	{
		if (Global.isSizeRecommended())
		{

		}
		else
		{
			showSmallInventory(g);
		}
	}

	private void showSmallInventory(final Graphics g)
	{

		if (getOnHand() != null)
		{
			Image onHandImage = getOnHand().getImage();

			final float posX = Global.quarterWidth - (onHandImage.getWidth() / 2);
			final float posY = Global.height - 25;

			g.drawImage(onHandImage,
					posX,
					posY);

			if (getOnHand().equals(getItemSelected()))
			{
				g.drawRect(posX, posY, 25, 25);
			}
		}

		for (int i = 0; i < getInventory().size(); ++i)
		{
			ItemEnum itemEnum = getInventory().get(i);

			if (itemEnum != null)
			{
				Image itemImage = itemEnum.getImage();

				final float posX = Global.threeFourthWidth -
						(itemImage.getWidth() / 2) +
						(i * 25);
				final float posY = Global.halfHeight;

				g.drawImage(itemImage,
						posX,
						posY);
			}
		}
	}

	public void addMoney(final int money)
	{
		setCurMoney(getCurMoney() + money);

		if (getCurMoney() > MAX_MONEY)
		{
			setCurMoney(MAX_MONEY);
		}
	}

	public void healHealth(final int healPoints)
	{
		setCurHealth(getCurHealth() + healPoints);

		if (getCurHealth() > MAX_HEALTH)
		{
			setCurHealth(MAX_HEALTH);
		}
	}

	public void healArmor(final int healPoints)
	{
		setCurArmor(getCurArmor() + healPoints);

		if (getCurArmor() > MAX_ARMOR)
		{
			setCurArmor(MAX_ARMOR);
		}
	}

	public boolean putIntoHand(final int itemID)
	{
		ItemEnum item = ItemEnum.translateId(itemID);

		boolean added = putIntoHand(item);
		return added;
	}

	public boolean putIntoHand(final ItemEnum itemEnum)
	{
		if (getOnHand() == null)
		{
			setOnHand(itemEnum);
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean putIntoInventory(final int itemID)
	{
		ItemEnum item = ItemEnum.translateId(itemID);

		boolean added = putIntoInventory(item);
		return added;
	}

	public boolean putIntoInventory(final ItemEnum itemEnum)
	{
		if (isInventoryFull(itemEnum))
		{
			return false;
		}
		else
		{
			boolean added = getInventory().add(itemEnum);
			return added;
		}
	}

	/**
	 * Determines if the player's inventory is <strike>overburden</strike>
	 * unable to carry the item specified in the input.
	 * 
	 * @param itemEnum
	 *            The item that is to be checked if there is enough space
	 * @return
	 */
	public boolean isInventoryFull(final ItemEnum itemEnum)
	{
		int size = 0;

		for (ItemEnum temp : getInventory())
		{
			size += temp.getSpaceUsed();
		}

		return (size + itemEnum.getSpaceUsed() >= MAX_INVENTORY_SPACE);
	}

	public boolean onHandClicked()
	{
		boolean clicked = false;

		if (Global.isSizeRecommended())
		{

		}
		else
		{
			final float posX = Global.quarterWidth - (32 / 2);
			final float posY = Global.height - 25;
			
			final float halfWidth = 16;
			final float halfHeight = 16;

			if (Mouse.getX() > posX &&
					Mouse.getX() > posX + halfWidth)
			{
				if (MouseFix.getMouseY() > posY &&
						MouseFix.getMouseY() > posY + halfHeight)
				{
					// TODO
				}
			}

		}

		return clicked;
	}

	//
	// Getters and Setters
	//

	public boolean isUnlockedFishing()
	{
		return unlockedFishing;
	}

	public void setUnlockedFishing(final boolean unlockedFishing)
	{
		this.unlockedFishing = unlockedFishing;
	}

	public boolean isUnlocked()
	{
		return unlocked;
	}

	public void setUnlocked(final boolean unlocked)
	{
		this.unlocked = unlocked;
	}

	public int getCurHealth()
	{
		return curHealth;
	}

	public void setCurHealth(final int curHealth)
	{
		this.curHealth = curHealth;
	}

	public int getCurArmor()
	{
		return curArmor;
	}

	public void setCurArmor(final int curArmor)
	{
		this.curArmor = curArmor;
	}

	public int getCurMoney()
	{
		return curMoney;
	}

	public void setCurMoney(final int curMoney)
	{
		this.curMoney = curMoney;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public boolean isOwnStunStick()
	{
		return ownStunStick;
	}

	public void setOwnStunStick(final boolean ownStunStick)
	{
		this.ownStunStick = ownStunStick;
	}

	public boolean isOwnPistol()
	{
		return ownPistol;
	}

	public void setOwnPistol(final boolean ownPistol)
	{
		this.ownPistol = ownPistol;
	}

	public boolean isOwnRifle()
	{
		return ownRifle;
	}

	public void setOwnRifle(final boolean ownRifle)
	{
		this.ownRifle = ownRifle;
	}

	public boolean isOwnShotgun()
	{
		return ownShotgun;
	}

	public void setOwnShotgun(final boolean ownShotgun)
	{
		this.ownShotgun = ownShotgun;
	}

	public boolean isOwnRPG()
	{
		return ownRPG;
	}

	public void setOwnRPG(final boolean ownRPG)
	{
		this.ownRPG = ownRPG;
	}

	public ItemEnum getOnHand()
	{
		return this.onHand;
	}

	public void setOnHand(final ItemEnum onHand)
	{
		this.onHand = onHand;
	}

	public List<ItemEnum> getInventory()
	{
		return this.inventory;
	}

	public ItemEnum getItemSelected()
	{
		return this.itemSelected;
	}
};
