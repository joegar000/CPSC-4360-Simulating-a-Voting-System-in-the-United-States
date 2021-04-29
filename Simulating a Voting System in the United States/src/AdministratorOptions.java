/* This class will contain the method for setting the JavaFX scene to the administrator options
   I (David) have tested setting JavaFX scenes this way and it works */

/*
TODO:

Fix errors
implement code for different scenes 
*/
import java.util.ArrayList;
import java.util.Iterator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

   
public class AdministratorOptions extends Application {
    
    

    
    @Override
    public void start(Stage administratorStage) throws Exception {
        // Ignore this
    }


    public static Scene getScene(Stage administratorStage) {
        //Scenes initialized
        Scene OptionsScene, voterRegScene, adminRegScene, pollworkerRegScene, candidateRegScene, elecRegScene, 
        ValScene, VoterDBScene, CandidateDRScene;

        //OPTIONS SCENE
        //Labels
        Label label1 = new Label("Administrator Options");
        label1.setFont(new Font("Arial", 25));
        //TextFields
        //Buttons & Button Actions
        Button btn1 = new Button("Voter Registration");
        Button btn2 = new Button("Display Candidate Database");
        Button btn3 = new Button("Display Voter Database");
        //Button btn4 = new Button("Display Candidate Database");
        Button btn5 = new Button("Administrator Registration");
        Button btn6 = new Button("Pollworker Registration");
        Button btn7 = new Button("Candidate Registration");
        Button btn9 = new Button("Electorate Registration");
        Button btn8 = new Button("Candidate Results");
        Button logoutBtn = new Button("Log out");
        logoutBtn.setOnMouseClicked(e -> {
            administratorStage.setScene(LoginWindow.getScene(administratorStage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });

        //Layout
        VBox layout1 = new VBox(20, label1, btn1, btn5, btn6, btn7, btn9, btn2, btn3, btn8, logoutBtn);
        layout1.setAlignment(Pos.CENTER);
        layout1.setPadding(new Insets(10, 10, 10, 10));
        OptionsScene = new Scene(layout1, 950, 700);

        
        //VOTER REGISTRATION SCENE
        //Labels
        Label voterRegSceneTitle = new Label("Voter Registration");
        voterRegSceneTitle.setFont(new Font("Arial", 25));
        Label voterFNameLabel = new Label("Enter First Name");
        Label voterLNameLabel = new Label("Enter last Name");
        Label ageLabel = new Label("Enter Age");
        Label stateLabel = new Label("Enter State");
        Label voterSSNLabel = new Label("Enter SSN");
        //Text Fields
        TextField voterFNTextField = new TextField();
        TextField voterLNTextField = new TextField();
        TextField ageTextField = new TextField();
        TextField stateTextField = new TextField();
        TextField voterSSNTextField = new TextField();
        //Buttons & Button Actions
        Button regVoter = new Button("Register");
        regVoter.setOnAction(e -> {
            Database.registerVoter(voterSSNTextField.getText(), voterFNTextField.getText(), voterLNTextField.getText(), 
            ageTextField.getText(), stateTextField.getText(), false);
            voterSSNTextField.clear();
            voterFNTextField.clear();
            voterLNTextField.clear();
            ageTextField.clear();
            stateTextField.clear();
        });
        
        Button goBack1 = new Button("Go Back");
        goBack1.setOnAction(e -> administratorStage.setScene(OptionsScene));
        Button logoutBtn1 = new Button("Log out");
        logoutBtn1.setOnMouseClicked(e -> {
            administratorStage.setScene(LoginWindow.getScene(administratorStage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });
        //Layout
        VBox layout2 = new VBox(20, voterRegSceneTitle, voterFNameLabel, voterFNTextField, voterLNameLabel, 
        voterLNTextField, ageLabel, ageTextField, stateLabel, stateTextField, voterSSNLabel, 
        voterSSNTextField, regVoter, goBack1, logoutBtn1);
        layout2.setAlignment(Pos.CENTER);
        layout2.setPadding(new Insets(10, 10, 10, 10));
        voterRegScene = new Scene(layout2, 950, 700);


        //ADMINISTRATOR REGISTRATION SCENE
        //Labels
        Label adminSceneTitle = new Label("Administrator Registration");
        adminSceneTitle.setFont(new Font("Arial", 25));
        Label adminFNameLabel = new Label("Enter First Name");
        Label adminLNameLabel = new Label("Enter last Name");
        Label adminSSNLabel = new Label("Enter SSN");
        //Text Fields
        TextField adminFNTextField = new TextField();
        TextField adminLNTextField = new TextField();
        TextField adminSSNTextField = new TextField();
        //Buttons & Button Actions
        Button regAdmin = new Button("Register");
        regAdmin.setOnAction(e ->{
            Database.registerAdministrator(adminSSNTextField.getText(), adminFNTextField.getText(), adminLNTextField.getText());
            adminFNTextField.clear();
            adminLNTextField.clear();
            adminSSNTextField.clear();
        });
        Button adminGoBack = new Button("Go Back");
        adminGoBack.setOnAction(e -> administratorStage.setScene(OptionsScene));
        Button adminLogoutBtn = new Button("Log out");
        adminLogoutBtn.setOnMouseClicked(e -> {
            administratorStage.setScene(LoginWindow.getScene(administratorStage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });
        //Layout
        VBox adminLayout = new VBox(20, adminSceneTitle, adminFNameLabel, adminFNTextField, 
        adminLNameLabel, adminLNTextField, adminSSNLabel, adminSSNTextField, regAdmin, adminGoBack, adminLogoutBtn);
        adminLayout.setAlignment(Pos.CENTER);
        adminLayout.setPadding(new Insets(10, 10, 10, 10));
        adminRegScene = new Scene(adminLayout, 950, 700);

        //POLLWORKER REGISTRATION SCENE
        //Labels
        Label pollworkerSceneTitle = new Label("Poll Worker Registration");
        pollworkerSceneTitle.setFont(new Font("Arial", 25));
        Label pollworkerFNameLabel = new Label("Enter First Name");
        Label pollworkerLNameLabel = new Label("Enter last Name");
        Label pollworkerSSNLabel = new Label("Enter SSN");
        //Text Fields
        TextField pollworkerFNTextField = new TextField();
        TextField pollworkerLNTextField = new TextField();
        TextField pollworkerSSNTextField = new TextField();
        //Buttons & Button Actions
        Button regPollworker = new Button("Register");
        regPollworker.setOnAction(e ->{
            Database.registerPollWorker(pollworkerSSNTextField.getText(), pollworkerFNTextField.getText(), pollworkerLNTextField.getText());
            pollworkerFNTextField.clear();
            pollworkerLNTextField.clear();
            pollworkerSSNTextField.clear();
        });
        Button pollworkerGoBack = new Button("Go Back");
        pollworkerGoBack.setOnAction(e -> administratorStage.setScene(OptionsScene));
        Button pollworkerLogoutBtn = new Button("Log out");
        pollworkerLogoutBtn.setOnMouseClicked(e -> {
            administratorStage.setScene(LoginWindow.getScene(administratorStage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });
        //Layout
        VBox pollworkerLayout = new VBox(20, pollworkerSceneTitle, pollworkerFNameLabel, pollworkerFNTextField, 
        pollworkerLNameLabel, pollworkerLNTextField, pollworkerSSNLabel, pollworkerSSNTextField, 
        regPollworker, pollworkerGoBack, pollworkerLogoutBtn);
        pollworkerLayout.setAlignment(Pos.CENTER);
        pollworkerLayout.setPadding(new Insets(10, 10, 10, 10));
        pollworkerRegScene = new Scene(pollworkerLayout, 950, 700);


        //CANDIDATE REGISTRATION SCENE
        //Labels
        Label candidateSceneTitle = new Label("Candidate Registration");
        candidateSceneTitle.setFont(new Font("Arial", 25));
        Label candidateFNameLabel = new Label("Enter First Name");
        Label candidateLNameLabel = new Label("Enter last Name");
        Label candidatePartyLabel = new Label("Enter Party");
        Label candidatePosLabel = new Label("Enter Position");
        Label candidateRMLabel  = new Label("Enter Running Mate");
        //Text Fields
        TextField candidateFNTextField = new TextField();
        TextField candidateLNTextField = new TextField();
        TextField candidatePartyTextField = new TextField();
        TextField candidatePosTextField = new TextField();
        TextField candidateRMTextField = new TextField();
        //Buttons & Button Actions
        Button regCandidate = new Button("Register");
        regCandidate.setOnAction(e ->{
            Database.registerCandidate(candidateFNTextField.getText(), candidateLNTextField.getText(), 
            candidatePartyTextField.getText(), candidatePosTextField.getText(), candidateRMTextField.getText(), "0");
            candidateFNTextField.clear();
            candidateLNTextField.clear();
            candidatePartyTextField.clear();
            candidatePosTextField.clear();
            candidateRMTextField.clear();
        });
        Button candidateGoBack = new Button("Go Back");
        candidateGoBack.setOnAction(e -> administratorStage.setScene(OptionsScene));
        Button candidateLogoutBtn = new Button("Log out");
        candidateLogoutBtn.setOnMouseClicked(e -> {
            administratorStage.setScene(LoginWindow.getScene(administratorStage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });
        //Layout
        VBox candidateLayout = new VBox(20, candidateSceneTitle, candidateFNameLabel, candidateFNTextField, 
        candidateLNameLabel, candidateLNTextField, candidatePartyLabel, candidatePartyTextField, 
        candidatePosLabel, candidatePosTextField, candidateRMLabel, candidateRMTextField, regCandidate, 
        candidateGoBack, candidateLogoutBtn);
        candidateLayout.setAlignment(Pos.CENTER);
        candidateLayout.setPadding(new Insets(10, 10, 10, 10));
        candidateRegScene = new Scene(candidateLayout, 950, 700);

        //ELECTORATE REGISTRATION
        //Labels
        Label electorateSceneTitle = new Label("Electorate Registration");
        electorateSceneTitle.setFont(new Font("Arial", 25));
        Label electorateFNameLabel = new Label("Enter First Name");
        Label electorateLNameLabel = new Label("Enter last Name");
        Label electorateStateLabel = new Label("Enter State");
        Label electorateSSNLabel = new Label("Enter SSN");
        //Text Fields
        TextField electorateFNTextField = new TextField();
        TextField electorateLNTextField = new TextField();
        TextField electorateStateTextField = new TextField();
        TextField electorateSSNTextField = new TextField();
        //Buttons & Button Actions
        Button regElectorate = new Button("Register");
        regElectorate.setOnAction(e ->{
            Database.registerElector(electorateSSNTextField.getText(), electorateStateTextField.getText(), 
            electorateFNTextField.getText(), electorateLNTextField.getText());
            electorateFNTextField.clear();
            electorateLNTextField.clear();
            electorateStateTextField.clear();
            electorateSSNTextField.clear();
        });
        Button electorateGoBack = new Button("Go Back");
        electorateGoBack.setOnAction(e -> administratorStage.setScene(OptionsScene));
        Button electorateLogoutBtn = new Button("Log out");
        electorateLogoutBtn.setOnMouseClicked(e -> {
            administratorStage.setScene(LoginWindow.getScene(administratorStage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });
        //Layout
        VBox electorateLayout = new VBox(20, electorateSceneTitle, electorateFNameLabel, electorateFNTextField, electorateLNameLabel, electorateLNTextField, 
        electorateStateLabel, electorateStateTextField, electorateSSNLabel, electorateSSNTextField, regElectorate, electorateGoBack, electorateLogoutBtn);
        electorateLayout.setAlignment(Pos.CENTER);
        electorateLayout.setPadding(new Insets(10, 10, 10, 10));
        elecRegScene = new Scene(electorateLayout, 950, 700);

        //DISPLAY CANDIDATE DATABASE
        ArrayList<String[]> candidateVal = Database.getAllCandidates();
        Iterator<String[]> j = candidateVal.iterator();
        //Labels
        Label cdLabel = new Label("Candidate Database");
        cdLabel.setFont(new Font("Arial", 25));
        Label cdWarning = new Label("MUST LOG OUT AND LOG BACK IN FOR DISPLAY TO UPDATE");
        //Text Fields
        //Buttons & Button Actions
        Button goBack2 = new Button("Go Back");
        goBack2.setOnAction(e -> administratorStage.setScene(OptionsScene));  
        Button logoutBtn2 = new Button("Log out");
        logoutBtn2.setOnMouseClicked(e -> {
            administratorStage.setScene(LoginWindow.getScene(administratorStage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });
        //Layout

        VBox layout3 = new VBox(20);
        Label cvfName, cvlName, cvparty, cvposition, cvRMate, cvotes;
        layout3.getChildren().addAll(cdLabel, cdWarning);

        while(j.hasNext()) {
            String[] candidate = j.next();
            if(candidate.length == 5){
                cvfName = new Label("First Name: " + candidate[0]);
                cvlName = new Label("Last Name: " + candidate[1]);
                cvparty = new Label("Party: " + candidate[2]);
                cvposition = new Label ("Position: " + candidate[3]);
                cvotes = new Label ("Votes: " + candidate[4]);
                layout3.getChildren().add(new HBox(20, cvfName, cvlName, 
                cvparty, cvposition, cvotes)); 
                
                HBox cTemp = new HBox(20, cvfName, cvlName, cvparty, cvposition, cvotes);
                cTemp.setAlignment(Pos.CENTER);
                layout3.getChildren().add(cTemp);
            }

            else{
                cvfName = new Label("First Name: " + candidate[0]);
                cvlName = new Label("Last Name: " + candidate[1]);
                cvparty = new Label("Party: " + candidate[2]);
                cvposition = new Label ("Position: " + candidate[3]);
                cvRMate = new Label ("Running Mate: " + candidate[5]);
                cvotes = new Label ("Votes: " + candidate[4]);
                layout3.getChildren().add(new HBox(20, cvfName, cvlName, 
                cvparty, cvposition, cvRMate)); 

                HBox cTemp = new HBox(20, cvfName, cvlName, cvparty, cvposition, cvRMate, cvotes);
                cTemp.setAlignment(Pos.CENTER);
                layout3.getChildren().add(cTemp);

            }
            
            
        }

        layout3.getChildren().addAll(goBack2, logoutBtn2);
        layout3.setAlignment(Pos.CENTER);
        layout3.setPadding(new Insets(10, 10, 10, 10));
        ValScene = new Scene(layout3, 950, 700);

        //DISPLAY VOTER DATABASE SCENE
        ArrayList<String[]> voters = Database.getAllVoterInformation();
        Iterator<String[]> i = voters.iterator();
        //Labels
        Label vdLabel = new Label("Voter Database");
        vdLabel.setFont(new Font("Arial", 25));
        Label vdWarning = new Label("MUST LOG OUT AND LOG BACK IN FOR DISPLAY TO UPDATE");
        //TextFields
        //Buttons & Button Actions
        Button voterDBgoBack = new Button("Go Back");
        voterDBgoBack.setOnAction(e1 -> administratorStage.setScene(OptionsScene));
        Button voterDBlogoutBtn = new Button("Log out");
        voterDBlogoutBtn.setOnMouseClicked(e2 -> {
            administratorStage.setScene(LoginWindow.getScene(administratorStage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });
        //Layout

        VBox voterDBLayout = new VBox(20);
        Label vfName, vlName, age, state, vSSN;
        voterDBLayout.getChildren().addAll(vdLabel, vdWarning);

        while(i.hasNext()) {
            String[] voter = i.next();
            vSSN = new Label("SSN: " + voter[0]);  //did not know if this should be displayed as this should be private information.
            vfName = new Label("First Name: " + voter[1]);
            vlName = new Label("Last Name: " + voter[2]);
            age = new Label("Age: " + voter[3]);
            state = new Label("State: " + voter[4]);

            HBox vTemp = new HBox(20, vfName, vlName, age, state, vSSN);
            vTemp.setAlignment(Pos.CENTER);
            voterDBLayout.getChildren().add(vTemp);
            
        }

        voterDBLayout.getChildren().addAll(voterDBgoBack, voterDBlogoutBtn);
        voterDBLayout.setAlignment(Pos.CENTER);
        voterDBLayout.setPadding(new Insets(10, 10, 10, 10));
        VoterDBScene = new Scene(voterDBLayout, 950, 700);
        
        /*
        //DISPLAY CANDIDATE DATABASE SCENE
        ArrayList<String[]> candidates = Database.getAllCandidates();
        Iterator<String[]> k = candidates.iterator();
        //TextFields
        //Buttons & Button Actions
        Button candidateDBgoBack = new Button("Go Back");
        candidateDBgoBack.setOnAction(e1 -> administratorStage.setScene(OptionsScene));
        Button candidateDBlogoutBtn = new Button("Log out");
        candidateDBlogoutBtn.setOnMouseClicked(e2 -> {
            administratorStage.setScene(LoginWindow.getScene(administratorStage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });
        //Layout

        VBox layout5 = new VBox(20);
        Label cfName, clName, party, position, rMate;

        while(k.hasNext()) {
            String[] candidate = k.next();
            if(candidate.length == 5){
                cfName = new Label("First Name: " + candidate[0]);
                clName = new Label("Last Name: " + candidate[1]);
                party = new Label("Party: " + candidate[2]);
                position = new Label ("Position: " + candidate[3]);
                layout5.getChildren().add(new HBox(20, cfName, clName, 
                party, position)); 
                
                HBox cTemp = new HBox(20, cfName, clName, party, position);
                cTemp.setAlignment(Pos.CENTER);
                layout5.getChildren().add(cTemp);
            }

            else{
                cfName = new Label("First Name: " + candidate[0]);
                clName = new Label("Last Name: " + candidate[1]);
                party = new Label("Party: " + candidate[2]);
                position = new Label ("Position: " + candidate[3]);
                rMate = new Label ("Running Mate: " + candidate[5]);
                layout5.getChildren().add(new HBox(20, cfName, clName, 
                party, position, rMate)); 

                HBox cTemp = new HBox(20, cfName, clName, party, position, rMate);
                cTemp.setAlignment(Pos.CENTER);
                layout5.getChildren().add(cTemp);

            }
            
            
        }

        layout5.getChildren().addAll(candidateDBgoBack, candidateDBlogoutBtn);
        layout5.setAlignment(Pos.CENTER);
        layout5.setPadding(new Insets(10, 10, 10, 10));
        CandidateDBScene = new Scene(layout5, 950, 700);*/

     
        //DISPLAY CANDIDATE RESULTS SCENE - (if questions, ask Daniel)
      
        CandidateResultsDisplay candidateResultsDisplay = new CandidateResultsDisplay();
        candidateResultsDisplay.showResults();
        candidateResultsDisplay.enableGoBack(administratorStage, OptionsScene);
        candidateResultsDisplay.setAlignment(Pos.CENTER);
        candidateResultsDisplay.setPadding(new Insets(10, 10, 10, 10));
        CandidateDRScene = new Scene(candidateResultsDisplay, 950, 700);
    

        /*Option scene button actions.
          Had to put these down here for some reason. 
          Wouldn't work when placed with the buttons on the Options scene class.
          Also couldn't put the rest of the Options scene statements down here.
        */
        
        
        
        
         
           
        btn1.setOnAction(e -> administratorStage.setScene(voterRegScene));
        btn5.setOnAction(e -> administratorStage.setScene(adminRegScene));
        btn6.setOnAction(e -> administratorStage.setScene(pollworkerRegScene));
        btn7.setOnAction(e -> administratorStage.setScene(candidateRegScene));
        btn9.setOnAction(e -> administratorStage.setScene(elecRegScene));
        btn2.setOnAction(e -> administratorStage.setScene(ValScene));
        btn3.setOnAction(e -> administratorStage.setScene(VoterDBScene));
        //btn4.setOnAction(e -> administratorStage.setScene(CandidateDBScene));
        btn8.setOnAction(e -> administratorStage.setScene(CandidateDRScene));
        return OptionsScene;
    }

}
