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
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.Walker;
import city.cs.engine.World;
import game.Game.GameLevel;
import game.Game.Pig;
import org.jbox2d.common.Vec2;

/**
*
 * Enemy character - Shark.
 */
public class Shark extends Walker implements StepListener, collideable {
    
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -3.42f,-0.17f, -1.83f,1.56f, 0.84f,1.52f, 3.44f,-0.71f, -3.03f,-0.72f);
    
    private Pig pig;//declares pig variable 
    private GameLevel GL; // declares gamelevel variable 
    
    //add the image 
    private static final BodyImage image =
        new BodyImage("data/shark.png", 4f);
     

    public Shark(GameLevel world) {
        super(world, shape);
        addImage(image);
        this.setLinearVelocity(new Vec2(5f, 0f));  //moves the character to the left
        this.setGravityScale(0f);  //makes sure the character does not fall, stays where it spawns
        world.addStepListener(this);   
        this.pig = world.getPlayer();
    }
    
   
// make the character change direction when reaches end of screen
    @Override
    public void preStep(StepEvent e) {
        if (this.getPosition().x > 9){        // gets the position of the shark, if it is less than 9
            this.setLinearVelocity(new Vec2(-5f, 0f)); //makes the character move to the left
        }   
        if (this.getPosition().x < -9){       // gets the position of the shark, if it is less than - 9
            this.setLinearVelocity(new Vec2(5f, 0f));  //makes the character move to the right 
        }
    }

    @Override
    public void postStep(StepEvent e) {
        
    }

    @Override
    public void collisionResponse(Body b) {
            if (b == pig) { //if body is pig 
            destroy(); //destroys shark
            System.out.println("GAME OVER!"); //prints game over
            System.exit(0); //exits game   
       }    
    
    }
    
    
            
}  

