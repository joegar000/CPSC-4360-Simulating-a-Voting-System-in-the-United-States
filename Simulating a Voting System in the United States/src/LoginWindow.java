/* This class will contain the method for setting the JavaFX scene to the login screen
   I (David) have tested setting JavaFX scenes this way and it works */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class LoginWindow extends Application {
<<<<<<< HEAD

    private static Scene scene;
=======
>>>>>>> 82c949fdccab1ca43af0d7d1ef02c47666ddddca

    @Override
    public void start(Stage arg0) throws Exception {
        // Ignore this
	}

    public static Scene getScene() {

        // Add the layout info here, then add it to the scene

        return scene;
    }
}