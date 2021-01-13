/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Gains;

import game.Collision.collideable;
import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import game.Game.GameLevel;
import game.Game.Pig;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * A heart - life.
 */
public class Heart extends DynamicBody implements collideable{
    
    private static final Shape shape = new PolygonShape( //used to create an approximate shape for the carrot 
            -0.019f,-0.729f, -0.891f,0.197f, -0.881f,0.698f, 0.851f,0.722f, 0.877f,0.18f, 0.049f,-0.703f);
    
    private Pig pig; //declaring the pig variable 
    private static SoundClip gainlife; //declaring variable for sound

//adds the image
    private static final BodyImage image =
        new BodyImage("data/heart.png", 1.5f); //used to load the heart image
 
    public Heart(GameLevel world) {
        super(world, shape);
        addImage(image);
        this.setGravityScale(0f); //makes the character stay in one place (does not drop)
        this.pig = world.getPlayer();
    }
    
     static {
        try {
            gainlife = new SoundClip ("data/gainlife.wav"); // used to load the soundclip 
        } catch (UnsupportedAudioFileException | IOException| LineUnavailableException e) { //take steps to recover from the error and try again or inform user nicely and suggest fixes
            System.out.println(e);
        }
    }

    @Override
    public void collisionResponse(Body b) {
        if (b == pig) { //if the body is pig 
            pig.incrementLiveCount(); //pig gains a life
            destroy(); //heart is destroyed
            gainlife.play(); //gainlife sound is played 
        }    
    }    
}
