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

public class VoterOptions extends Application {

    /*This is a vauge idea of how I thought of doing it.
    
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
        //Displays instructions to the voter.
        Label firstLabel = new Label("Please select the person you support.");
        Label ResponseLabel = new Label();

        //Informs the voter that their ballot has been casted when clicked.
        Button button = new Button("Cast Ballot");

        //Displays the candidates. Note: how to pull from database.
        RadioButton radio1 = new RadioButton("Candidate Information");
        RadioButton radio2 = new RadioButton("Candidate Information");
        RadioButton radio3 = new RadioButton("Candidate Information");
        RadioButton radio4 = new RadioButton("Candidate Information");

        //Groups the radio buttons.
        ToggleGroup CandidateList = new ToggleGroup();
        radio1.setToggleGroup(CandidateList);
        radio2.setToggleGroup(CandidateList);
        radio3.setToggleGroup(CandidateList);
        radio4.setToggleGroup(CandidateList);

        //
        button.setDisable(true);
        radio1.setOnAction(e -> button.setDisable(false));
        radio2.setOnAction(e -> button.setDisable(false));
        radio3.setOnAction(e -> button.setDisable(false));
        radio4.setOnAction(e -> button.setDisable(false));

        //Once the voter casted their vote, the next thing they see is what is in ResponseLabel.
        button.setOnAction(e -> {
            if (radio1.isSelected() || radio2.isSelected() || 
            radio3.isSelected() || radio4.isSelected()) {
                ResponseLabel.setText("You have casted your ballot!");
                button.setDisable(true);
            }           
        });

        //Create a somewhat nice layout.
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(firstLabel, radio1, radio2, radio3, radio4, button, ResponseLabel);

        Scene scene = new Scene(layout, 400, 250);

        return scene;
    }













    
}