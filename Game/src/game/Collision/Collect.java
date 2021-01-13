package game.Collision;

import game.Collision.collideable;
import city.cs.engine.*;
import game.Game.Pig;
import org.jbox2d.common.Vec2;

/**
 * Collision listener that allows the pig to collect things.
 */
public class Collect implements CollisionListener {
    private Pig pig; //declaring pig variable

    
    public Collect(Pig pig) {
        this.pig = pig;
    }

    //detecting collision between the two bodies
    @Override
    public void collide(CollisionEvent e) {
        //System.out.println("Collision!");
        if (e.getReportingBody() instanceof collideable) { 
            collideable c = (collideable) e.getReportingBody();
            c.collisionResponse(e.getOtherBody());
        }        
    
    }
    
}

