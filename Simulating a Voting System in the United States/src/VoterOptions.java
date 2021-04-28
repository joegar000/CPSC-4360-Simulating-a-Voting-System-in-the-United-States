/* 
Alejandro Figueroa, 4/2/2021

Comments, edits, questions, suggestions, or concerns are welcomed!

Todo list/Issues:
How to make Voter and VoterOptions work together.
    Fetching the candidate list that will include senate and house.
    Recording each vote.
*/

import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
//import javafx.scene.control.Toggle;
//import javafx.scene.control.ToggleGroup;
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

        //Displays instructions to the voter. Also, changes text font and size. Create labels for candidates.
        Label firstLabel = new Label("Please choose the candidate you wish to support and enter their information into the fields below.");
        firstLabel.setFont(new Font("Arial", 18));
        Label ResponseLabel = new Label("You have casted your ballot!");
        ResponseLabel.setFont(new Font("Arial", 18));
        //Label fullName, positionTitle, partyName, runningMate;

        //Informs the voter that their ballot has been casted when clicked As well as a button to return to login.
        
        Button Logout = new Button("Return to login screen");
        Logout.setFont(new Font("Arial", 18));

        //Creates a toggle group for the radio button.
        //ToggleGroup CandidateList = new ToggleGroup();

        //Disables cast button on login.
        //buttonCast.setDisable(true);

        //Create a somewhat nice layout.
        VBox layout1 = new VBox(15, firstLabel);
        layout1.setAlignment(Pos.CENTER);
        layout1.setPadding(new Insets(10, 10, 10, 10));

        //Fetches the database information and creates an arraylist to later display.
        ArrayList<String[]> Candidates = Database.getAllCandidates();
        Iterator<String[]> plus = Candidates.iterator();
        //int canSize = Candidates.size();

        Label cfName, clName, party, position, rMate;

        while(plus.hasNext()) {
            String[] candidate = plus.next();
            if(candidate.length == 5){
                cfName = new Label("First Name: " + candidate[0]);
                clName = new Label("Last Name: " + candidate[1]);
                party = new Label("Party: " + candidate[2]);
                position = new Label ("Position: " + candidate[3]);
                layout1.getChildren().add(new HBox(20, cfName, clName, 
                party, position)); 
                
                HBox cTemp = new HBox(20, cfName, clName, party, position);
                cTemp.setAlignment(Pos.CENTER);
                layout1.getChildren().add(cTemp);
            }

            else{
                cfName = new Label("First Name: " + candidate[0]);
                clName = new Label("Last Name: " + candidate[1]);
                party = new Label("Party: " + candidate[2]);
                position = new Label ("Position: " + candidate[3]);
                rMate = new Label ("Running Mate: " + candidate[5]);
                layout1.getChildren().add(new HBox(20, cfName, clName, 
                party, position, rMate)); 

                HBox cTemp = new HBox(20, cfName, clName, party, position, rMate);
                cTemp.setAlignment(Pos.CENTER);
                layout1.getChildren().add(cTemp);

            }
            
            
        }

        //Labels
        Label candidateFNameLabel = new Label("Enter First Name");
        Label candidateLNameLabel = new Label("Enter last Name");
        Label candidatePartyLabel = new Label("Enter Party");
        Label candidatePosLabel = new Label("Enter Position");
        //TextFields
        TextField candidateFNTextField = new TextField();
        TextField candidateLNTextField = new TextField();
        TextField candidatePartyTextField = new TextField();
        TextField candidatePosTextField = new TextField();

        VBox layout2 = new VBox(15, ResponseLabel, Logout);
        layout2.setAlignment(Pos.CENTER);

        thankYouScene = new Scene(layout2, 950, 700);

        Button buttonCast = new Button("Cast Ballot");
        buttonCast.setFont(new Font("Arial", 18));

        

        buttonCast.setOnAction(e -> {
            //String[] info = Database.getCandidate(candidatePartyTextField.getText(), candidatePosTextField.getText());
            Database.vote(candidatePartyTextField.getText(), candidatePosTextField.getText(), "1");
            voterStage.setScene(thankYouScene);
        });

        //Centers the cast button.
        VBox castBtn = new VBox(20, candidateFNameLabel, candidateFNTextField, candidateLNameLabel, 
        candidateLNTextField, candidatePartyLabel, candidatePartyTextField, candidatePosLabel, candidatePosTextField, buttonCast);
        castBtn.setAlignment(Pos.CENTER);
        layout1.getChildren().addAll(castBtn);

        //Displays a screen to thank the user.
        

        //Creates the thank you screen that tells the user they have finished.
        

        //Takes the user to the next scene.
        
        Logout.setOnMouseClicked(e -> {
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

       //Will loop to display each party for a stright ticket approach.
        /*while(plus.hasNext()) {
            String[] candidate = plus.next();
            
            //Checks to see if the person is running for President or Congress.
            if (candidate.length == 5) {

                //Creates the radio button to vote and assigns it to the toggle group.
                RadioButton pickButton = new RadioButton("Name: " + candidate[0] + " " + candidate[1] + "Party: " + candidate[2] + "Position: " + candidate[3]);
                pickButton.setToggleGroup(CandidateList);

                CandidateList.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                    public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n){
                        RadioButton rb = (RadioButton)CandidateList.getSelectedToggle();

                        if(rb != null){
                            Database.vote(candidate[2], candidate[3]);
                        }
                    }
                });
                //Enables cast button once selected.
                pickButton.setOnAction(e -> {
                    buttonCast.setDisable(false);
                    //buttonCast.setOnAction(f -> Database.vote(candidate[2], candidate[3]));
                });
            
                //Displays the candidates information.
                fullName = new Label("Name: " + candidate[0] + " " + candidate[1]);
                partyName = new Label("Party: " + candidate[2]);
                positionTitle = new Label("Position: " + candidate[3]);

                50-50 chance this works. Untested since I can't yet see a screen where votes are counted.
                /*buttonCast.setOnAction(e -> {
                    CandidateList.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                        public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n){
                            RadioButton rb = (RadioButton)CandidateList.getSelectedToggle();

                            if(rb != null){
                                Database.vote(candidate[2], candidate[3]);
                            }
                        }
                    });
                });

                //Creates HBox and centers information.
                HBox temp = new HBox(20, pickButton);
                temp.setAlignment(Pos.CENTER);
                layout1.getChildren().add(temp);
            } else {

                //Creates the radio button to vote and assigns it to the toggle group.
                RadioButton pickButton = new RadioButton("Name: " + candidate[0] + " " + candidate[1] + "Party: " + candidate[2] + "Position: " + candidate[3]);
                pickButton.setToggleGroup(CandidateList);

                //Enables cast button once selected.
                pickButton.setOnAction(e -> buttonCast.setDisable(false));

                //Displays the candidates information.
                fullName = new Label("Name: " + candidate[0] + " " + candidate[1]);
                partyName = new Label("Party: " + candidate[2]);
                positionTitle = new Label("Position: " + candidate[3]);
                runningMate = new Label("Running Mate: " + candidate[5]);

                50-50 chance this works. Untested since I can't yet see a screen where votes are counted.
                buttonCast.setOnAction(e -> {
                    CandidateList.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                        public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n){
                            RadioButton rb = (RadioButton)CandidateList.getSelectedToggle();

                            if(rb != null){
                                Database.vote(rb.get(candidate[2], candidate[3]));
                            }
                        }
                    });
                });
                
                //Creates HBox and centers information.
                HBox temp = new HBox(20, pickButton);
                temp.setAlignment(Pos.CENTER);
                layout1.getChildren().add(temp);
            }
        }*/ 
    } 
}