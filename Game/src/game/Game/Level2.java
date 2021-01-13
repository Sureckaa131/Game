package game.Game;

import game.Enemies.Shark;
import game.Enemies.Jellyfish;
import game.Collision.Collect;
import city.cs.engine.*;
import game.Gains.Carrots;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 * Level 2 of the game.
 */
public class Level2 extends GameLevel {

    private static final int NUM_CARROTS = 20; //number of carrots the pig needs to go to level 3 

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
        backgroundmusic2.loop(); //loop the music 

        System.out.println("Collect the carrots without touching the jellyfish. Touch the shark and it is game over.");
        
        // make the ground
        Shape groundShape = new BoxShape(15, 0);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -12f));
        
        
        
        Shark fish = new Shark(this); //to represent one shark on screen 
        fish.setPosition(new Vec2((-9), -10)); //positions the shark
        fish.addCollisionListener(new Collect(getPlayer()));  //used to notify the object to call method 
        
        // make some platforms
        Shape platformShape = new BoxShape(2.5f, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(7, 6f));
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(-8.5f, 0f));
        Body platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(0, -6f));
        BodyImage seaweed = new BodyImage("data/seaweed.png", 1.5f);
        platform1.addImage(seaweed); //adds image to the platform
        platform2.addImage(seaweed);
        platform3.addImage(seaweed);
        
        for (int i = 0; i < 1; i++) { //to represent one jellyfish on screen
            Body jelly = new Jellyfish(this);
            jelly.setPosition(new Vec2(i * 2 - (-9), -2)); //sets the position of the jellyfish
            jelly.addCollisionListener(new Collect(getPlayer())); //used to notify the object to call method 
        }
        
        for (int i = 0; i < 1; i++) { //to represent one jellyfish on screen
            Body jelly = new Jellyfish(this);
            jelly.setPosition(new Vec2(i * 2 - 13, 4)); //set the position of the jellyfish
            jelly.addCollisionListener(new Collect(getPlayer())); //used to notify the object to call method 
        }
      
        for (int i = 0; i < 3; i++) { //to represent 3 carrots on screen
            Body carrot = new Carrots(this);
            carrot.setPosition(new Vec2(i * 2 - 10.45f, 2)); //set the position of the carrot 
            carrot.addCollisionListener(new Collect(getPlayer())); //used to notify the object to call method 
        }
        
        for (int i = 0; i < 3; i++) { //to represent 3 carrots on screen
            Body carrot = new Carrots(this);
            carrot.setPosition(new Vec2(i * 2 - 2, 2)); //set the position of the carrot 
            carrot.addCollisionListener(new Collect(getPlayer())); //used to notify the object to call method 
        }
        for (int i = 0; i < 3; i++) { //to represent 3 carrots on screen
            Body carrot = new Carrots(this);
            carrot.setPosition(new Vec2(i * 2 - (-5f), 10)); //set the position of the carrot 
            carrot.addCollisionListener(new Collect(getPlayer())); //used to notify the object to call method 
        }
    }

    @Override
    public Vec2 startPosition() { //set the position of the player
        return new Vec2(12, 10);
    }

    @Override
    public Vec2 doorPosition() { //set the position of the door
        return new Vec2(-13f, 9f);
    }

    @Override
    public boolean isCompleted() {  //checks if the level is completed by checking the number of carrots collected
        return getPlayer().getCarrotCount() == NUM_CARROTS;
    }
        
    //for the background music 
    @Override
    public SoundClip levelMusic(){
        
        return backgroundmusic2;
    }

}
