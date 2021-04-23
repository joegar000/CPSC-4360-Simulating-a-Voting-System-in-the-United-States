/* This class will contain the method for setting the JavaFX scene to the voter options
   I (David) have tested setting JavaFX scenes this way and it works */

import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VoterOptions extends Application {

    /*This is a vauge idea of how I thought of doing it.
    
    Issues:
    How to make Voter and VoterOptions work together.
    Fetching the candidate list that will include senate and house.
    Recording each vote.
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
        Label fullName, positionTitle, partyName, runningMate;

        //Informs the voter that their ballot has been casted when clicked As well as a button to return to login.
        Button buttonCast = new Button("Cast Ballot");
        buttonCast.setFont(new Font("Arial", 18));
        Button button2 = new Button("Return to login screen");
        button2.setFont(new Font("Arial", 18));

        //Creates a toggle group for the radio button.
        ToggleGroup CandidateList = new ToggleGroup();

        //Disables cast button on login.
        buttonCast.setDisable(true);

        //Create a somewhat nice layout.
        VBox layout1 = new VBox(15, firstLabel /*radio1, radio2, radio3, radio4,*//*, buttonCast*/);
        layout1.setAlignment(Pos.CENTER);

        //Fetches the database information and creates an arraylist to later display.
        ArrayList<String[]> Candidates = Database.getAllCandidates();
        Iterator<String[]> plus = Candidates.iterator();

        //Will loop to display each party for a stright ticket approach.
        while(plus.hasNext()) {
            String[] candidate = plus.next();
            
            //Checks to see if the person is running for President or Congress.
            if (candidate.length == 5) {

                //Creates the radio button to vote and assigns it to the toggle group.
                RadioButton pickButton = new RadioButton();
                pickButton.setToggleGroup(CandidateList);

                //Enables cast button once selected.
                pickButton.setOnAction(e -> buttonCast.setDisable(false));
            
                //Displays the candidates information.
                fullName = new Label("Name: " + candidate[0] + " " + candidate[1]);
                partyName = new Label("Party: " + candidate[2]);
                positionTitle = new Label("Position: " + candidate[3]);

                //Creates HBox and centers information.
                HBox temp = new HBox(20, pickButton, fullName, partyName, positionTitle);
                temp.setAlignment(Pos.CENTER);
                layout1.getChildren().add(temp);
            } else {

                //Creates the radio button to vote and assigns it to the toggle group.
                RadioButton pickButton = new RadioButton();
                pickButton.setToggleGroup(CandidateList);

                //Enables cast button once selected.
                pickButton.setOnAction(e -> buttonCast.setDisable(false));

                //Displays the candidates information.
                fullName = new Label("Name: " + candidate[0] + " " + candidate[1]);
                partyName = new Label("Party: " + candidate[2]);
                positionTitle = new Label("Position: " + candidate[3]);
                runningMate = new Label("Running Mate: " + candidate[5]);
                
                //Creates HBox and centers information.
                HBox temp = new HBox(20, pickButton, fullName, partyName, positionTitle, runningMate);
                temp.setAlignment(Pos.CENTER);
                layout1.getChildren().add(temp);
            }
        }

        //Centers the cast button.
        VBox castBox = new VBox(buttonCast);
        castBox.setAlignment(Pos.CENTER);
        layout1.getChildren().add(castBox);

        //Displays a screen to thank the user.
        VBox layout2 = new VBox(15, ResponseLabel, button2);
        layout2.setAlignment(Pos.CENTER);

        //Creates the thank you screen that tells the user they have finished.
        thankYouScene = new Scene(layout2, 950, 700);

        //Takes the user to the next scene.
        buttonCast.setOnAction(e -> voterStage.setScene(thankYouScene));
        button2.setOnMouseClicked(e -> {
            voterStage.setScene(LoginWindow.getScene(voterStage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });

        //Vote scene.
        voteScene = new Scene(layout1, 950, 700);

        //Returns vote scene.
        return voteScene;
    } 
}