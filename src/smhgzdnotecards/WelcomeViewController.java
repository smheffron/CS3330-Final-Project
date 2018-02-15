/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhgzdnotecards;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Shelby
 */
public class WelcomeViewController extends Switchable implements Initializable 
{
    AllNoteCardSets allNoteCardSets;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        //we need to load saved data immediately apon entry to the application
        deSerialize();
    }   

    @FXML
    private void handleNewSetButton(ActionEvent event) 
    {
        //this method will transport to new set window
        
        Switchable.switchTo("NewSetView");
        
        NewSetViewController controller = (NewSetViewController)getControllerByName("NewSetView");
        
        if (controller != null) 
        {
            controller.allNoteCardSets = allNoteCardSets;
        }
        
    }

    @FXML
    private void handleLoadSetButton(ActionEvent event) 
    {
        //this method will transport to the load set window
        
        Switchable.switchTo("LoadSetView");
        
        LoadSetViewController controller = (LoadSetViewController)getControllerByName("LoadSetView");
        
        if (controller != null) 
        {
            controller.allNoteCardSets = allNoteCardSets;
            controller.realInit();
           
         
        }
        
    }
    
    private void deSerialize()
    {
        //this method will load saved data in the specified path, so long it exists
        
        try
        {   
            String filename = "src/serialization/allSets.ser";
           
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            
            allNoteCardSets = (AllNoteCardSets)in.readObject();
             
            in.close();
            file.close();
        }
        catch(IOException | ClassNotFoundException ex)
        {
        }
        catch(Exception ex)
        {
        }
        
    }

    @FXML
    private void handleAboutButton(ActionEvent event) 
    {
        //this method will transport to the about page
        
        Switchable.switchTo("AboutView");
    }

}
