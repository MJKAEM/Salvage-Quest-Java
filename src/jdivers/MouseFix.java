package jdivers;

import org.lwjgl.input.Mouse;

public class MouseFix
{
	private static int mouseY;

	/**
	 * Updates the mouse y-axis position to be more consistent with the graphics
	 * display.
	 */
	public static void updateMouseY()
	{
		setMouseY(Global.height - Mouse.getY());
	}

	/**
	 * Obtains the y-axis position of the mouse, with reversed positions. This
	 * is more consistent with the y-axis placements of other graphical objects.
	 * 
	 * @return the y-axis position of the mouse
	 */
	public static int getMouseY()
	{
		return mouseY;
	}

	public static void setMouseY(int mouseY)
	{
		MouseFix.mouseY = mouseY;
	}
};
