/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Collision;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.Enemies.Bomb;
import game.Game.Pig;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Collision listener that causes the pig to lose lives.
 */
public class bombdrop implements CollisionListener {
    
    private Pig pig; //declares pig variable 
    private SoundClip loselife; //declares soundclip variable 
            
    public bombdrop(Pig pig) {
        this.pig = pig;
        
    }
    @Override
    public void collide(CollisionEvent e) {
        
        if (e.getReportingBody() instanceof Bomb && e.getOtherBody() == pig) { //collision between pig and the bomb
            pig.decrementLiveCount(); //pig loses a life
             try {
                 loselife = new SoundClip ("data/loselife.wav"); //loads the sound effect 
                 loselife.play(); //loselife sound effect plays
        }  catch (UnsupportedAudioFileException | IOException| LineUnavailableException e2) { //take steps to recover from the error and try again or inform user nicely and suggest fixes
            System.out.println(e);
        }
             
        } else if (e.getOtherBody() == pig && pig.getLiveCount() == 1) { //if the number of lives equals to 1
            System.exit(0); //game ends
        }
        e.getReportingBody().destroy(); //bomb is destroyed 
    }
    
    
}
