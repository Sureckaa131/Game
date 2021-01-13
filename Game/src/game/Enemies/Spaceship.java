/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Enemies;

import game.Collision.collideable;
import city.cs.engine.Body;
import city.cs.engine.BodyImage;
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
import java.util.Random;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
*
 * Enemy character - Spaceship.
 */
public class Spaceship extends Walker implements StepListener, collideable {
    
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
-0.51f,-0.996f, -2.121f,-0.246f, -0.439f,0.984f, 0.727f,0.873f, 2.203f,-0.246f, 0.439f,-1.043f);
    
    private Pig pig;
    private static SoundClip loselife;
    
    //add the image 
    private static final BodyImage image =
        new BodyImage("data/spaceship.png", 2.25f);
    
    private float dx = 1f; 
    private float dy = 1f;
    private int xPos;
    private int yPos;
    private Random random;
    
    int counter = 0;
     

    public Spaceship(GameLevel world) {
        super(world, shape);
        addImage(image);
        //this.setLinearVelocity(new Vec2(5f, 0f));  //moves the character to the left
        this.setGravityScale(0f);   //makes sure the character does not fall, stays where it spawns
        world.addStepListener(this); 
        random = new Random(); //generate a random position
        xPos=random.nextInt(20)-10; //random x position 
        yPos=random.nextInt(20)-10; //random y position
        this.pig = world.getPlayer();
    }
    
    static {
        try {
            loselife = new SoundClip ("data/loselife.wav"); //loads the sound effect 
        } catch (UnsupportedAudioFileException | IOException| LineUnavailableException e) { //take steps to recover from the error and try again or inform user nicely and suggest fixes
            System.out.println(e);
        }
    }
    
// make the character change direction when reaches end of screen
    @Override
    public void preStep(StepEvent e) {
        
        
        if (counter % 3000==0){ //sets the speed fo the spaceship 
            dx += random.nextFloat()*0000.1f;

        }
        
        this.setPosition(new Vec2( ((xPos += dx)*0.1f) , ((yPos += dy)*0.1f) )); //set the velocity 
        
        if (this.getPosition().x > 10 || this.getPosition().x < -10){ //to change direction when the player meets the coordinates
            dx*=-1;
        }
        if(this.getPosition().y > 9 || this.getPosition().y < -8){ //to change direction when the player meets the coordinates
            dy*=-1;
        }
        counter++;

    }

    @Override
    public void postStep(StepEvent e) {
        
    }

    @Override
    public void collisionResponse(Body b) {
        if (b == pig) { //if body is pig 
            pig.decrementLiveCount(); //pig loses a life
            destroy(); //spaceship is destroyed 
            loselife.play(); //loselife sound is played 
        }    
     }
   
    
}
