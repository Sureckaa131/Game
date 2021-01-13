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
 * Enemy character - Angrybird.
 */
public class Angrybird extends Walker implements StepListener, collideable {
    
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -1.572f,-0.048f, -1.017f,1.017f, 0.84f,1.028f, 1.572f,-0.382f, 1.173f,-1.087f, -1.346f,-1.012f, -1.55f,-0.264f);
    
        private Pig pig; //declaring pig variable
        private GameLevel GL; // declaring gamelevel variable

    //add the image 
    private static final BodyImage image =
        new BodyImage("data/angrybird.png", 2.25f); //used to load the image, float is the size of the image on screen 
     

    public Angrybird(GameLevel world) {
        super(world, shape);
        addImage(image);
        this.setLinearVelocity(new Vec2(5f, 0f));  //moves the character to the left
        this.setGravityScale(0f);   //makes sure the character does not fall, stays where it spawns
        world.addStepListener(this);    
        this.pig = world.getPlayer(); // gets the player
    }
    
   
// make the character change direction when reaches end of screen
    @Override
    public void preStep(StepEvent e) {
        if (this.getPosition().x > 9){        // gets the position of the angrybird, if it is less than 9
            this.setLinearVelocity(new Vec2(-5f, 0f)); //makes the character move to the left
        }   
        if (this.getPosition().x < -9){       // gets the position of the angrybird, if it is less than - 9
            this.setLinearVelocity(new Vec2(5f, 0f));  //makes the character move to the right 
        }
    }

    @Override
    public void postStep(StepEvent e) {
        
    }
    
    // collision between the player and the angrybird
    @Override
    public void collisionResponse(Body b) {
        if (b == pig) { //if the body is pig
            destroy();  // destroys the bird
           System.out.println("GAME OVER!"); //prints game over
           System.exit(0); //exits game
        }
    }
   
    
            
}  

