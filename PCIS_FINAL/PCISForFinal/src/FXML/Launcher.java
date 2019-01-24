
package FXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The launcher for the PCIS project.
 * <p>The purpose of this system is to find the Cartridges in Inventory 
 * for a specific Printer after being given an asset tag number associated
 * with the Printer, then have the user leave a comment which will be sent
 * to a file based on room number.
 * 
 * @author Tara Mckasckle of Team 4
 * @author Eric Arnold of Team 4
 * @author Matt Chandler of Team 4
 * @author Sean Roberts of Team 4
 *
 */
public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/PCISDialog.fxml"));
        primaryStage.setTitle("Printer Inventory Manager");
        primaryStage.setScene(new Scene(root, 347, 518));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}