package computc;

import java.awt.Point;
import java.util.LinkedList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

import computc.states.MainGameState;
import computc.worlds.Room;

public class Game extends StateBasedGame
{
	public static boolean reset;
	
	public Game()
	{
		super(Game.TITLE + " " + Game.VERSION);
	}
	
	public void initStatesList(GameContainer arg0) throws SlickException
	{
        this.addState(new MainGameState());
	}
	
	public static void main(String[] args) throws SlickException
	{
		AppGameContainer container = new AppGameContainer(new Game());
		container.setDisplayMode(Room.WIDTH, Room.HEIGHT, false);
		container.setTargetFrameRate(60);
		container.start();
	}
	
	public static final String TITLE = "Game";
	public static final String VERSION = "v0.1.0";
}