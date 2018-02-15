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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Shelby
 */
public class LoadSetViewController extends Switchable implements Initializable, Serializer
{

    @FXML
    private ListView<NoteCardSet> setListView;
    
    AllNoteCardSets allNoteCardSets;
    
    private ObservableList<NoteCardSet> oList;
    
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
        //this method will switch to the main menu upon clicking the "Main Menu" button
        Switchable.switchTo("WelcomeView");
    }
    
    public void realInit()
    {
      //the purpose of this method is to have the observable list update everytime this method is called
      //it is called realInit(), becuase the initialize() method will only run once throughout the applications
      //lifecycle and I need it to be called multiple times 
      try
      { 
        oList = FXCollections.observableArrayList(allNoteCardSets.getAllNoteCardSets());
        setListView.setItems(oList);
        
        }catch(NullPointerException ex)
        {
        }
        catch(Exception ex)
        {
        }
      
      
    }

    @FXML
    private void handleMouseClick(MouseEvent event) 
    {
        //this method handles rightclicks and regular clicks on an item in the ListView
        
        if(event.getButton().equals(MouseButton.SECONDARY))
        {
            //display the delete option
            if(setListView.getSelectionModel().getSelectedItem() != null)
            {
                ContextMenu rightClick = new ContextMenu();
                MenuItem delete = new MenuItem("Delete");

                delete.setOnAction((ActionEvent) ->{
                    allNoteCardSets.getAllNoteCardSets().remove(setListView.getSelectionModel().getSelectedItem());
                    serialize();
                    realInit();
                });

                rightClick.getItems().addAll(delete);
                rightClick.show(Switchable.getStage(), event.getScreenX(), event.getScreenY());
            }
        }
        else
        {
            //go to the clicked on set and display it in SetView
            Switchable.switchTo("SetView");

            SetViewController controller = (SetViewController)getControllerByName("SetView");

            if (controller != null) 
            {
                controller.noteCardSet = setListView.getSelectionModel().getSelectedItem();  
                
                setListView.getSelectionModel().clearSelection();
                
                if(controller.noteCardSet == null)
                {
                    Switchable.switchTo("LoadSetView");
                    return;
                }

                controller.realInit();
            }
        }
    }
    
    @Override
    public void serialize()
    {
      //save data (update) if an item is deleted
       try
        {   
            String filename = "src/serialization/allSets.ser";

            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

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
}
