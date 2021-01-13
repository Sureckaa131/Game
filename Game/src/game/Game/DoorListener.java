package game.Game;

import game.Game.Game;
import city.cs.engine.*;

/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level. 
 */
public class DoorListener implements CollisionListener {
    private Game game;
    
    public DoorListener(Game game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        Pig player = game.getPlayer();
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()) { //if the level is completed 
            System.out.println("Going to next level..."); 
            game.goNextLevel(); //moves onto next level
        }
    }
}
