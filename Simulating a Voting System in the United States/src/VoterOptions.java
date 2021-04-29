/* 
Alejandro Figueroa, 4/2/2021

Comments, edits, questions, suggestions, or concerns are welcomed!

Todo list/Issues:
    How to make Voter and VoterOptions work together.
    Fetching the candidate list that will include senate and house.
*/

import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VoterOptions extends Application {

    @Override
    public void start(Stage voterStage) throws Exception {
        //Ignore this
    }

    public static Scene getScene(Stage voterStage) {
        Scene voteScene, thankYouScene;

        //Displays instructions to the voter. Also, changes text font and size. Creates labels for candidates.
        Label firstLabel = new Label("Please choose the candidate you wish to support and enter their information into the fields below.");
        firstLabel.setFont(new Font("Arial", 18));
        Label ResponseLabel = new Label("You have casted your ballot!");
        ResponseLabel.setFont(new Font("Arial", 18));

        //Creates a logout button that retruns the user to the login screen.
        Button Logout = new Button("Return to login screen");
        Logout.setFont(new Font("Arial", 18));

        //Creates a somewhat nice layout.
        VBox layout1 = new VBox(20);
        Label firstName, lastName, partyName, positionTitle, runningMate;

        //Fetches the database information and creates an arraylist to later display.
        ArrayList<String[]> Candidates = Database.getAllCandidates();
        Iterator<String[]> plus = Candidates.iterator();

        //Will loop to display each party for a stright ticket approach.
        while(plus.hasNext()) {
            String[] candidate = plus.next();
            if(candidate.length == 5){
                partyName = new Label("Party: " + candidate[2]);
                positionTitle = new Label ("Position: " + candidate[3]);
                firstName = new Label("First Name: " + candidate[0]);
                lastName = new Label("Last Name: " + candidate[1]);
                layout1.getChildren().add(new HBox(20, partyName, positionTitle, 
                firstName, lastName)); 
                
                HBox cTemp = new HBox(20, partyName, positionTitle, firstName, lastName);
                cTemp.setAlignment(Pos.CENTER);
                layout1.getChildren().add(cTemp);
            } else {
                partyName = new Label("Party: " + candidate[2]);
                positionTitle = new Label ("Position: " + candidate[3]);
                firstName = new Label("First Name: " + candidate[0]);
                lastName = new Label("Last Name: " + candidate[1]);
                runningMate = new Label ("Running Mate: " + candidate[5]);
                layout1.getChildren().add(new HBox(20, partyName, positionTitle, 
                firstName, lastName, runningMate)); 

                HBox cTemp = new HBox(20, partyName, positionTitle, firstName, lastName, runningMate);
                cTemp.setAlignment(Pos.CENTER);
                layout1.getChildren().add(cTemp);

            }
        }

        //Creates labels for entering information.
        Label candidatePartyLabel = new Label("Enter Party");
        Label candidatePosLabel = new Label("Enter Position");

        //Creates text fields to enter information.
        TextField candidatePartyTextField = new TextField();
        TextField candidatePosTextField = new TextField();

        //Creates a new VBox that contains the response and logout button.
        VBox layout2 = new VBox(15, ResponseLabel, Logout);
        layout2.setAlignment(Pos.CENTER);

        //Thank you scene to be displayed after voting is done.
        thankYouScene = new Scene(layout2, 950, 700);

        //Casting button.
        Button buttonCast = new Button("Cast Ballot");
        buttonCast.setFont(new Font("Arial", 18));

        //Once the button is pressed, the vote will go to that person and the thank you screen will appear.
        buttonCast.setOnAction(e -> {
            Database.vote(candidatePartyTextField.getText(), candidatePosTextField.getText(), "1");
            voterStage.setScene(thankYouScene);
        });

        //Centers the cast button.
        layout1.getChildren().addAll(firstLabel, candidatePartyLabel, candidatePartyTextField, candidatePosLabel, candidatePosTextField, buttonCast);
        layout1.setAlignment(Pos.CENTER);
        layout1.setPadding(new Insets(10, 10, 10, 10));

        //Creates a scroll bar for everything.
        ScrollPane scrollBar = new ScrollPane();
        scrollBar.setContent(layout1);
        scrollBar.setFitToWidth(true);
        voteScene = new Scene(scrollBar, 950, 700);

        //Takes the user to the next scene.
        Logout.setOnMouseClicked(e -> {
            voterStage.setScene(LoginWindow.getScene(voterStage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });

        //Returns vote scene.
        return voteScene;
    } 
}