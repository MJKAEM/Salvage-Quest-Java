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

	public static boolean oldMouseDown = false;
	public static boolean mouseDown = false;

	public static int quarterHeight = Global.height >> 2;
	public static int halfHeight = Global.height >> 1;
	public static int threeFourthHeight = (int) (Global.height * 0.75);

	public static int quarterWidth = Global.width >> 2;
	public static int halfWidth = Global.width >> 1;
	public static int threeFourthWidth = (int) (Global.width * 0.75);

	public static boolean mouseReleased()
	{
		return Global.oldMouseDown && !Global.mouseDown;
	}

	public static void updateMouseDown()
	{
		System.out.println("M1"+oldMouseDown);
		System.out.println("M2"+mouseDown);
		Global.oldMouseDown = Global.mouseDown;
		Global.mouseDown = Mouse.isButtonDown(0);
	}
};
