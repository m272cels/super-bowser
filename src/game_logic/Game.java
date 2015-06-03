package src.game_logic;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{
    public static final String gamename = "Super Wario: "
                                        + "The Quest to Defend the Castle";
    public static final int menu = 0;
    public static final int play = 1;
    public static final int backpack = 9;
    
    public Game(String gamename){
        super(gamename);
        this.addState(new Menu(menu));
        this.addState(new Play(play));
        this.addState(new Backpack(backpack));
    }
    public void initStatesList(GameContainer gc) throws SlickException{
        this.getState(menu).init(gc, this);
        this.getState(play).init(gc, this);
        this.getState(backpack).init(gc, this);
        this.enterState(menu);
    }
    public static void main(String[] args) {
        AppGameContainer appgc;
        try{
            
            appgc = new AppGameContainer(new Game(gamename));
            appgc.setDisplayMode(1000, 750, false);
            appgc.start();
            }catch(SlickException e){
                e.printStackTrace();
            }

    }
  


}
