/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Action listener that allows objects to be placed on screen using a timer.
 */
public class TimerHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) { 
        System.out.println("Action event!"); 
    }
    
}
