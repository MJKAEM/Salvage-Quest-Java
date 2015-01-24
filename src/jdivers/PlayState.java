package jdivers;

import jdivers.output.OutputTextbox;
import jdivers.playmenu.MainHubMenu;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PlayState extends BasicGameState
{
	public static final OutputTextbox outputTextbox = new OutputTextbox();
	
	private MainHubMenu mainHubMenu;
	
	private Menu currentMenu;
	
	public PlayState(int state)
	{
		
	}

	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException
	{
		
		mainHubMenu = new MainHubMenu();
		
		currentMenu = mainHubMenu;
		
		outputTextbox.init();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException
	{
		mainHubMenu.show(g);
		outputTextbox.show(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException
	{
		MouseFix.updateMouseY();
	}

	@Override
	public int getID()
	{
		return Global.playStateValue;
	}

}
