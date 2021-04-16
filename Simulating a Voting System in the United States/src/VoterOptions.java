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

        //We create the window which will contain the title and directions.
        voterStage.setTitle("Welcome to the US elections!");
        Label firstLabel = new Label("Please select your candidate to endorse.");
        Label labelResponse = new Label();

        //A button is create so that the user is able to cast their ballot.
        Button button = new Button("Cast Ballot");
        button.setDisable(true);
        
        //Note: Need to somehow fetch the list of runners.
        RadioButton radio0 = new RadioButton("Candidate Information");
        RadioButton radio1 = new RadioButton("Candidate Information");
        RadioButton radio2 = new RadioButton("Candidate Information");
        RadioButton radio3 = new RadioButton("Candidate Information");

        //Toggle group buttons.
        ToggleGroup CandidateList = new ToggleGroup();
        radio0.setToggleGroup(CandidateList);
        radio1.setToggleGroup(CandidateList);
        radio2.setToggleGroup(CandidateList);
        radio3.setToggleGroup(CandidateList);

        /*When a radio button is clicked, the button gets disabled (or enabled). 
        Now, it can be clicked and the vote can be submitted for the election.*/
        radio0.setOnAction(e -> button.setDisable(false));
        radio1.setOnAction(e -> button.setDisable(false));
        radio2.setOnAction(e -> button.setDisable(false));
        radio3.setOnAction(e -> button.setDisable(false));

        //When one choice is selected, it will be confrimed by telling the user what is in labelResponse.
        button.setOnAction(e -> {
        if(radio0.isSelected() || radio1.isSelected() || 
        radio2.isSelected() || radio3.isSelected()) {
            labelResponse.setText("Thank you for casting your vote.");
            button.setDisable(true);
        }});

        //We create the layout and space out the options.
        VBox layout = new VBox(20);
        layout.getChildren().addAll(firstLabel, radio0, radio1, radio2, radio3, button, labelResponse);

        //Create the scene and size.
        Scene sceneVoter = new Scene(layout, 500, 500);
        voterStage.setScene(sceneVoter);

        voterStage.show();
    }

    public static Scene getScene() {

        // Add the layout info here, then add it to the scene

        return scene;
    }
}