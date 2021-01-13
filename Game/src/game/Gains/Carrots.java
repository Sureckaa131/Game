package game.Gains;

import game.Collision.collideable;
import city.cs.engine.*;
import game.Game.GameLevel;
import game.Game.Pig;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 *
 * @author sureckaa
 */


/**
 * A carrot - points.
 */
// That means there is a single shape and image for all instances of the class.

public class Carrots extends DynamicBody implements collideable {
    
    private static SoundClip collect; //declaring variable for sound
    private Pig pig; //declaring pig variable 
    
    private static final Shape shape = new PolygonShape( //used to create an approximate shape for the carrot 
            -0.684f,0.474f, 0.677f,0.476f, 0.651f,-0.478f, -0.653f,-0.476f, -0.687f,0.421f);

//adds the image
    private static final BodyImage image =
        new BodyImage("data/carrots.png", 2.25f); //used to load the carrot image
    
    static {
        try {
            collect = new SoundClip ("data/collect.wav"); // used to load the sound effect 
        } catch (UnsupportedAudioFileException | IOException| LineUnavailableException e) { //take steps to recover from the error and try again or inform user nicely and suggest fixes
            System.out.println(e);
        }
    }
    
    
    
    public Carrots(GameLevel world) {
        super(world, shape);
        addImage(image);
        this.pig = world.getPlayer();
        SolidFixture shapeFixture = new SolidFixture(this, shape, 10000);//set the density high so it does not move when other objects hit it 
      
    }

    //collision between the player and the carrots
    @Override
    public void collisionResponse(Body b) {
       if (b == pig) { //if the body is pig 
           pig.incrementCarrotCount(); //score increases
            destroy(); //carrot is destroyed
            collect.play(); //plays the sound when pig collides with carrot
        }
    }
}
    
    
   