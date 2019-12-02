/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montyhall.Ui;

import montyhall.Core.Constants;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static montyhall.Core.Constants.GoatPath;

/**
 * A class to manage the UI elements of the application
 * @author Wesley
 */
public class UIManager {
    
    //Create a dictionary 
    private HashMap<String, ImageIcon> toggleImages;
    
    /**
     * The default constructor of the UI Manager class
     */
    public UIManager(){
        this.toggleImages = new HashMap<>();
    }
    
    /**
     * Loads the appropriate images
     */
    public void load(){
        try{
            //Add goat image to map
            this.toggleImages.put(Constants.GoatNameString, new ImageIcon(ImageIO.read(new File(Constants.GoatPath))));
            
            //add car image to map
            this.toggleImages.put(Constants.CarNameString, new ImageIcon(ImageIO.read(new File(Constants.CarPath))));

        }
        catch(Exception e){
            
        }
    }
    
    /**
     * Gets your goat
     * @return an image icon of a goat
     */
    public ImageIcon getGoat(){
        return this.toggleImages.get(Constants.GoatNameString);
    }
    
    /**
     * Dude wheres my car?? this gets your car
     * @return an image icon of a car
     */
    public ImageIcon getCar(){
        return this.toggleImages.get(Constants.CarNameString);
    }
}
