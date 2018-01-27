/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jordan
 */
public class Text1 extends Application {
    
    
    Stage window;
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        Parent root = null;
        Scene scene = null;
       
        
        try {
            root = FXMLLoader.load(getClass().getResource("/view/ui.fxml"));
            scene = new Scene(root);

        } catch (IOException ex) {
            Logger.getLogger(Text1.class.getName()).log(Level.SEVERE, null, ex);
        }
        window.setTitle("Sort Evaluation project");
        window.setResizable(true);
        window.setScene(scene);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
