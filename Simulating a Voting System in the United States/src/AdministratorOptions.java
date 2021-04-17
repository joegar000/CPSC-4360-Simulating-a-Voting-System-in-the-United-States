/* This class will contain the method for setting the JavaFX scene to the administrator options
   I (David) have tested setting JavaFX scenes this way and it works */

/*
TODO:

Fix errors
implement code for different scenes 
*/
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

   
public class AdministratorOptions extends Application {
    
    

    
    @Override
    public void start(Stage administratorStage) throws Exception {
        // Ignore this
    }


    public static Scene getScene(Stage administratorStage) {

        Scene OptionsScene,  RegScene, ValScene, VoterDBScene, CandidateDBScene;
        
        //OPTIONS SCENE
        Label label1 = new Label("Administrator Options");
        label1.setFont(new Font("Arial", 25));
        Button btn1 = new Button("Register Voter");
        Button btn2 = new Button("Validate Votes");
        Button btn3 = new Button("Display Voter Database");
        Button btn4 = new Button("Display Candidate Database");


        VBox layout1 = new VBox(20, label1, btn1, btn2, btn3, btn4);
        layout1.setAlignment(Pos.CENTER);
        OptionsScene = new Scene(layout1, 320, 240);
        
        //REGISTRATION SCENE
        Label label2 = new Label("This is where the voter registration scene will appear");
        Button btn5 = new Button("Go Back");
        btn5.setOnAction(e -> administratorStage.setScene(OptionsScene));
        VBox layout2 = new VBox(20, label2, btn5);
        layout2.setAlignment(Pos.CENTER);
        RegScene = new Scene(layout2, 320, 240);

        //VALIDATIONS SCENE
        Label label3 = new Label("This is where the validate votes scene will appear");
        Button btn6 = new Button("Go Back");
        btn6.setOnAction(e -> administratorStage.setScene(OptionsScene));
        VBox layout3 = new VBox(20, label3, btn6);
        layout3.setAlignment(Pos.CENTER);
        ValScene = new Scene(layout3, 320, 240);

        //DISPLAY VOTER DATABASE SCENE
        Label label4 = new Label("This is where the voter database scene will appear");
        Button btn7 = new Button("Go Back");
        btn7.setOnAction(e -> administratorStage.setScene(OptionsScene));
        VBox layout4 = new VBox(20, label4, btn7);
        layout4.setAlignment(Pos.CENTER);
        VoterDBScene = new Scene(layout4, 320, 240);

        //DISPLAY CANDIDATE DATABASE SCENE
        Label label5 = new Label("This is where the voter registration scene will appear");
        Button btn8 = new Button("Go Back");
        btn8.setOnAction(e -> administratorStage.setScene(OptionsScene));
        VBox layout5 = new VBox(20, label5, btn8);
        layout5.setAlignment(Pos.CENTER);
        CandidateDBScene = new Scene(layout5, 320, 240);

        
        
        
        //button actions
        
        btn1.setOnAction(e -> administratorStage.setScene(RegScene));
        btn2.setOnAction(e -> administratorStage.setScene(ValScene));
        btn3.setOnAction(e -> administratorStage.setScene(VoterDBScene));
        btn4.setOnAction(e -> administratorStage.setScene(CandidateDBScene));      
        
        

        return OptionsScene;
    }

}
