package jdivers;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ContentLoader
{
	public static final AngelCodeFont[] fonts = new AngelCodeFont[5];
	public static final Image[] backgroundImages = new Image[20];

	public static void loadAllContent()
	{
		loadImages();
		loadFonts();
	}

	public static void loadFonts()
	{
		try
		{
			fonts[0] = new AngelCodeFont("resources/fonts/arialFont24Outline.fnt",
					"resources/fonts/arialFont24Outline_0.png");
		}
		catch (SlickException e)
		{
			e.printStackTrace();
		}
	}

	public static void loadImages()
	{
		try
		{
			backgroundImages[0] = new Image("resources/images/MainMenu.png");
		}
		catch (SlickException e)
		{
			e.printStackTrace();
		}
	}
};
