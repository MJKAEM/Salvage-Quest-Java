package jdivers;

import jdivers.output.OutputTextbox;
import jdivers.playmenu.MainHubMenu;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PlayState extends BasicGameState
{
	private AngelCodeFont textboxFont, outputTextFont;
	
	public static final OutputTextbox outputTextbox = new OutputTextbox();
	
	private MainHubMenu mainHubMenu;

	private AbstractMenu currentMenu;

	public PlayState(int state)
	{

	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException
	{

		mainHubMenu = new MainHubMenu();
		
		currentMenu = mainHubMenu;

		textboxFont = ContentLoader.fonts[0];
		outputTextFont = ContentLoader.fonts[3];
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException
	{
		g.setFont(textboxFont);
		currentMenu.show(g);
		
		g.setFont(outputTextFont);
		outputTextbox.show(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException
	{
		MouseFix.updateMouseY();

		currentMenu.update();
	}

	@Override
	public void mouseReleased(int button, int x, int y)
	{
		switch (button)
		{
			case 0:
				currentMenu.mouseReleased();
				break;
		}
	}

	@Override
	public int getID()
	{
		return Global.playStateValue;
	}

}
