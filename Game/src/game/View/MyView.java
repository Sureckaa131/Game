package game.View;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;
import game.Game.Pig;
import java.awt.Color;
import java.awt.Font;

/**
 * extended view.
 */
public class MyView extends UserView {
    Pig pig;
    
    private Image background; //declares image variable 
    
    public void setPlayer(Pig player) {
       pig = player;
        
    }
    
    
    public MyView(World world, Pig pig, int width, int height) {
        super(world, width, height);
        this.pig = pig;
        this.background = new ImageIcon("data/background.png").getImage(); //set the background for level 1
    }
    
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        Font font = new Font("Arial", Font.BOLD, 15); //font of the writing
        
        g.setFont(font);
        g.setColor(Color.white); //color of the writing
        g.drawString("Score: " + pig.getCarrotCount(), 520,20);  //prints the score on screen
        g.drawString("Health:" + pig.getLiveCount(), 20, 20);    //prints the lives on screen
    }
    
    public void setBackground2(World world, Pig pig, int width, int height ){
        this.background = new ImageIcon("data/background2.png").getImage(); //set background for level 2
    }   

    public void setBackground3(World world, Pig pig, int width, int height ){
        this.background = new ImageIcon("data/background3.png").getImage(); //set backfround for level 3
    }   

}
