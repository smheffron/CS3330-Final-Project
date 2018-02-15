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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Shelby
 */
public class SetViewController extends Switchable implements Initializable 
{
    private int cardNumber;
    private String status;

    @FXML
    private Label flashCardLabel;
    
    NoteCardSet noteCardSet;

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
        //this method simply switches to the main menu if the "Main Menu" button is clicked
        Switchable.switchTo("WelcomeView");
    }

    @FXML
    private void handleNextButton(ActionEvent event) 
    {
        
        //making sure that we dont run off the end of the set, also goes to the next notecard in the set
        cardNumber++;
        
        if(cardNumber > noteCardSet.getNoteCardSet().size()-1)
        {
            cardNumber = noteCardSet.getNoteCardSet().size()-1;
        }
        
        if(cardNumber < noteCardSet.getNoteCardSet().size())
        {
            flashCardLabel.setText(noteCardSet.getNoteCardSet().get(cardNumber).getFront());
            status = "front";
        }
        
    }
    
    @FXML
    private void handlePrevButton(ActionEvent event) 
    {
        //making sure we dont run off the front of the set, also displays the prev. notecard in the set
        cardNumber--;
        
        if(cardNumber<0)
        {
            cardNumber = 0;
        }
        
        if(cardNumber < noteCardSet.getNoteCardSet().size())
        {
            flashCardLabel.setText(noteCardSet.getNoteCardSet().get(cardNumber).getFront());
            status = "front";
        }
    }
    
    public void realInit()
    {
      //the purpose of this method is to have the setView start with the first card and the front of that card
      //everytime this method is called
      //it is called realInit(), becuase the initialize() method will only run once throughout the applications
      //lifecycle and I need it to be called multiple times, especially when switching to this scene
        cardNumber = 0;
        status = "front";
        
        if(cardNumber < noteCardSet.getNoteCardSet().size())
        {
            flashCardLabel.setText(noteCardSet.getNoteCardSet().get(cardNumber).getFront());
        }
    }

    @FXML
    private void handleMouseFlip(MouseEvent event) 
    {
        //the purpose of this method is to handle a double click to flip the card and reveal the front/back
        
        if(event.getClickCount() == 2)
        {
            if(cardNumber < noteCardSet.getNoteCardSet().size())
            {
                if("front".equals(status))
                {
                    flashCardLabel.setText(noteCardSet.getNoteCardSet().get(cardNumber).getBack());
                    status = "back";
                }
                else if("back".equals(status))
                {
                   flashCardLabel.setText(noteCardSet.getNoteCardSet().get(cardNumber).getFront()); 
                   status = "front";
                }
            }
        }
    }
    
}
