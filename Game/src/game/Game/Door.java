package game.Game;

import city.cs.engine.*;

/**
 * Doors in a game. When the actor collides with a door, if
 * the current level is complete the game is advanced to the
 * next level. 
 */
public class Door extends StaticBody {   
    
    /**
     * Initialise a new door.
     * @param world The world.
     */
    private static final Shape shape = new PolygonShape( // used to make an approximate shape of the door
            -1.18f,-1.93f, -1.17f,1.88f, 1.2f,1.93f, 1.18f,-1.93f, -1.09f,-1.96f);
    
     private static final BodyImage image =
        new BodyImage("data/door.png", 4f); //load the image
            
    public Door(World world) {
        super(world, shape);
        addImage(image);
    }
}
