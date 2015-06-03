package game_logic;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame{
    public static final String gamename = "Super Bowser: "
                                        + "The Quest to Defend the Castle";
    public static final int menu = 0;
    public static final int play = 1;
//
    public Game(String gamename){
        super(gamename);
        this.addState(new Menu(menu));
        this.addState(new Play(play));
    }
    public void initStatesList(GameContainer gc) throws SlickException{
        this.getState(menu).init(gc, this);
        this.getState(play).init(gc, this);
        this.enterState(menu);
    }
    public static void main(String[] args) {
        AppGameContainer appgc;
        try {
            appgc = new AppGameContainer(new Game(gamename));
            appgc.setDisplayMode(1002, 750, false);
            appgc.setTargetFrameRate(60);
            appgc.start();
        } catch(SlickException e) {
                e.printStackTrace();
        }
    }
}
