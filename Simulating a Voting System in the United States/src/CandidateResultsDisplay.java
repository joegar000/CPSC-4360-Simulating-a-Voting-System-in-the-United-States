
import java.util.ArrayList;
import java.util.List;

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
            ArrayList<String> partyList = new ArrayList<String>();
            for (int i = 0; i < winner.size(); i++){
                if (partyList.size()<1) {
                    partyList.add(winner.get(i)[2]);
                } else if (!partyList.contains(winner.get(i)[2])) {
                    partyList.add(winner.get(i)[2]);
                }
            }

            for (int g = 0; g < winner.size(); g++){
                System.out.println(" Name: "+winner.get(g)[0]+" "+ winner.get(g)[1]+" Party: " + winner.get(g)[2] +" Position: "+winner.get(g)[3]);
            }

            if (partyList.size()>1) {
                container+="=There was a tie. Here are the parties";
                for (int r = 0; r < partyList.size(); r++) {
                    container+=" " + partyList.get(r);
                }
                container+=". Here are the following contestants in the tie:";
                for (int g = 0; g < winner.size(); g++){
                    container+=" =Name: "+winner.get(g)[0]+" "+ winner.get(g)[1]+" -- Party: " + winner.get(g)[2] +" -- Position: "+winner.get(g)[3];
                }
            } else if (partyList.isEmpty()) {
                container+="=There were no winners... no one voted.";
            } else {
                container+="=Congratulations to the winners of the " + partyList.get(0) + " party. Here are the candidates:";
                for (int g = 0; g < winner.size(); g++){
                    container+=" =Name: "+winner.get(g)[0]+" "+ winner.get(g)[1]+" -- Party: " + winner.get(g)[2] +" -- Position: "+winner.get(g)[3];
                }
            }

            LoginWindow.announce(container);
        });
        this.getChildren().add(logoutBtn4);
    };

    /* This method calculates the winner, returns an array list with all winners */
    public ArrayList<String[]> getWinner() {
        ArrayList<String[]> candidates = Database.getAllCandidates();
        ArrayList<String[]> partyListResults = new ArrayList<String[]>();

        //This block sorts all the votes into their respective parties and totals them
        for (int i = 0; i < candidates.size(); i++ ) {
            if (partyListResults.isEmpty()) {
                String[] tempResult = {candidates.get(i)[2], candidates.get(i)[4]};
                partyListResults.add(tempResult);
            } else {
                boolean foundHome = false;
                for (int r = 0; r < partyListResults.size(); r++) {
                    if (partyListResults.get(r)[0] == candidates.get(i)[2]) {
                        int tempInt = Integer.parseInt(partyListResults.get(r)[1]);
                        tempInt+=Integer.parseInt(candidates.get(i)[4]);
                        partyListResults.get(r)[1] = ""+tempInt;
                        foundHome=true;
                        break;
                    }
                }
                if (foundHome==false) {
                    String[] tempResult = {candidates.get(i)[2], candidates.get(i)[4]};
                    partyListResults.add(tempResult);
                }
            }
        } 
        
        //This shows all the parties and respective total votes.
        for (int g = 0; g < partyListResults.size(); g++){
            System.out.println(" Party: "+partyListResults.get(g)[0]+" Votes: "+ partyListResults.get(g)[1]);
        }

        // This block gets the party winner from the parties
        String[] winner = new String[2];
        List<String> tieHolder = new ArrayList<String>();
        for (int t = 0; t<partyListResults.size(); t++) {
            if (winner[0]==null) {
                winner = partyListResults.get(t);
            } else {
                if (Integer.parseInt(winner[1]) < Integer.parseInt(partyListResults.get(t)[1])) {
                    winner = partyListResults.get(t);
                    //tieHolder = new String[10];
                    tieHolder.clear();
                } else if (Integer.parseInt(winner[1]) == Integer.parseInt(partyListResults.get(t)[1])) {
                    if (tieHolder.isEmpty()){
                        tieHolder.add(winner[0]);
                        tieHolder.add(partyListResults.get(t)[0]);
                    } else {
                        tieHolder.add(partyListResults.get(t)[0]);
                    }
                }
            }
        }

        //This block gets all the candidates from the party(s) that win(s)
        ArrayList<String[]> candidatesCollection = Database.getAllCandidates();
        ArrayList<String[]> winnerArrayList = new ArrayList<String[]>();
        if (tieHolder.isEmpty()) {
            System.out.println("is empty");
            for (int i = 0; i < candidatesCollection.size(); i++ ) {
                System.out.println(winner[0] + " compared to "+ candidatesCollection.get(i)[2]);
                if (winner[0].equalsIgnoreCase(candidatesCollection.get(i)[2])) {
                    winnerArrayList.add(candidatesCollection.get(i));
                    System.out.println("gets added");
                } 
            }
        } else {
            for (int f = 0; f < tieHolder.size(); f++){
                for (int i = 0; i < candidatesCollection.size(); i++ ) {
                    if (tieHolder.get(f) == candidatesCollection.get(i)[2]) {
                        winnerArrayList.add(candidatesCollection.get(i));
                    } 
                }
            }
        }

        return winnerArrayList;
    }

    /* to be called wherever this Display is used */
    public void showResults() {
        ArrayList<String[]> candidates = Database.getAllCandidates();
        double totalVotes = (double) getNumAllCurrentVotes(candidates);
        ArrayList<String[]> partyListResults = new ArrayList<String[]>();

        for (int i = 0; i < candidates.size(); i++ ) {
            if (partyListResults.isEmpty()) {
                String[] tempResult = {candidates.get(i)[2], candidates.get(i)[4]};
                partyListResults.add(tempResult);
            } else {
                boolean foundHome = false;
                for (int r = 0; r < partyListResults.size(); r++) {
                    if (partyListResults.get(r)[0] == candidates.get(i)[2]) {
                        int tempInt = Integer.parseInt(partyListResults.get(r)[1]);
                        tempInt+=Integer.parseInt(candidates.get(i)[4]);
                        partyListResults.get(r)[1] = ""+tempInt;
                        foundHome=true;
                        break;
                    }
                }
                if (foundHome==false) {
                    String[] tempResult = {candidates.get(i)[2], candidates.get(i)[4]};
                    partyListResults.add(tempResult);
                }
            }
        } 
        
        for (int g = 0; g < partyListResults.size(); g++){
            double result = Integer.parseInt(partyListResults.get(g)[1])/totalVotes*100;
            String party = partyListResults.get(g)[0];
            PartyResultLabel label = new PartyResultLabel(party, result);
            this.getChildren().add(label);
        }
        

        //WAS for individuals
        /*for (int i = 0; i < candidates.size(); i++){ 
            String[] tempCandidate = candidates.get(i);
            int votes = Integer.parseInt(tempCandidate[4]); //change
            double result;
            if (votes!=0)

                result = (Integer.parseInt(tempCandidate[4])/totalVotes)*100;
            else 
                result = 0;

            CandidateResultLabel candLabel = new CandidateResultLabel(tempCandidate[0],tempCandidate[1],tempCandidate[2],tempCandidate[3],result);
            this.getChildren().add(candLabel);
        }*/
        
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

    /*Label Class for Individuals*/
    public class CandidateResultLabel extends Label {
        public CandidateResultLabel(String firstName, String lastName, String party, String position, double result) {
            this.setText(firstName + " " + lastName + " --- Party: " + party + " --- Position: " + position + " --- Resulting Percentage: " + String.format("%.2f",result));
        }
    }

    /*Label Class for parties */
    public class PartyResultLabel extends Label {
        public PartyResultLabel(String party, double result) {
            this.setText("Party: " + party + " --- Resulting Percentage: " + String.format("%.2f",result));
        }
    }

    
}