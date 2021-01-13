package game.Game;

import game.Enemies.Bomb;
import game.Enemies.Angrybird;
import game.Collision.bombdrop;
import game.Collision.Collect;
import city.cs.engine.*;
import game.Gains.Carrots;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 * Level 1 of the game.
 */
public class Level1 extends GameLevel implements ActionListener{

    private static final int NUM_CARROTS = 11; //number of carrots pig needs to collect to move onto level 2 
    private Timer timer; //declares timer variable 
    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
        
        System.out.println("Collect the carrots without touching the bomb. Touch the bird and it is game over.");
        
        backgroundmusic1.loop(); //loop the music 
        
        //sets timer for the bombs to spawn 
        timer = new Timer(5000, this);
        timer.setInitialDelay(100); 
        timer.start();
        
        // make the ground
        Shape groundShape = new BoxShape(15, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -12));
        
//     make the platforms  

        Shape boxShape = new BoxShape(4, 0.5f);  //creates a box shape
        Body platform1 = new StaticBody(this, boxShape);  //box is static 
        platform1.setPosition(new Vec2(8, 2.5f));  //position of the platforms
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(-8, -3f));
        

        Angrybird bird = new Angrybird(this);
        bird.setPosition(new Vec2(9, 10)); //positions the bird
        bird.addCollisionListener(new Collect(getPlayer()));  //used to notify the object to call method 
        
        for (int i = 0; i < 11; i++) { // to present 11 carrots on screen 
            Body carrot = new Carrots(this);
            carrot.setPosition(new Vec2(i*2-9, 5)); // position the carrots on the screen 
            carrot.addCollisionListener(new Collect(getPlayer())); //used to notify the object to call method 
            
        }
                
        
    }

    @Override 
    public Vec2 startPosition() {  //sets the position of the player
        return new Vec2(10, -10);
    }

    @Override
    public Vec2 doorPosition() {  //sets the position of the door
        return new Vec2(-13f, -9.6f);
    }

    @Override
    public boolean isCompleted() { //checks if the level is completed by checking the number of carrots collected
        return getPlayer().getCarrotCount() == NUM_CARROTS;
    }
    
    //for the background music 
    @Override
    public SoundClip levelMusic(){
        
        return backgroundmusic1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 3; i++) { // to present 3 bombs on screen 
             Body bomb = new Bomb(this);
            bomb.setPosition(new Vec2(i*14-14f, 7)); // position the bombs on the screen 
            bomb.addCollisionListener(new bombdrop(getPlayer())); //used to notify the object to call method 
        }   
}
}
