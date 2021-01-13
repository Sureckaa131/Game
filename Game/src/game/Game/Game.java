package game.Game;

import game.Game.Level3;
import game.Game.Level2;
import game.Game.Level1;
import city.cs.engine.*;
import game.Control.ControlPanel;
import game.Control.Controller;
import game.Control.GiveFocus;
import game.View.MyView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import org.jbox2d.common.Vec2;

/**
 * The computer game.
 */
public class Game {
    
    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;
    
    private int level;
    
    private Controller controller;

    /** Initialise a new Game. */
    public Game() {

         // make the world
        level = 1;
        world = new Level1();
        world.populate(this);

       view = new MyView(world, world.getPlayer(), 600, 500);
      //  view.setBackground(world.getBackgroundColor());
        
        // make a view
        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("Event handling");
        
        Container buttons = new ControlPanel(this);
        frame.add(buttons, BorderLayout.WEST);

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));
        
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);
        
       // JFrame debugView = new DebugViewer(world, 600, 500);
        
        // start!
        world.start();
    }

     /** The player in the current level. */
    public Pig getPlayer() {
        return world.getPlayer();
    }
    
    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }
    
    /** Advance to the next level of the game. */
    
    public void goNextLevel() {
        world.stop();
        world.levelMusic().stop();
        Pig oldpig = world.getPlayer();
        if (level == 3) {
            System.out.println("YOU WON"); //prints you won
            System.exit(0);
            
        } else if (level == 1) {
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);  
            //set the background for the new level
            view.setBackground2(world, world.getPlayer(), 600, 500);
            //get the score from level one 
            view.setPlayer(world.getPlayer());
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            //get the score and lives of the old pig from previous level
            world.getPlayer().setCarrotCount(oldpig.getCarrotCount());
            world.getPlayer().setLiveCount(oldpig.getLiveCount());
            // show the new world in the view
            view.setWorld(world);
           // JFrame debugView = new DebugViewer(world, 600, 500);


            world.start();
        } else if (level == 2){
             level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            //set a new background
            view.setBackground3(world, world.getPlayer(), 600, 500);
            view.setPlayer(world.getPlayer());
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            //get the score and lives of the old pig from previous level
            world.getPlayer().setCarrotCount(oldpig.getCarrotCount());
            world.getPlayer().setLiveCount(oldpig.getLiveCount());
            // show the new world in the view
            view.setWorld(world);
           // JFrame debugView = new DebugViewer(world, 600, 500);
       
            world.start();
        } 
        
    }

    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }
    
    public void pause(){ //pause the game
        world.stop();
    }

    public void resume(){ //continue the game after being paused
        world.start();
    }
    
    public void restartLevel(){ //restart the level 
        world.stop();
        world.levelMusic().stop();
        if(level == 1){
            world = new Level1(); //create new level 
        }else if (level == 2) {
            world = new Level2();
        }else if (level == 3){
            world = new Level3();
            
        }
        world.populate(this);
        view.setPlayer(world.getPlayer());
        controller.setBody(world.getPlayer());
        view.setWorld(world);
        world.start();
    }



    
    }
    


