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

public class WorldFour extends WorldTemplate
{   
    public WorldFour(int state){
       super(state);
    }
    // make bowser at the beginning
    public void init(GameContainer gc, StateBasedGame sbg)throws SlickException
    {

       map = new TiledMap("res/WorldFourMap.tmx");
       objectLayer = map.getLayerIndex("Buildings");
       map.getTileId(0,0, objectLayer);

       mobs = new ArrayList<>();
    }
    
    public void update(GameContainer gc, StateBasedGame sbg, int delta) 
           throws SlickException
    {
       super.update(gc, sbg, delta);
       Game.prevState = this;
       //Bowser enters previous world
       if(bowser.getX()==0 && bowser.getY()==10)
       {
          sbg.enterState(3);
          WorldTemplate.bowser.setX(23);
          WorldTemplate.bowser.setY(1);
       }
       //bowser enters world 5
       if(bowser.getX()==24 && bowser.getY()==10)
       {
          sbg.enterState(5);
          WorldTemplate.bowser.setX(12);
          WorldTemplate.bowser.setY(18);
       }
    }    
     
    public int getID() { return 4; }
  
}
