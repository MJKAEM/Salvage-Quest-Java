package jdivers;

public class PlayerData
{
	public static final int MAX_HEALTH = 100;
	public static final int MAX_ARMOR = 200;
	public static final int MAX_MONEY = 999_999_999;

	private boolean unlockedFishing, unlocked;
	private boolean ownStunStick, ownPistol, ownRifle, ownShotgun, ownRPG;

	private String name;
	private int curHealth, curArmor;
	private int curMoney;

	public PlayerData(final String name)
	{
		this(name, 100, 0, 0);
	}

	public PlayerData(final String name, final int curHealth,
			final int curArmor, final int curMoney)
	{
		this.name = name;
		this.curHealth = curHealth;
		this.curArmor = curArmor;
		this.curMoney = curMoney;
	}

	public void addMoney(int money)
	{
		setCurMoney(getCurMoney() + money);

		if (getCurMoney() > MAX_MONEY)
		{
			setCurMoney(MAX_MONEY);
		}
	}

	public void healHealth(int healPoints)
	{
		setCurHealth(getCurHealth() + healPoints);

		if (getCurHealth() > MAX_HEALTH)
		{
			setCurHealth(MAX_HEALTH);
		}
	}

	public void healArmor(int healPoints)
	{
		setCurArmor(getCurArmor() + healPoints);

		if (getCurArmor() > MAX_ARMOR)
		{
			setCurArmor(MAX_ARMOR);
		}
	}

	//
	// Getters and Setters
	//

	public boolean isUnlockedFishing()
	{
		return unlockedFishing;
	}

	public void setUnlockedFishing(boolean unlockedFishing)
	{
		this.unlockedFishing = unlockedFishing;
	}

	public boolean isUnlocked()
	{
		return unlocked;
	}

	public void setUnlocked(boolean unlocked)
	{
		this.unlocked = unlocked;
	}

	public int getCurHealth()
	{
		return curHealth;
	}

	public void setCurHealth(int curHealth)
	{
		this.curHealth = curHealth;
	}

	public int getCurArmor()
	{
		return curArmor;
	}

	public void setCurArmor(int curArmor)
	{
		this.curArmor = curArmor;
	}

	public int getCurMoney()
	{
		return curMoney;
	}

	public void setCurMoney(int curMoney)
	{
		this.curMoney = curMoney;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isOwnStunStick()
	{
		return ownStunStick;
	}

	public void setOwnStunStick(boolean ownStunStick)
	{
		this.ownStunStick = ownStunStick;
	}

	public boolean isOwnPistol()
	{
		return ownPistol;
	}

	public void setOwnPistol(boolean ownPistol)
	{
		this.ownPistol = ownPistol;
	}

	public boolean isOwnRifle()
	{
		return ownRifle;
	}

	public void setOwnRifle(boolean ownRifle)
	{
		this.ownRifle = ownRifle;
	}

	public boolean isOwnShotgun()
	{
		return ownShotgun;
	}

	public void setOwnShotgun(boolean ownShotgun)
	{
		this.ownShotgun = ownShotgun;
	}

	public boolean isOwnRPG()
	{
		return ownRPG;
	}

	public void setOwnRPG(boolean ownRPG)
	{
		this.ownRPG = ownRPG;
	}
};
