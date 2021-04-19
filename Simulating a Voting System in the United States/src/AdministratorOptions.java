/* This class will contain the method for setting the JavaFX scene to the administrator options
   I (David) have tested setting JavaFX scenes this way and it works */

/*
TODO:

Fix errors
implement code for different scenes 
*/
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        Scene OptionsScene,  RegScene, ValScene, 
        VoterDBScene, CandidateDBScene;

        //OPTIONS SCENE
        //Labels
        Label label1 = new Label("Administrator Options");
        label1.setFont(new Font("Arial", 25));
        //TextFields
        //Buttons & Button Actions
        Button btn1 = new Button("Register Voter");
        Button btn2 = new Button("Validate Votes");
        Button btn3 = new Button("Display Voter Database");
        Button btn4 = new Button("Display Candidate Database");
        Button logoutBtn = new Button("Log out");
        logoutBtn.setOnMouseClicked(e -> administratorStage.close());

        //Layout
        VBox layout1 = new VBox(20, label1, btn1, btn2, btn3, btn4, logoutBtn);
        layout1.setAlignment(Pos.CENTER);
        layout1.setPadding(new Insets(10, 10, 10, 10));
        OptionsScene = new Scene(layout1, 400, 400);
        
        //REGISTRATION SCENE
        //Labels
        Label regSceneTitle = new Label("Voter Registration");
        regSceneTitle.setFont(new Font("Arial", 25));
        Label firstNameLabel = new Label("Enter First Name");
        Label lastNameLabel = new Label("Enter last Name");
        Label ageLabel = new Label("Enter Age");
        Label stateLabel = new Label("Enter State");
        Label ssnLabel = new Label("Enter SSN");
        //Text Fields
        TextField fnTextField = new TextField();
        TextField lnTextField = new TextField();
        TextField ageTextField = new TextField();
        TextField stateTextField = new TextField();
        TextField ssnTextField = new TextField();
        //Buttons & Button Actions
        Button regVoter = new Button("Register");    //does nothing right now
        Button goBack1 = new Button("Go Back");
        goBack1.setOnAction(e -> administratorStage.setScene(OptionsScene));
        Button logoutBtn1 = new Button("Log out");
        logoutBtn1.setOnMouseClicked(e -> administratorStage.close());
        //Layout
        VBox layout2 = new VBox(20, regSceneTitle, firstNameLabel, fnTextField, lastNameLabel, 
        lnTextField, ageLabel, ageTextField, stateLabel, stateTextField, ssnLabel, 
        ssnTextField, regVoter, goBack1, logoutBtn1);
        layout2.setAlignment(Pos.CENTER);
        layout2.setPadding(new Insets(10, 10, 10, 10));
        RegScene = new Scene(layout2, 600, 600);

        //VALIDATIONS SCENE
        //Labels
        Label label3 = new Label("This is where the validate votes scene will appear");
        //Text Fields
        //Buttons & Button Actions
        Button validateBtn = new Button("Validate Vote");
        Button goBack2 = new Button("Go Back");
        goBack2.setOnAction(e -> administratorStage.setScene(OptionsScene));  //does nothing right now
        Button logoutBtn2 = new Button("Log out");
        logoutBtn2.setOnMouseClicked(e -> administratorStage.close());
        //Layout
        VBox layout3 = new VBox(20, label3, validateBtn, goBack2, logoutBtn2);
        layout3.setAlignment(Pos.CENTER);
        layout3.setPadding(new Insets(10, 10, 10, 10));
        ValScene = new Scene(layout3, 320, 240);

        //DISPLAY VOTER DATABASE SCENE
        //Labels
        Label label4 = new Label("This is where the voter database scene will appear");
        //Text Fields
        //Buttons & Button Actions
        Button goBack3 = new Button("Go Back");
        goBack3.setOnAction(e -> administratorStage.setScene(OptionsScene));
        Button logoutBtn3 = new Button("Log out");
        logoutBtn3.setOnMouseClicked(e -> administratorStage.close());
        //Layout
        VBox layout4 = new VBox(20, label4, goBack3, logoutBtn3);
        layout4.setAlignment(Pos.CENTER);
        layout4.setPadding(new Insets(10, 10, 10, 10));
        VoterDBScene = new Scene(layout4, 320, 240);

        //DISPLAY CANDIDATE DATABASE SCENE
        //Labels
        Label label5 = new Label("This is where the voter registration scene will appear");
        //TextFields
        //Buttons & Button Actions
        Button goBack4 = new Button("Go Back");
        goBack4.setOnAction(e -> administratorStage.setScene(OptionsScene));
        //Layout
        VBox layout5 = new VBox(20, label5, goBack4, logoutBtn);
        layout5.setAlignment(Pos.CENTER);
        layout5.setPadding(new Insets(10, 10, 10, 10));
        CandidateDBScene = new Scene(layout5, 320, 240);

        /*Option scene button actions.
          Had to put these down here for some reason. 
          Wouldn't work when placed with the buttons on the Options scene class.
          Also couldn't put the rest of the Options scene statements down here.
        */
        btn1.setOnAction(e -> administratorStage.setScene(RegScene));
        btn2.setOnAction(e -> administratorStage.setScene(ValScene));
        btn3.setOnAction(e -> administratorStage.setScene(VoterDBScene));
        btn4.setOnAction(e -> administratorStage.setScene(CandidateDBScene));      
        
        

        return OptionsScene;
    }

}
