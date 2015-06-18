package jdivers;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import jdivers.items.ItemEnum;

import org.junit.Test;

public class PlayerDataTest
{
	public static final String DEFAULT_USER_NAME = "Anonymous";

	@Test
	public void isInventoryFullO2TankTest()
	{
		List<ItemEnum> inventory = new ArrayList<>();

		PlayerData pd = new PlayerData(DEFAULT_USER_NAME,
				100, 100, 100, null, inventory);

		boolean added = pd.isInventoryFull(ItemEnum.O2Tank);

		assertTrue(
				"The player's inventory should not be able to add the O2 Tank!",
				added);
	}

	@Test
	public void isInventoryFullSapphireTest()
	{
		List<ItemEnum> inventory = new ArrayList<>();

		PlayerData pd = new PlayerData(DEFAULT_USER_NAME,
				100, 100, 100, null, inventory);

		boolean added = pd.isInventoryFull(ItemEnum.Sapphire);

		assertFalse(
				"The player's inventory should be able to add the sapphire!",
				added);
	}

	@Test
	public void putIntoInventoryO2TankTest()
	{
		List<ItemEnum> inventory = new ArrayList<>();

		PlayerData pd = new PlayerData(DEFAULT_USER_NAME,
				100, 100, 100, null, inventory);

		boolean added = pd.putIntoInventory(ItemEnum.O2Tank);

		assertFalse(
				"The player's inventory should not be able to add the O2 Tank!",
				added);
	}

	@Test
	public void putIntoInventorySapphireTest()
	{
		List<ItemEnum> inventory = new ArrayList<>();

		PlayerData pd = new PlayerData(DEFAULT_USER_NAME,
				100, 100, 100, null, inventory);

		boolean added = pd.putIntoInventory(ItemEnum.Sapphire);

		assertTrue(
				"The player's inventory should be able to add the sapphire!",
				added);
	}

	@Test
	public void putIntoHandSapphireTest()
	{
		List<ItemEnum> inventory = new ArrayList<>();

		PlayerData pd = new PlayerData(DEFAULT_USER_NAME,
				100, 100, 100, null, inventory);

		boolean added = pd.putIntoHand(ItemEnum.Sapphire);

		assertTrue(
				"The player's hand should be able to add the sapphire!",
				added);
	}

	@Test
	public void putIntoHandTwoSapphireTest()
	{
		List<ItemEnum> inventory = new ArrayList<>();

		PlayerData pd = new PlayerData(DEFAULT_USER_NAME,
				100, 100, 100, null, inventory);

		pd.putIntoHand(ItemEnum.Sapphire);
		boolean added = pd.putIntoHand(ItemEnum.Sapphire);

		assertFalse(
				"The player's hand should not be able to add the sapphire!",
				added);
	}
}
