package jdivers;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ContentLoader
{
	public static final AngelCodeFont[] fonts = new AngelCodeFont[5];
	public static final Image[] backgroundImages = new Image[20];
	public static final Image[] itemImages = new Image[20];

	private static final String fontPath = "resources/fonts/";
	private static final String imagePath = "resources/images/";

	public static void loadAllContent()
	{
		loadBackgrounds();
		loadItemImages();
		loadFonts();
	}

	public static void loadFonts()
	{
		final String fontExtName = ".fnt";
		final String fontChartExtName = "_0.png";

		try
		{
			final String arialFontName = "ArialFont";
			final String timesFontName = "TimesFont";

			fonts[0] = new AngelCodeFont(
					fontPath + arialFontName + "24Outline" + fontExtName,
					fontPath + arialFontName + "24Outline" + fontChartExtName);
			fonts[1] = new AngelCodeFont(
					fontPath + arialFontName + "18" + fontExtName,
					fontPath + arialFontName + "18" + fontChartExtName);
			fonts[2] = new AngelCodeFont(
					fontPath + arialFontName + "36" + fontExtName,
					fontPath + arialFontName + "36" + fontChartExtName);
			fonts[3] = new AngelCodeFont(
					fontPath + timesFontName + "18" + fontExtName,
					fontPath + timesFontName + "18" + fontChartExtName);
		}
		catch (SlickException e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static void loadBackgrounds()
	{
		final String backgroundPath = imagePath + "backgrounds/";

		try
		{
			backgroundImages[0] = new Image(backgroundPath + "MainMenu.png");
			backgroundImages[1] = new Image(backgroundPath + "OptionMenu.png");
			backgroundImages[2] = new Image(backgroundPath + "StashMenu.png");
			backgroundImages[3] = new Image(backgroundPath + "SwimMenu.png");
			backgroundImages[4] = new Image(backgroundPath + "DiveMenu.png");
		}
		catch (SlickException e)
		{
			System.err.println(e.getMessage());
		}
	}

	public static void loadItemImages()
	{
		final String itemPath = imagePath + "items/";

		if (Global.width < 640 || Global.height < 480)
		{
			try
			{
				itemImages[0] = new Image(itemPath + "Sapphire.png");
				itemImages[1] = new Image(itemPath + "Ruby.png");
				itemImages[2] = new Image(itemPath + "Emerald.png");
				itemImages[3] = new Image(itemPath + "Diamond.png");
			}
			catch (SlickException e)
			{
				System.err.println(e.getMessage());
			}
		}
		else
		{
			try
			{
				itemImages[0] = new Image(itemPath + "BigSapphire.png");
				itemImages[1] = new Image(itemPath + "BigRuby.png");
				itemImages[2] = new Image(itemPath + "BigEmerald.png");
				itemImages[3] = new Image(itemPath + "BigDiamond.png");
			}
			catch (SlickException e)
			{
				System.err.println(e.getMessage());
			}
		}
	}
};
