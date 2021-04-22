import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ElectorateHandler extends Application {  
    
    @Override
    public void start(Stage stage) throws Exception {
        // Ignore this
    }


    public static Scene getScene(Stage stage) {
        Scene resultsScene;

        CandidateResultsDisplay display = new CandidateResultsDisplay();
        display.showResults();
        display.enableLogOut(stage);
        //display.enableAnnounce(stage);
        display.setAlignment(Pos.CENTER);
        display.setPadding(new Insets(10, 10, 10, 10));
        resultsScene = new Scene(display, 950, 700);

        return resultsScene;
    }
}
