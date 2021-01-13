/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Enemies;

import game.Collision.collideable;
import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.Walker;
import city.cs.engine.World;
import game.Game.GameLevel;
import game.Game.Pig;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
*
 * Enemy character - Jellyfish.
 */
public class Jellyfish extends Walker implements StepListener, collideable {

    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
-0.819f,0.264f, -0.526f,0.995f, 0.465f,1.017f, 0.844f,0.174f, 0.477f,-0.946f, -0.511f,-0.977f, -0.795f,0.15f);
    
    private Pig pig; //declaring the pig variable
    private static SoundClip loselife; //declaring the soundclip variable 
    
    //add the image 
    private static final BodyImage image =
        new BodyImage("data/jellyfish.png", 2.25f); //get image
     
    static {
        try {
            loselife = new SoundClip ("data/loselife.wav"); //loads the sound effect 
        } catch (UnsupportedAudioFileException | IOException| LineUnavailableException e) { //take steps to recover from the error and try again or inform user nicely and suggest fixes
            System.out.println(e);
        }
    }

    public Jellyfish(GameLevel world) {
        super(world, shape);
        addImage(image);
        this.setLinearVelocity(new Vec2(5f, 0f));  //moves the character to the left
        this.setGravityScale(0f);   //makes the character stay in one place (does not drop)
        world.addStepListener(this);   
        this.pig = world.getPlayer();
    }
    
   
// make the character change direction when reaches end of screen
    @Override
    public void preStep(StepEvent e) {
        if (this.getPosition().x > 9){        // gets the position of the jellyfish, if it is less than 9
            this.setLinearVelocity(new Vec2(-5f, 0f)); //makes the character move to the left
        }   
        if (this.getPosition().x < -9){       // gets the position of the jellyfish, if it is less than - 9
            this.setLinearVelocity(new Vec2(5f, 0f));  //makes the character move to the right 
        }
    }

    @Override
    public void postStep(StepEvent e) {
        
    }

    @Override
    public void collisionResponse(Body b) {
        if (b == pig) { //if body is pig 
            pig.decrementLiveCount(); //pig loses a life
            destroy(); //jellyfish is destroyed
            loselife.play(); //loselife sound effect plays 
          }    
    }
    
    
            
}  
