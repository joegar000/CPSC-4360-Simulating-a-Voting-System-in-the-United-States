
import javax.lang.model.util.ElementScanner6;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

class CandidateResultsDisplay extends VBox {
    Label label1 = new Label("Candidate Results Display");
    Button logoutBtn = new Button("Log out");

    public String[] partys = { "Democrat", "Republican", "Independent"};

    /* constructor */
    public CandidateResultsDisplay() {
        this.setTranslateX(0); // change later

        label1.setFont(new Font("Arial", 25));
    }

    /* for when we need to go back (Admin) */
    public void enableGoBack(Stage stage, Scene scene) {
        Button goBack = new Button("Go Back");
        goBack.setOnAction(e -> stage.setScene(scene));
        this.getChildren().add(goBack);
    }

    /* for when we need to log out (Press and Electorate)*/
    public void enableLogOut(Stage stage)  {
        Button logoutBtn4 = new Button("Log out");
        logoutBtn4.setOnMouseClicked(e -> {
            stage.setScene(LoginWindow.getScene(stage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });
        this.getChildren().add(logoutBtn);
    };

    /* to be called wherever this Display is used */
    public void showResults() {
        int totalVotes = getNumAllCurrentVotes();
        for (int i = 0; i < partys.length; i++) {
            String[] tempCandidate = Database.getCandidate(partys[i]);
            int votes = Integer.parseInt(tempCandidate[3]);
            double result;
            if (votes!=0)
                result = Integer.parseInt(tempCandidate[3])/totalVotes;
            else 
                result = 0;
            CandidateResult candLabel = new CandidateResult(tempCandidate[0],tempCandidate[1],tempCandidate[2],result);
            this.getChildren().add(candLabel);
        }
        
    }

    /* to get all of the current Votes */
    public int getNumAllCurrentVotes(){
        int votes = 0;
        for (int i = 0; i < partys.length; i++) {
            String[] tempCandidate = Database.getCandidate(partys[i]);
            int candidateVotes = Integer.parseInt(tempCandidate[3]);
            votes+=candidateVotes;
        }
        return votes;
    }

    public class CandidateResult extends Label {
        public CandidateResult(String firstName, String lastName, String party, double result) {
            this.setText(firstName + " " + lastName + " Party: " + party + " Resulting Percentage: " + result);
        }
    }

    
}