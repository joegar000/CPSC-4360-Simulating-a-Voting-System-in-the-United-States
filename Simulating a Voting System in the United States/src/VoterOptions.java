/* This class will contain the method for setting the JavaFX scene to the voter options
   I (David) have tested setting JavaFX scenes this way and it works */

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class VoterOptions extends Application {

    /*This is a vauge idea of how I thought of doing it. I am a little confused as to if I did this
    correctly or if "start" was to be ignored.
    
    Issues:
    Going from login screen to here.
    How to make Voter and VoterOptions work together.
    Fetching the candidate list. Then, fitting it in.
    Recording each vote, exiting/going back to the start for a new user.
    Ensuring that a person cannot constantly vote over and over again.

    */

    private static Scene scene;

    @Override
    public void start(Stage voterStage) throws Exception {
        //Ignore this
    }

    public static Scene getScene() {
        return scene;
    }
}