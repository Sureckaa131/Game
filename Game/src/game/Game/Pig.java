/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 *
 * Player.
 */
public class Pig extends Walker {
    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance. 
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -1.112f,-0.026f, -0.905f,1.063f, 0.584f,1.059f, 1.107f,0.33f, 0.387f,-1.107f, -0.76f,-1.107f, -1.107f,-0.119f);

    //adds the image
    private static final BodyImage image = new BodyImage("data/pig.png", 2.25f);

    private int carrotCount; //variable 
    private int LiveCount;  
    private World world;

    public Pig(World world) {
        super(world, shape);
        this.world = world;
        addImage(image);
        carrotCount = 0; //initializing the carrotCount to 0
        LiveCount = 3; //initializing the LiveCount to 3
    }

    public void setCarrotCount(int cnt){ //sets the carrotCount
        carrotCount = cnt;
    }
    
    public void setLiveCount(int cnt){ //sets the liveCount
        LiveCount = cnt;
    }    
    
    
    public int getCarrotCount() { // gets the carrotCount 
        return carrotCount;
    }
    
    public int getLiveCount(){ //gets the liveCount
        return LiveCount;
    }
    
    public void incrementCarrotCount() { 
        carrotCount++; // increases the carrotCount
        System.out.println("Tasty!  Carrot count = " + carrotCount); //prints the statement with the carrotCount value
    }

    public void decrementLiveCount() {
        LiveCount--; //decreses the LiveCount
        System.out.println("Life lost!!! Lives remaining = " + LiveCount); //prints the statement with the LiveCount value 
        if (LiveCount <= 0){ // if the live count reaches 0 
          System.out.println("GAME OVER!"); //prints game over
            System.exit(0);
        }
    }

    public void incrementLiveCount() {
        LiveCount++; //increases the life count
        System.out.println("You've earned a life! Lives remaining = " + LiveCount); //prints the statement with the LiveCount value
                
    }
    
  
}

    

