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
		final String fontPath = "resources/fonts/";
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

	public static void loadImages()
	{
		final String fontPath = "resources/images/";

		try
		{
			backgroundImages[0] = new Image(fontPath + "MainMenu.png");
			backgroundImages[1] = new Image(fontPath + "OptionMenu.png");
			backgroundImages[2] = new Image(fontPath + "StashMenu.png");
		}
		catch (SlickException e)
		{
			System.err.println(e.getMessage());
		}
	}
};
