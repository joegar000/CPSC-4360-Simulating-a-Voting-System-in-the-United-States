/* This class will contain the method for setting the JavaFX scene to the voter options
   I (David) have tested setting JavaFX scenes this way and it works */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VoterOptions extends Application {

    /*This is a vauge idea of how I thought of doing it.
    
    Issues:
    Going from login screen to here.
    How to make Voter and VoterOptions work together.
    Fetching the candidate list. Then, fitting it in.
    Recording each vote, exiting/going back to the start for a new user.
    */

    @Override
    public void start(Stage voterStage) throws Exception {
        //Ignore this
    }

    public static Scene getScene(Stage voterStage) {
        Scene voteScene, thankYouScene;

        //Displays instructions to the voter. Also, changes text font and size.
        Label firstLabel = new Label("Please select the person you support.");
        firstLabel.setFont(new Font("Arial", 18));
        Label ResponseLabel = new Label("You have casted your ballot!");
        ResponseLabel.setFont(new Font("Arial", 18));

        //Informs the voter that their ballot has been casted when clicked.
        Button button = new Button("Cast Ballot");

        //Displays the candidates. Note: how to pull from database.
        RadioButton radio1 = new RadioButton("Candidate Information");
        RadioButton radio2 = new RadioButton("Candidate Information");
        RadioButton radio3 = new RadioButton("Candidate Information");
        RadioButton radio4 = new RadioButton("Candidate Information");

        //Changes the font and size.
        radio1.setFont(new Font("Arial", 18));
        radio2.setFont(new Font("Arial", 18));
        radio3.setFont(new Font("Arial", 18));
        radio4.setFont(new Font("Arial", 18));

        //Groups the radio buttons.
        ToggleGroup CandidateList = new ToggleGroup();
        radio1.setToggleGroup(CandidateList);
        radio2.setToggleGroup(CandidateList);
        radio3.setToggleGroup(CandidateList);
        radio4.setToggleGroup(CandidateList);

        //When first brought up, the cast ballot is disabled. Click on a person to enable it.
        button.setDisable(true);
        radio1.setOnAction(e -> button.setDisable(false));
        radio2.setOnAction(e -> button.setDisable(false));
        radio3.setOnAction(e -> button.setDisable(false));
        radio4.setOnAction(e -> button.setDisable(false));

        //Create a somewhat nice layout.
        VBox layout1 = new VBox(15, firstLabel, radio1, radio2, radio3, radio4, button);
        layout1.setAlignment(Pos.CENTER);

        VBox layout2 = new VBox(15, ResponseLabel);
        layout2.setAlignment(Pos.CENTER);
        thankYouScene = new Scene(layout2, 400, 250);

        //Takes the user to the next scene.
        button.setOnAction(e -> voterStage.setScene(thankYouScene));

        //Vote scene
        voteScene = new Scene(layout1, 400, 250);

        return voteScene;
    } 
}