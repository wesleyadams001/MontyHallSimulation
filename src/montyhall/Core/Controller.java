/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montyhall.Core;

import montyhall.Models.Game;

/**
 * Monty Hall simulation controller
 * @author Wesley
 */
public class Controller {
    
    /**
     * A reference to the current game
     */
    private Game game;
    
    /**
     * The default constructor of the controller
     */
    public Controller(){
        this.game = new Game();
        
    }
    
    /**
     * returns the current game instance
     * @return an game instance
     */
    public Game getGame(){
        return this.game;
    }
    
    /**
     * Sets up the game
     * @param choice the users choice
     */
    public void Setup(int numRuns, int doorNum){
        this.game.setRuns(numRuns);
        this.game.setUserChosenDoor(doorNum);
        this.game.setUpOptions();
    }
    
    /**
     * Starts the game
     */
    public void Start(){
        this.game.Play();
    }
    
    /**
     * Sets the strategy of the game
     * @param strat string strategy
     */
    public void setStrategy(String strat){
        this.game.setStrategy(strat);
    }
}
