package game_logic;

import java.util.ArrayList;

import javax.management.timer.Timer;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class WorldTwo extends WorldTemplate
{   
    public WorldTwo(int state){
       super(state);
    }
    // make bowser at the beginning
    public void init(GameContainer gc, StateBasedGame sbg)throws SlickException
    {
       //tiled map with 3 layers: background, flowers, and buildings
       map = new TiledMap("res/WorldTwoMap.tmx");
       objectLayer = map.getLayerIndex("Buildings");
       map.getTileId(0,0, objectLayer);
    }
    
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) 
           throws SlickException
    {
       map.render(0,0);
       super.render(gc, sbg, g);

       //bowser re-enters previous world
       if(bowser.getX()==0 && bowser.getY()==10)
       {
          sbg.enterState(1);
          WorldTemplate.bowser.setX(23);
          WorldTemplate.bowser.setY(11);
       }
       //bowser enters new world.
       if(bowser.getX()==24 && bowser.getY()==3)
       {
          sbg.enterState(3);
          WorldTemplate.bowser.setX(1);
          WorldTemplate.bowser.setY(3);
       }   
    }    
     
    public int getID() { return 2; }
  
}