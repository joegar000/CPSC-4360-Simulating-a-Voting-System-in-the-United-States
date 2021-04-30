import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
    The PressHandler is used for the functionality of the UI. It extends Applicatoin and contains a getScene method. 
*/
public class PressHandler extends Application {  
    
    @Override
    public void start(Stage stage) throws Exception {
        
    }


    public static Scene getScene(Stage stage) {
        Scene resultsScene;

        CandidateResultsDisplay display = new CandidateResultsDisplay(); // contains the display VBox
        display.showResults(); // Enable results
        display.enableLogOut(stage); // Enable Logout button
        display.setAlignment(Pos.CENTER);
        display.setPadding(new Insets(10, 10, 10, 10));
        resultsScene = new Scene(display, 950, 700);

        return resultsScene;
    }
}
