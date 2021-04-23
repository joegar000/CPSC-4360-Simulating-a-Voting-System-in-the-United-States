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
        Label fullName, positionTitle, partyName, runningMate;

        //Informs the voter that their ballot has been casted when clicked As well as a button to return to login.
        Button buttonCast = new Button("Cast Ballot");
        buttonCast.setFont(new Font("Arial", 18));
        Button button2 = new Button("Return to login screen");
        button2.setFont(new Font("Arial", 18));

        /*
        //Displays the candidates. Note: how to pull from database.
        RadioButton radio1 = new RadioButton();
        RadioButton radio2 = new RadioButton();
        RadioButton radio3 = new RadioButton();
        RadioButton radio4 = new RadioButton("Candidate Information, Political Party");

        //Changes the font and size.
        radio1.setFont(new Font("Arial", 18));
        radio2.setFont(new Font("Arial", 18));
        radio3.setFont(new Font("Arial", 18));
        radio4.setFont(new Font("Arial", 18));

        //Groups the radio buttons. */
        ToggleGroup CandidateList = new ToggleGroup();
        /*radio1.setToggleGroup(CandidateList);
        radio2.setToggleGroup(CandidateList);
        radio3.setToggleGroup(CandidateList);
        radio4.setToggleGroup(CandidateList);

        //When first brought up, the cast ballot is disabled. Click on a person to enable it.
        button.setDisable(true);
        radio1.setOnAction(e -> button.setDisable(false));
        radio2.setOnAction(e -> button.setDisable(false));
        radio3.setOnAction(e -> button.setDisable(false));
        radio4.setOnAction(e -> button.setDisable(false));
        */

        //Create a somewhat nice layout.
        VBox layout1 = new VBox(15, firstLabel /*radio1, radio2, radio3, radio4,*//*, buttonCast*/);
        layout1.setAlignment(Pos.CENTER);

        ArrayList<String[]> Candidates = Database.getAllCandidates();
        Iterator<String[]> plus = Candidates.iterator();

        /*Unsure as to how to create more radio buttons everytime a new candidate is made. 
        Without two or more sharing the same variables.*/
        /*
        while(plus.hasNext()) {
            String[] Candidate = plus.next();
            RadioButton vBtn = new RadioButton();
            vBtn.setToggleGroup(CandidateList);
            firstName = new Label(Candidate[0]);
            lastName = new Label(", " + Candidate[1]);
            partyName = new Label(": " + Candidate[2]);
            
            layout1.getChildren().add(new HBox(vBtn, firstName, lastName, partyName));
        }*/
        
        while(plus.hasNext()) {
            String[] candidate = plus.next();

            RadioButton pickButton = new RadioButton();
            pickButton.setToggleGroup(CandidateList);
            
            fullName = new Label("Name: " + candidate[0] + " " + candidate[1]);
            partyName = new Label("Party: " + candidate[2]);
            positionTitle = new Label("Position: " + candidate[3]);
            
            HBox temp = new HBox(20, pickButton, fullName, partyName, positionTitle);
            temp.setAlignment(Pos.CENTER);
            layout1.getChildren().add(temp);
        }

        layout1.getChildren().add(new VBox(buttonCast));
        layout1.setAlignment(Pos.CENTER);

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

        //Vote scene
        voteScene = new Scene(layout1, 950, 700);

        return voteScene;
    } 
}