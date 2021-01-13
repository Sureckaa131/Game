/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Collision;

import city.cs.engine.Body;

/**
 *
 * Interface for the collision between the player and other objects.
 */

public interface collideable {
    
    public void collisionResponse(Body b);
        
}
