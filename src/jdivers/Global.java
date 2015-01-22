package jdivers;

import org.lwjgl.input.Mouse;

public class Global
{
	public static final String GAMENAME = "Divers 0.1A";
	public static final String FONT = "Times New Roman";

	public static final int menuStateValue = 0;
	public static final int playStateValue = 1;

	public static int width = 640;
	public static int height = 480;
	public static boolean fullScreen = false;
	public static boolean vSync = false;

	public static int quarterHeight = Global.height >> 2;
	public static int halfHeight = Global.height >> 1;
	public static int threeFourthHeight = Global.quarterHeight + Global.halfHeight;

	public static int quarterWidth = Global.width >> 2;
	public static int halfWidth = Global.width >> 1;
	public static int threeFourthWidth = Global.quarterWidth + Global.halfWidth;

	public static void updateGlobalVariables()
	{
		Global.quarterHeight = Global.height >> 2;
		Global.halfHeight = Global.height >> 1;
		Global.threeFourthHeight = Global.quarterHeight + Global.halfHeight;

		Global.quarterWidth = Global.width >> 2;
		Global.halfWidth = Global.width >> 1;
		Global.threeFourthWidth = Global.quarterWidth + Global.halfWidth;
	}
};
