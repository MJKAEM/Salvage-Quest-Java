package jdivers;

public class PlayerData
{
	public static final int MAX_HEALTH = 100;
	public static final int MAX_ARMOR = 200;
	
	private boolean unlockedFishing, unlocked;
	
	private int curHealth, curArmor;
	private int curMoney;

	public PlayerData()
	{
		this.curHealth = 100;
		this.curArmor = 0;
		this.curMoney = 0;
	}
	
	public PlayerData(int curHealth)
	{
		
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
};
