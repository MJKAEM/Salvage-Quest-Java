package jdivers;

import org.newdawn.slick.Color;

public final class Global
{
	// List of error exit code constants.
	//
	public static final int NULL_POINTER_EXCEPTION_CODE = 3;
	public static final int ILLEGAL_FORMAT_EXCEPTION_CODE = 43;

	public static final String GAMENAME = "Divers 0.1A";

	public static final int MENU_STATE_ID = 0;
	public static final int PLAY_STATE_ID = 1;

	public static Color mouseOnColor = new Color(128, 128, 255, 200);
	public static Color mouseOffColor = new Color(128, 128, 255, 100);

	public static final int MIN_WIDTH = 320;
	public static final int MIN_HEIGHT = 240;

	public static final int REC_WIDTH = 640;
	public static final int REC_HEIGHT = 480;

	public static int width = 320;
	public static int height = 240;
	public static boolean fullScreen = false;
	public static boolean vSync = false;

	public static int quarterHeight = Global.height / 4;
	public static int halfHeight = Global.height / 2;
	public static int threeFourthHeight = Global.quarterHeight + Global.halfHeight;

	public static int quarterWidth = Global.width / 4;
	public static int halfWidth = Global.width / 2;
	public static int threeFourthWidth = Global.quarterWidth + Global.halfWidth;

	public static void updateGlobalVariables()
	{
		Global.quarterHeight = Global.height / 4;
		Global.halfHeight = Global.height / 2;
		Global.threeFourthHeight = Global.quarterHeight + Global.halfHeight;

		Global.quarterWidth = Global.width / 4;
		Global.halfWidth = Global.width / 2;
		Global.threeFourthWidth = Global.quarterWidth + Global.halfWidth;
	}
	
	public static boolean isSizeRecommended()
	{
		boolean goodWidth = Global.width >= Global.REC_WIDTH;
		boolean goodHeight = Global.height >= Global.REC_HEIGHT;
		
		return (goodWidth && goodHeight);
	}
};
