/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhgzdnotecards;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *implemented for final project from in class lecture #37
 * @author Professor Wergeles, added to by Shelby
 */

public abstract class Switchable 
{
    public static Scene scene;
    private static Stage stage;
    public static  HashMap<String, Switchable> controllers = new HashMap<>();
    private Parent root;  
    
    public static Switchable add(String name) 
    {
        Switchable controller; 
        
        controller = controllers.get(name); 
        
        if(controller == null)
        {
            try 
            {
                FXMLLoader loader = new FXMLLoader(Switchable.class.getResource(name + ".fxml"));
                 
                Parent root = loader.load();
                
                controller = loader.getController(); 
                
                controller.setRoot(root); 
                
                controllers.put(name, controller); 
                
            } catch (IOException ex) {
                Logger.getLogger(Switchable.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error loading " + name + ".fxml \n\n " + ex); 
                controller = null; 
            } catch (Exception ex){
                System.out.println("Error loading " + name + ".fxml \n\n " + ex); 
                controller = null; 
            }
        }
        return controller; 
    }
    
    public static void switchTo(String name) 
    {
        Switchable controller = controllers.get(name); 
        
        if(controller == null){
            controller = add(name); 
        }
        
        if(controller != null){
            if(scene != null){
                scene.setRoot(controller.getRoot());
            }
        }
    }
    
    public void setRoot(Parent root) 
    {
        this.root = root;
    }
    
    public Parent getRoot() 
    {
        return root;
    }
    
    public static Switchable getControllerByName(String name) 
    {
        return controllers.get(name);
    }
    
    public static Stage getStage()
    {
        return Switchable.stage;
        
    }
    
    public static void setStage(Stage stage)
    {
        Switchable.stage = stage;
    }
}