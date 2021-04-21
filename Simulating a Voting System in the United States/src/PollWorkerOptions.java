/* This class will contain the method for setting the JavaFX scene to the poll worker options
   I (David) have tested setting JavaFX scenes this way and it works */

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

public class PollWorkerOptions extends Application {

    private static Scene scene;

    
    @Override
    public void start(Stage pollWorkerStage) throws Exception {
        // Ignore this
    }


    public static Scene getScene(Stage pollWorkerStage) {
        //Scenes initialized
        Scene OptionsScene,  RegScene, InfoScene, CandidateDBScene;

        //OPTIONS SCENE
        //Labels
        Label label1 = new Label("Poll Worker Options");
        label1.setFont(new Font("Arial", 25));
        //TextFields
        //Buttons & Button Actions
        Button btn1 = new Button("Register Voter");
        Button btn2 = new Button("Display Voter Information");
        Button btn3 = new Button("Display Candidate Database");
        Button logoutBtn = new Button("Log out");
        logoutBtn.setOnMouseClicked(e -> {
            pollWorkerStage.setScene(LoginWindow.getScene(pollWorkerStage));
            LoginWindow.password.clear();
        });

        //Layout
        VBox layout1 = new VBox(20, label1, btn1, btn2, btn3, logoutBtn);
        layout1.setAlignment(Pos.CENTER);
        layout1.setPadding(new Insets(10, 10, 10, 10));
        OptionsScene = new Scene(layout1, 950, 700);
        
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
        // Add to database


        Button goBack1 = new Button("Go Back");
        goBack1.setOnAction(e -> pollWorkerStage.setScene(OptionsScene));
        Button logoutBtn1 = new Button("Log out");
        logoutBtn1.setOnMouseClicked(e -> {
            pollWorkerStage.setScene(LoginWindow.getScene(pollWorkerStage));
            LoginWindow.password.clear();
        });
        //Layout
        VBox layout2 = new VBox(20, regSceneTitle, firstNameLabel, fnTextField, lastNameLabel, 
        lnTextField, ageLabel, ageTextField, stateLabel, stateTextField, ssnLabel, 
        ssnTextField, regVoter, goBack1, logoutBtn1);
        layout2.setAlignment(Pos.CENTER);
        layout2.setPadding(new Insets(10, 10, 10, 10));
        RegScene = new Scene(layout2, 950, 700);


        //DISPLAY VOTER INFORMATION SCENE
        //Labels
        Label label4 = new Label("This is where the voter information scene will appear");
        //Text Fields
        //Buttons & Button Actions
        Button goBack3 = new Button("Go Back");
        goBack3.setOnAction(e -> pollWorkerStage.setScene(OptionsScene));
        Button logoutBtn3 = new Button("Log out");
        logoutBtn3.setOnMouseClicked(e -> {
            pollWorkerStage.setScene(LoginWindow.getScene(pollWorkerStage));
            LoginWindow.password.clear();
        });
        //Layout
        VBox layout4 = new VBox(20, label4, goBack3, logoutBtn3);
        layout4.setAlignment(Pos.CENTER);
        layout4.setPadding(new Insets(10, 10, 10, 10));
        InfoScene = new Scene(layout4, 950, 700);



        //DISPLAY CANDIDATE DATABASE SCENE
        //Labels
        Label label5 = new Label("This is where the voter registration scene will appear");
        //TextFields
        //Buttons & Button Actions
        Button goBack4 = new Button("Go Back");
        goBack4.setOnAction(e -> pollWorkerStage.setScene(OptionsScene));
        Button logoutBtn4 = new Button("Log out");
        logoutBtn4.setOnMouseClicked(e -> {
            pollWorkerStage.setScene(LoginWindow.getScene(pollWorkerStage));
            LoginWindow.password.clear();
        });
        //Layout
        VBox layout5 = new VBox(20, label5, goBack4, logoutBtn4);
        layout5.setAlignment(Pos.CENTER);
        layout5.setPadding(new Insets(10, 10, 10, 10));
        CandidateDBScene = new Scene(layout5, 950, 700);

        /*
          Option scene button actions.
          Had to put these down here for some reason. 
          Wouldn't work when placed with the buttons on the Options scene class.
          Also couldn't put the rest of the Options scene statements down here.
        */
        btn1.setOnAction(e -> pollWorkerStage.setScene(RegScene));
        btn2.setOnAction(e -> pollWorkerStage.setScene(InfoScene));
        btn3.setOnAction(e -> pollWorkerStage.setScene(CandidateDBScene));
        
        

        return OptionsScene;
    }
}
