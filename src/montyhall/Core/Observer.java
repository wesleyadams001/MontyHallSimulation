/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montyhall.Core;

/**
 * This interface is implemented by all those
 * classes that are to be updated whenever there
 * is an update from a subject
 * @author Wesley
 */
public interface Observer {
    
    /**
     * Updates classes.
     * @param wins The current wins of the game
     */
    public void update(String wins);
}
