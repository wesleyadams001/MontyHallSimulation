/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montyhall.Models;

import java.util.ArrayList;
import java.util.Random;
import montyhall.Core.Constants;
import montyhall.Core.Observer;
import montyhall.Core.Subject;

/**
 * Monty Hall game model utilizes the provided seed code
 * @author Wesley
 */
public class Game implements Subject {
    
    private String strategy;
    private int runs;
    private int wins;
    private int losses;
    private int[] doors;
    private Random generator;
    private int choice;
    private int shown;
    
    /**
     * Represents an array list of observer objects
     */
    private final ArrayList<Observer> observerList;
    
    /**
     * The default constructor of the game model of the monty hall simulation
     */
    public Game(){
        this.doors = new int[]{0,0,0};
        this.observerList = new ArrayList<Observer>();
        this.generator = new Random();
    }

    /**
     * Set the users chosen door
     * @param UserChosenDoor 
     */
    public void setUserChosenDoor(int UserChosenDoor) {
        
        //set the user chosen door and decrement by one immediately since 
        //using the value of the door and the array is 0-2 not 1-3
        this.choice = UserChosenDoor-1;
    }
    
    /**
     * Sets the options behind the three doors
     */
    public void setUpOptions(){
        
        //put a winner in a random door
        this.doors[generator.nextInt(3)] = 1;
        
         do{
               //Set the door to show 
               shown = this.generator.nextInt(3);
               
         //don't show the winner or the choice
        }while(doors[shown] == 1 || shown == choice);
    }
    
    /**
     * Runs the Game logic
     */
    public void Play(){
        for(int x = 0; x< this.runs; x++){
            
            if(this.strategy.equals(Constants.StrategyStay)){
                
                //Simulate the stay strategy by examining the user door choice
                if(this.doors[this.choice]==1)
                    this.wins++;
                else{
                    this.losses++;
                }
            }
            else if(this.strategy.equals(Constants.StrategySwitch)){
                
                //Simulate switch by creating the new choice as an 
                //integer not equal to the current choice or the shown choice
                int newChoice = -1;
                
                do{
                     newChoice = this.generator.nextInt(3);
                }while(newChoice==this.choice || newChoice == this.shown);
                
                //if the new choice is a winner increment wins
                if(this.doors[newChoice]==1){
                   this.wins ++;
                }
                //else losses
                else{
                    this.losses++;
                }
            }
            notifyObservers();
            this.doors = new int[]{0,0,0};
            setUpOptions();
            
        }
        this.wins =0;
        this.losses=0;
    }
    
    /**
     * Gets the current number of runs
     * @return int indicating the number of runs
     */
    public int getRuns() {
        return runs;
    }
    
    /**
     * Sets the number of runs
     * @param rs 
     */
    public void setRuns(int rs){
        this.runs = rs;
    }

    /**
     * Gets the current number of wins
     * @return int indicating the number of wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Gets the currently set strategy for the game
     * @return String strategy
     */
    public String getStrategy() {
        return strategy;
    }
    
    /**
     * Sets the strategy
     * @param strat string value of strategy
     */
    public void setStrategy(String strat){
        this.strategy = strat;
    }
    
     /**
     * Pass observer object to observer list to be added.
     * @param o Observer object to be added.
     */
    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    /**
     * Pass observer object to observer list to be removed.
     * @param o Observer object to be removed.
     */
    @Override
    public void unregisterObserver(Observer o) {
        observerList.remove(observerList.indexOf(o));
    }

    /**
     * Go through observerList and update observer objects with changes.
     */
    @Override
    public void notifyObservers() {
        observerList.forEach((o) -> {
            o.update("Wins: "+String.valueOf(this.wins) + "|Losses: " + String.valueOf(this.losses));
        });
    }

}
