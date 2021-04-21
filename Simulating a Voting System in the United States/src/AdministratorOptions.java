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
        Scene OptionsScene, voterRegScene, adminRegScene, pollworkerRegScene, candidateRegScene, ValScene, VoterDBScene, CandidateDBScene;

        //OPTIONS SCENE
        //Labels
        Label label1 = new Label("Administrator Options");
        label1.setFont(new Font("Arial", 25));
        //TextFields
        //Buttons & Button Actions
        Button btn1 = new Button("Voter Registration");
        Button btn2 = new Button("Validate Votes");
        Button btn3 = new Button("Display Voter Database");
        Button btn4 = new Button("Display Candidate Database");
        Button btn5 = new Button("Administrator Registration");
        Button btn6 = new Button("Pollworker Registration");
        Button btn7 = new Button("Candidate Registration");
        Button logoutBtn = new Button("Log out");
        logoutBtn.setOnMouseClicked(e -> {
            administratorStage.setScene(LoginWindow.getScene(administratorStage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });

        //Layout
        VBox layout1 = new VBox(20, label1, btn1, btn5, btn6, btn7, btn2, btn3, btn4, logoutBtn);
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
            Database.registerAdministrator(adminFNTextField.getText(), adminLNTextField.getText(), adminSSNTextField.getText());
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
            Database.registerPollWorker(pollworkerFNTextField.getText(), pollworkerLNTextField.getText(), pollworkerSSNTextField.getText());
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
        //Text Fields
        TextField candidateFNTextField = new TextField();
        TextField candidateLNTextField = new TextField();
        TextField candidatePartyTextField = new TextField();
        //Buttons & Button Actions
        Button regCandidate = new Button("Register");
        regCandidate.setOnAction(e ->{
            Database.registerCandidate(candidateFNTextField.getText(), candidateLNTextField.getText(), 
            candidatePartyTextField.getText(), 0);
            candidateFNTextField.clear();
            candidateLNTextField.clear();
            candidatePartyTextField.clear();
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
        regCandidate, candidateGoBack, candidateLogoutBtn);
        candidateLayout.setAlignment(Pos.CENTER);
        candidateLayout.setPadding(new Insets(10, 10, 10, 10));
        candidateRegScene = new Scene(candidateLayout, 950, 700);

        //VALIDATIONS SCENE
        //Labels
        Label label3 = new Label("This is where the validate votes scene will appear");
        //Text Fields
        //Buttons & Button Actions
        Button validateBtn = new Button("Validate Vote");
        Button goBack2 = new Button("Go Back");
        goBack2.setOnAction(e -> administratorStage.setScene(OptionsScene));  //does nothing right now
        Button logoutBtn2 = new Button("Log out");
        logoutBtn2.setOnMouseClicked(e -> {
            administratorStage.setScene(LoginWindow.getScene(administratorStage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });
        //Layout
        VBox layout3 = new VBox(20, label3, validateBtn, goBack2, logoutBtn2);
        layout3.setAlignment(Pos.CENTER);
        layout3.setPadding(new Insets(10, 10, 10, 10));
        ValScene = new Scene(layout3, 950, 700);

        //DISPLAY VOTER DATABASE SCENE
        //Labels
        Label label4 = new Label("This is where the voter database scene will appear");
        //Text Fields
        //Buttons & Button Actions
        Button goBack3 = new Button("Go Back");
        goBack3.setOnAction(e -> administratorStage.setScene(OptionsScene));
        Button logoutBtn3 = new Button("Log out");
        logoutBtn3.setOnMouseClicked(e -> {
            administratorStage.setScene(LoginWindow.getScene(administratorStage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });
        //Layout
        VBox layout4 = new VBox(20, label4, goBack3, logoutBtn3);
        layout4.setAlignment(Pos.CENTER);
        layout4.setPadding(new Insets(10, 10, 10, 10));
        VoterDBScene = new Scene(layout4, 950, 700);

        //DISPLAY CANDIDATE DATABASE SCENE
        ArrayList<String[]> candidates = Database.getAllCandidates();
        Iterator<String[]> i = candidates.iterator();
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

        VBox layout5 = new VBox(20, candidateDBgoBack, candidateDBlogoutBtn);
        Label fName, lName, party;

        while(i.hasNext()) {
            String[] candidate = i.next();
            fName = new Label("First Name: " + candidate[0]);
            lName = new Label("Last Name: " + candidate[1]);
            party = new Label("Party: " + candidate[2]);
            layout5.getChildren().add(new HBox(20, fName, lName, party));
        }

        layout5.setAlignment(Pos.CENTER);
        layout5.setPadding(new Insets(10, 10, 10, 10));
        CandidateDBScene = new Scene(layout5, 950, 700);

        /*Option scene button actions.
          Had to put these down here for some reason. 
          Wouldn't work when placed with the buttons on the Options scene class.
          Also couldn't put the rest of the Options scene statements down here.
        */
        btn1.setOnAction(e -> administratorStage.setScene(voterRegScene));
        btn5.setOnAction(e -> administratorStage.setScene(adminRegScene));
        btn6.setOnAction(e -> administratorStage.setScene(pollworkerRegScene));
        btn7.setOnAction(e -> administratorStage.setScene(candidateRegScene));
        btn2.setOnAction(e -> administratorStage.setScene(ValScene));
        btn3.setOnAction(e -> administratorStage.setScene(VoterDBScene));
        btn4.setOnAction(e -> administratorStage.setScene(CandidateDBScene));      
        
        

        return OptionsScene;
    }

}
