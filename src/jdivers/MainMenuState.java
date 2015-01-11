package jdivers;

import java.awt.Font;

import jdivers.mainmenu.AbstractMenu;
import jdivers.mainmenu.MainMenu;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState
{
	private AbstractMenu currentMenu;
	private TrueTypeFont font1;

	public MainMenuState(int state)
	{
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException
	{
		currentMenu = new MainMenu();

		Font font = new Font("Times New Roman", Font.PLAIN, 18);
		font1 = new TrueTypeFont(font, true);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException
	{
		g.setFont(font1);
		currentMenu.show(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException
	{
		currentMenu.update();
	}

	@Override
	public int getID()
	{
		return 0;
	}
};
