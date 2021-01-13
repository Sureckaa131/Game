package game.Game;

import game.Enemies.Spaceship;
import game.Collision.Collect;
import city.cs.engine.*;
import game.Gains.Carrots;
import game.Gains.Heart;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 * Level 2 of the game.
 */
public class Level3 extends GameLevel {

    private static final int NUM_CARROTS = 23; //number of carrots needed to finish the game 

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
        backgroundmusic3.loop(); //loop the music 
        
        System.out.println("Collect the carrots without touching the spaceship.");
        
        // make the ground
        Shape groundShape = new BoxShape(15, 0);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11f));
        
        
        // make some platforms
        Shape platformShape = new BoxShape(1.5f, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-14, -1f));
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(14, -1f));
        BodyImage cloud = new BodyImage("data/cloud.png", 1.5f);
        Body platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(-14, 8f));
        platform1.addImage(cloud); //adds image to the platform
        platform2.addImage(cloud);
        platform3.addImage(cloud);

        Spaceship ship = new Spaceship(this);//to represent a spaceship on screen
        ship.setPosition(new Vec2(9, -7)); //positions the spaceship
        ship.addCollisionListener(new Collect(getPlayer()));  //used to notify the object to call method 
        
        Heart heart = new Heart(this); //to represent a heart on screen
        heart.setPosition(new Vec2(-13, -5)); //positions the heart 
        heart.addCollisionListener(new Collect(getPlayer())); //used to notify the object to call method 
        
        
        for (int i = 0; i < 1; i++) { //to represent 1 carrot on screen
            Body carrot = new Carrots(this);
            carrot.setPosition(new Vec2(i * 1 - 14, 8f)); //set the position of the carrot
            carrot.addCollisionListener(new Collect(getPlayer())); //used to notify the object to call method 
        }
        
        for (int i = 0; i < 1; i++) { //to represent 1 carrot on screen
            Body carrot = new Carrots(this);
            carrot.setPosition(new Vec2(i * 1 - (-14), 1f)); //set the position of the carrot
            carrot.addCollisionListener(new Collect(getPlayer())); //used to notify the object to call method 
        }
        
        for (int i = 0; i < 1; i++) { //to represent 1 carrot on screen
            Body carrot = new Carrots(this);
            carrot.setPosition(new Vec2(i * 1 - 14, 10f)); //set the position of the carrot 
            carrot.addCollisionListener(new Collect(getPlayer())); //used to notify the object to call method 
        }
    }

    @Override
    public Vec2 startPosition() { //set the position of the player
        return new Vec2(10, -9.6f);
    }

    @Override
    public Vec2 doorPosition() { //set the position of the door
        return new Vec2(-13, -8f);
    }

    @Override
    public boolean isCompleted() { //checks if the level is completed by checking the number of carrots collected
        return getPlayer().getCarrotCount() == NUM_CARROTS;
    }
    
    //for the background music 
    @Override
    public SoundClip levelMusic(){
        
        return backgroundmusic3;
    }

}
