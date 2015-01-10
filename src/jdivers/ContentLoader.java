package jdivers;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ContentLoader
{
	public static Image[] backgroundImages = new Image[20];

	public static void loadAllContent()
	{
		try
		{
			backgroundImages[0] = new Image("resources/MainMenu.png");
		}
		catch (SlickException e)
		{
			e.printStackTrace();
		}
	}
};
