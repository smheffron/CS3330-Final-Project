/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhgzdnotecards;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Shelby
 */
public class AboutViewController extends Switchable implements Initializable 
{
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    

    @FXML
    private void handleMainMenuButton(ActionEvent event) 
    {
        //this method switches scenes back to the main menu upon click of the "Main Menu" button
        Switchable.switchTo("WelcomeView");
    }
    
}
