
import java.util.ArrayList;



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

    //public String[] partys = { "Democrat", "Republican", "Independent"};

    /* constructor */
    public CandidateResultsDisplay() {
        this.setTranslateX(0); // change later
        label1.setFont(new Font("Arial", 25));
        this.getChildren().add(label1);
    }

    /* for when we need to go back (Admin) */
    public void enableGoBack(Stage stage, Scene scene) {
        Button goBack = new Button("Go Back");
        goBack.setOnAction(e -> stage.setScene(scene));
        this.getChildren().add(goBack);
    }

    /* for when we need to log out (Press and Electorate)*/
    public void enableLogOut(Stage stage)  {
        logoutBtn.setOnMouseClicked(e -> {
            stage.setScene(LoginWindow.getScene(stage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
        });
        this.getChildren().add(logoutBtn);
    };

    public void enableAnnounce(Stage stage)  {
        Button logoutBtn4 = new Button("Annouce");
        logoutBtn4.setOnMouseClicked(e -> {
            stage.setScene(LoginWindow.getScene(stage));
            LoginWindow.firstName.clear();
            LoginWindow.lastName.clear();
            LoginWindow.SSN.clear();
            LoginWindow.password.clear();
            ArrayList<String[]> winner = getWinner();
            String container = "";
            if (winner.size()>1) {
                container+="There was a tie between ";
                for (int i = 0; i < winner.size(); i++) {
                    if (i==0)
                        container+=(""+winner.get(i)[0]);
                    else if (i==winner.size()-1)
                        container+=(", and "+winner.get(i)[0]+".");
                    else 
                        container+=(", "+winner.get(i)[0]);
                }
            } else if (winner.size()==0){
                container = "There is no winner... there was an error.";
            } else {
                container+="The winner is the "+ winner.get(2)[0]+" party.";
            }
            LoginWindow.announce(container);
        });
        this.getChildren().add(logoutBtn4);
    };

    /* TODO must get the results from votes and reset the Database? */
    public ArrayList<String[]> getWinner() {
        ArrayList<String[]> candidates = Database.getAllCandidates();
        String[] winner = candidates.get(0);
        ArrayList<String[]> winnerArrayList = new ArrayList<String[]>();
        winnerArrayList.add(winner);
        for (int i = 0; i < candidates.size(); i++ ) {
            if (Integer.parseInt(winnerArrayList.get(0)[4]) == Integer.parseInt(candidates.get(i)[4])) {
                winnerArrayList.add(candidates.get(i));
            } else if (Integer.parseInt(winnerArrayList.get(0)[4]) < Integer.parseInt(candidates.get(i)[4])) {
                winnerArrayList.clear();
                winnerArrayList.add(candidates.get(i));
            } 
        }
        return winnerArrayList;
    }

    /* to be called wherever this Display is used */
    public void showResults() {
        ArrayList<String[]> candidates = Database.getAllCandidates();
        double totalVotes = (double) getNumAllCurrentVotes(candidates);
        for (int i = 0; i < candidates.size(); i++){
            String[] tempCandidate = candidates.get(i);
            int votes = Integer.parseInt(tempCandidate[4]);
            double result;
            if (votes!=0)

                result = Integer.parseInt(tempCandidate[4])/totalVotes;
            else 
                result = 0;
            CandidateResult candLabel = new CandidateResult(tempCandidate[0],tempCandidate[1],tempCandidate[2],tempCandidate[3],result);
            this.getChildren().add(candLabel);
        }
        
    }

    /* to get all of the current Votes */
    public int getNumAllCurrentVotes(ArrayList<String[]> candidates){
        int votes = 0;
        for (int i = 0; i < candidates.size(); i++) {
            String[] tempCandidate = candidates.get(i);
            int candidateVotes = Integer.parseInt(tempCandidate[4]);
            votes+=candidateVotes;
        }
        return votes;
    }

    public class CandidateResult extends Label {
        public CandidateResult(String firstName, String lastName, String party, String position, double result) {
            this.setText(firstName + " " + lastName + " --- Party: " + party + " --- Position: " + position + " --- Resulting Percentage: " + String.format("%.2f",result));
        }
    }

    
}