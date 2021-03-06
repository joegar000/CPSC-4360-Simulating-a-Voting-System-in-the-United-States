import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PollWorkerOptions extends Application {
    
    @Override
    public void start(Stage pollWorkerStage) throws Exception {
    }


    public static Scene getScene(Stage pollWorkerStage) {
        //Scenes initialized
        Scene OptionsScene,  RegScene, InfoScene, CandidateDBScene;

        // OPTIONS SCENE
        // Labels
        Label label1 = new Label("Poll Worker Options");
        label1.setFont(new Font("Arial", 25));

        // Buttons & Button Actions
        Button btn1 = new Button("Register Voter");
        Button btn2 = new Button("Display Voter Information");
        Button btn3 = new Button("Display Candidate Database");
        Button logoutBtn = new Button("Log out");
        logoutBtn.setOnMouseClicked(e -> {
            pollWorkerStage.setScene(LoginWindow.getScene(pollWorkerStage));
            LoginWindow.password.clear();
        });

        // Set the layout
        VBox layout1 = new VBox(20, label1, btn1, btn2, btn3, logoutBtn);
        layout1.setAlignment(Pos.CENTER);
        layout1.setPadding(new Insets(10, 10, 10, 10));
        OptionsScene = new Scene(layout1, 950, 700);
        


        // REGISTRATION SCENE

        // Labels
        Label regSceneTitle = new Label("Voter Registration");
        regSceneTitle.setFont(new Font("Arial", 25));
        Label firstNameLabel = new Label("Enter First Name");
        Label lastNameLabel = new Label("Enter last Name");
        Label ageLabel = new Label("Enter Age");
        Label stateLabel = new Label("Enter State");
        Label ssnLabel = new Label("Enter SSN");

        // Text Fields
        TextField fnTextField = new TextField();
        TextField lnTextField = new TextField();
        TextField ageTextField = new TextField();
        TextField stateTextField = new TextField();
        TextField ssnTextField = new TextField();

        // Buttons & Button Actions
        Button regVoter = new Button("Register");
        regVoter.setOnAction(e -> {
            // The false is because a voter that just registered cannot have already voted
            Database.registerVoter(ssnTextField.getText(), fnTextField.getText(), lnTextField.getText(), ageTextField.getText(), stateTextField.getText(), false);
            ssnTextField.clear();
            fnTextField.clear();
            lnTextField.clear();
            ageTextField.clear();
            stateTextField.clear();
        });
        Button goBack1 = new Button("Go Back");
        goBack1.setOnAction(e -> {
            pollWorkerStage.setScene(OptionsScene);
        });
        Button logoutBtn1 = new Button("Log out");
        logoutBtn1.setOnMouseClicked(e -> {
            pollWorkerStage.setScene(LoginWindow.getScene(pollWorkerStage));
            LoginWindow.password.clear();
        });

        // Set the Layout
        VBox layout2 = new VBox(20, regSceneTitle, firstNameLabel, fnTextField, lastNameLabel, 
        lnTextField, ageLabel, ageTextField, stateLabel, stateTextField, ssnLabel, 
        ssnTextField, regVoter, goBack1, logoutBtn1);
        layout2.setAlignment(Pos.CENTER);
        layout2.setPadding(new Insets(10, 10, 10, 10));
        RegScene = new Scene(layout2, 950, 700);



        // DISPLAY VOTER INFORMATION SCENE

        // Labels
        Label label4 = new Label("Please enter the voter's SSN");

        // Text Fields
        TextField voterSSN = new TextField();

        // Buttons & Button Actions
        Button goBack5 = new Button("Go Back");
        Button getInformation = new Button("Get Voter Information");
        Button goBack3 = new Button("Go Back");
        goBack3.setOnAction(e -> pollWorkerStage.setScene(OptionsScene));
        Button logoutBtn3 = new Button("Log out");
        logoutBtn3.setOnMouseClicked(e -> {
            pollWorkerStage.setScene(LoginWindow.getScene(pollWorkerStage));
            LoginWindow.password.clear();
        });
        getInformation.setOnAction(e -> {
            String[] info = Database.getVoterInformation(voterSSN.getText());
            Label firstName = new Label("First Name: " + info[1]);
            Label lastName = new Label("Last Name: " + info[2]);
            Label age = new Label("Age: " + info[3]);
            Label state = new Label("State: " + info[4]);

            HBox layout6 = new HBox(20, firstName, lastName, age, state);
            layout6.setAlignment(Pos.CENTER);
            VBox layout7 = new VBox(20, layout6, goBack5);
            layout7.setAlignment(Pos.CENTER);
            layout7.setPadding(new Insets(10, 10, 10, 10));
            voterSSN.clear();
            Scene InfoDisplayScene = new Scene(layout7, 950, 700);
            pollWorkerStage.setScene(InfoDisplayScene);
        });

        // Layout
        VBox layout4 = new VBox(20, label4, voterSSN, getInformation, goBack3, logoutBtn3);
        layout4.setAlignment(Pos.CENTER);
        layout4.setPadding(new Insets(10, 10, 10, 10));
        InfoScene = new Scene(layout4, 950, 700);

        goBack5.setOnAction(e -> {
            pollWorkerStage.setScene(InfoScene);
        });



        // DISPLAY CANDIDATE DATABASE SCENE
        // Labels

        // ArrayList and iterator to go through all of the candidates in the database
        ArrayList<String[]> candidates = Database.getAllCandidates();
        Iterator<String[]> i = candidates.iterator();

        //Buttons & Button Actions
        Button goBack4 = new Button("Go Back");
        goBack4.setOnAction(e1 -> pollWorkerStage.setScene(OptionsScene));
        Button logoutBtn4 = new Button("Log out");
        logoutBtn4.setOnMouseClicked(e2 -> {
            pollWorkerStage.setScene(LoginWindow.getScene(pollWorkerStage));
            LoginWindow.password.clear();
        });


        VBox layout5 = new VBox(20);
        Label Name, party, position, runningMate;
        // Iterate through all of the candidates and add them to the VBox layout5
        while(i.hasNext()) {
            String[] candidate = i.next();
            if (candidate.length == 6) {
                Name = new Label("Name: " + candidate[0] + " " + candidate[1]);
                party = new Label("Party: " + candidate[2]);
                position = new Label("Position: " + candidate[3]);
                runningMate = new Label("Running Mate: " + candidate[5]);
                HBox temp = new HBox(20, Name, party, position, runningMate);
                temp.setAlignment(Pos.CENTER);
                layout5.getChildren().add(temp);
            }
            
            else {
                Name = new Label("Name: " + candidate[0] + " " + candidate[1]);
                party = new Label("Party: " + candidate[2]);
                position = new Label("Position: " + candidate[3]);
                HBox temp = new HBox(20, Name, party, position);
                temp.setAlignment(Pos.CENTER);
                layout5.getChildren().add(temp);
            }
        }

        // Format and add layout5 to the scene
        layout5.getChildren().addAll(goBack4, logoutBtn4);
        layout5.setAlignment(Pos.CENTER);
        layout5.setPadding(new Insets(250, 10, 10, 10));
        ScrollPane scrollBar = new ScrollPane();
        scrollBar.setContent(layout5);
        scrollBar.setFitToWidth(true);
        CandidateDBScene = new Scene(scrollBar, 950, 700);



        // Option scene button actions.
        btn1.setOnAction(e -> pollWorkerStage.setScene(RegScene));
        btn2.setOnAction(e -> pollWorkerStage.setScene(InfoScene));
        btn3.setOnAction(e -> pollWorkerStage.setScene(CandidateDBScene));
        
        

        return OptionsScene;
    }
}
