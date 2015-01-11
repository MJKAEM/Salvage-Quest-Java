package jdivers;

import org.lwjgl.input.Mouse;

public class MouseFix
{
	private static int mouseY;

	public static void updateMouseY()
	{
		setMouseY(Global.height - Mouse.getY());
	}
	
	public static int getMouseY()
	{
		return mouseY;
	}

	public static void setMouseY(int mouseY)
	{
		MouseFix.mouseY = mouseY;
	}
};
