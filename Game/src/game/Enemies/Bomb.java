/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Enemies;

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
 * Enemy character - Bomb.
 */


    public class Bomb extends DynamicBody {
            private static final Shape shape = new PolygonShape( // used to make an approximate shape of the bomb
                -1.05f,-0.207f, -0.726f,0.942f, 0.924f,0.975f, 0.672f,-0.327f, 0.189f,-0.969f, -0.657f,-0.924f, -1.05f,-0.234f);
            
    private Pig pig; //declaring pig variable 
    private static SoundClip loselife; //declaring Soundclip variable
        
    //add the image
    private static final BodyImage image = //used to load image 
        new BodyImage("data/bomb.png", 2.25f);

    static {
        try {
            loselife = new SoundClip ("data/loselife.wav"); // used to load the soundclip 
        } catch (UnsupportedAudioFileException | IOException| LineUnavailableException e) { //take steps to recover from the error and try again or inform user nicely and suggest fixes
            System.out.println(e);
        }
    }
    
    public Bomb(GameLevel world) { 
        super(world, shape);
        addImage(image);
        this.pig = world.getPlayer();
        
    }

}
   

    

