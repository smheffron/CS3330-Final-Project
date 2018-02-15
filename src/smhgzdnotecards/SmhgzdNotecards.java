/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smhgzdnotecards;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Shelby
 */
public class SmhgzdNotecards extends Application 
{
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        FXMLLoader loader = new FXMLLoader(Switchable.class.getResource("WelcomeView.fxml"));   
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        
        Switchable.scene = scene; 
        Switchable.setStage(stage);  
        Switchable.switchTo("WelcomeView");
        
        stage.setScene(scene);
        stage.setTitle("FlashCards Pro");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
