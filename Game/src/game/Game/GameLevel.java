package game.Game;

import game.Game.Game;
import city.cs.engine.*;
import java.io.IOException;
import static java.time.Clock.system;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {
    private Pig player; 
    public SoundClip backgroundmusic1; //declaring the sound variable 
    public SoundClip backgroundmusic2;
    public SoundClip backgroundmusic3;
    
    public Pig getPlayer() {
        return player;
    }

    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {
        player = new Pig(this);
        player.setPosition(new Vec2(startPosition())); //positions the pig 
        Door door = new Door(this);
        door.setPosition(doorPosition()); //positions the door
        door.addCollisionListener(new DoorListener(game));
        
        try {
        backgroundmusic1 = new SoundClip ("data/backgroundmusic.wav"); //loads the music
            } catch (UnsupportedAudioFileException | IOException| LineUnavailableException e) { //take steps to recover from the error and try again or inform user nicely and suggest fixes
        System.out.println(e);
    }
        try {
        backgroundmusic2 = new SoundClip ("data/backgroundmusic2.wav"); //loads the music 
            } catch (UnsupportedAudioFileException | IOException| LineUnavailableException e) { //take steps to recover from the error and try again or inform user nicely and suggest fixes
        System.out.println(e);
    }
        try {
        backgroundmusic3 = new SoundClip ("data/backgroundmusic3.wav"); //loads the music 
            } catch (UnsupportedAudioFileException | IOException| LineUnavailableException e) { //take steps to recover from the error and try again or inform user nicely and suggest fixes
        System.out.println(e);
    }
    }
    
    /** The initial position of the player. */
    public abstract Vec2 startPosition();
    
    /** The position of the exit door. */
    public abstract Vec2 doorPosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();
    
    public abstract SoundClip levelMusic();
}
    
