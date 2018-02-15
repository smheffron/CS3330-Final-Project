/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhgzdnotecards;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Shelby
 */
public class NewSetViewController extends Switchable implements Initializable, Serializer 
{
    @FXML
    private TextField frontTextField;
    
    @FXML
    private TextField backTextField;
    
    @FXML
    private TextField setName;
    
    @FXML
    private Label errorLabel;
    
    AllNoteCardSets allNoteCardSets;
    
    private NoteCardSet noteCardSet;
    
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
    private void handleAddNoteCardButton(ActionEvent event) 
    {
        //this method will add the data in the front and back fields to a new notecard
        //it will also add that notecard to its set
            if(noteCardSet == null)
            {
                noteCardSet = new NoteCardSet();
            }
            
            if(backTextField.getText().isEmpty() || frontTextField.getText().isEmpty())
            {
                errorLabel.setText("must enter both a front and back notecard");
            }
            else
            {
                errorLabel.setText("");
                
                NoteCard noteCard = new NoteCard();
            
                noteCard.setBack(backTextField.getText());
                noteCard.setFront(frontTextField.getText());
            
                noteCardSet.addNoteCardToSet(noteCard);
            
                backTextField.setText("");
                frontTextField.setText("");
            }
            
    }

    @FXML
    private void handleDoneButton(ActionEvent event) 
    {
        //this method will serialize the notecard set, and then exit to the main menu (if valid)
        
        if(allNoteCardSets == null)
        {
            allNoteCardSets = new AllNoteCardSets();
        }
        
        if(noteCardSet == null)
        {   
            errorLabel.setText("must enter both a set name and add at least one noteCard");
        }
        else if(setName.getText().isEmpty() || noteCardSet.getNoteCardSet().isEmpty())
        {
            errorLabel.setText("must enter both a set name and add at least one noteCard");
        }
        else
        {
            errorLabel.setText("");
            noteCardSet.setSetName(setName.getText());
            allNoteCardSets.addNoteCardSetToAllSets(noteCardSet);
            serialize();
            
            noteCardSet = null;
            setName.setText("");
            
            Switchable.switchTo("WelcomeView");
        
            WelcomeViewController controller = (WelcomeViewController)getControllerByName("WelcomeView");
        
            if (controller != null) 
            {
                controller.allNoteCardSets = allNoteCardSets;
            }
        }  
    }
    
    @Override
    public void serialize()
    {
        //this method will save the newly created set
       try
        {   
            String filename = "src/serialization/allSets.ser";
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
             
            // Method for serialization of object
            out.writeObject(allNoteCardSets);
             
            out.close();
            file.close();
        }
         
        catch(IOException ex)
        {
        }
       catch(Exception ex)
       {
       }
 
    }

    @FXML
    private void handleExitButton(ActionEvent event) 
    {
        // if the user wants to back out and not save (serialize) their set, they may click on the exit button 
        if(noteCardSet!=null)
        {
            noteCardSet.getNoteCardSet().clear();
            noteCardSet = null;
        }
        
        errorLabel.setText("");
        setName.setText("");
        
        Switchable.switchTo("WelcomeView");
    }
        
}
