import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Database {

    private static Connection voterConn = null;
    private static Connection pollWorkerConn = null;
    private static Connection administratorConn = null;
    private static Connection candidatesConn = null;

    public static void setUpVoters() {
        voterConn = Database.connect("jdbc:sqlite:voters.db");
        Database.createNewVoterTable();
    }

    public static void setUpPollWorkers() {
        pollWorkerConn = Database.connect("jdbc:sqlite:pollworkers.db");
        Database.createNewPollWorkerTable();
    }

    public static void setUpAdministrators() {
        administratorConn = Database.connect("jdbc:sqlite:administrators.db");
        Database.createNewAdministratorTable();
    }

    public static void setUpCandidates() {
        candidatesConn = Database.connect("jdbc:sqlite:candidates.db");
        Database.createNewCandidatesTable();
    }

    public static void createNewVoterTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS voters (\n"
                + "	ssn text PRIMARY KEY UNIQUE,\n"
                + "	first_name text NOT NULL,\n"
                + "	last_name text NOT NULL,\n"
                + "	age text NOT NULL,\n"
                + "	state text NOT NULL,\n"
                + " voted text NOT NULL DEFAULT FALSE\n"
                + ");";
        
        try (Statement stmt = voterConn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "votertable");
        }
    }

    public static void createNewPollWorkerTable() {        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS pollworkers (\n"
                + "	ssn text PRIMARY KEY UNIQUE,\n"
                + "	first_name text NOT NULL,\n"
                + "	last_name text NOT NULL\n"
                + ");";
        
        try (Statement stmt = pollWorkerConn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewAdministratorTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS administrators (\n"
                + "	ssn text PRIMARY KEY UNIQUE,\n"
                + "	first_name text NOT NULL,\n"
                + "	last_name text NOT NULL\n"
                + ");";
        
        try (Statement stmt = administratorConn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "admintable");
        }
    }

    public static void createNewCandidatesTable() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS candidates (\n"
                + "	first_name text NOT NULL,\n"
                + "	last_name text NOT NULL,\n"
                + " party text PRIMARY KEY NOT NULL,\n"
                + " votes text NOT NULL\n"
                + ");";
        
        try (Statement stmt = candidatesConn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "candidate table");
        }
    }


    public static void vote(String party) {
        String sql = "UPDATE candidates SET votes = ? WHERE party LIKE ?";
        
            try (PreparedStatement stmt = candidatesConn.prepareStatement(sql)) {
                String votes = Database.getCandidate(party)[3];
                int voteCount = Integer.valueOf(votes);
                voteCount++;
                votes = Integer.toString(voteCount);
                stmt.setString(1, votes);
                stmt.setString(2, party);
                stmt.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage() + "vote");
        }
    }


    public static void registerVoter(String ssn, String first_name, String last_name, String age, String state, boolean votedBool) {
        String voted = votedBool ? "TRUE" : "FALSE";

        String sql = "INSERT INTO voters(ssn,first_name,last_name,age,state,voted) VALUES(?,?,?,?,?,?)";

        try (PreparedStatement pstmt = voterConn.prepareStatement(sql)) {
            pstmt.setString(1, ssn);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.setString(4, age);
            pstmt.setString(5, state);
            pstmt.setString(6, voted);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "registervoter");
        }
    }

    public static String[] getVoterInformation(String ssn) {
        String sql = "SELECT ssn, first_name, last_name, age, state, voted FROM voters WHERE ssn LIKE ?";
        String[] info = new String[6];

        try (PreparedStatement stmt = voterConn.prepareStatement(sql)) {
            stmt.setString(1,ssn);
            ResultSet rs = stmt.executeQuery();
                
            while (rs.next()) {
                    info[0] = rs.getString("ssn");
                    info[1] = rs.getString("first_name");
                    info[2] = rs.getString("last_name");
                    info[3] = rs.getString("age");
                    info[4] = rs.getString("state");
                    info[5] = rs.getString("voted");
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage() + "getvoter");
        }
        return info;
    }

    // This returns an arraylist of string arrays for display the entire voter database, I assume
    // you could write javafx code that loops through and gets all the voter information
    public static ArrayList<String[]> getAllVoterInformation() {
        String sql = "SELECT ssn, first_name, last_name, age, state, voted FROM voters";
        ArrayList<String[]> allVoters = new ArrayList<>();

        try (Statement stmt = voterConn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
                
            while (rs.next()) {
                String[] info = new String[6];
                info[0] = rs.getString("ssn");
                info[1] = rs.getString("first_name");
                info[2] = rs.getString("last_name");
                info[3] = rs.getString("age");
                info[4] = rs.getString("state");
                info[5] = rs.getString("voted");
                allVoters.add(info);
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage() + "getvoter");
        }
        return allVoters;
    }


    public static void voterVoted(String ssn) {
        String sql = "UPDATE voters SET voted = ? WHERE ssn LIKE ?";
        
            try (PreparedStatement stmt = voterConn.prepareStatement(sql)) {
                String voted = "TRUE";
                stmt.setString(1, voted);
                stmt.setString(2, ssn);
                stmt.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.getMessage() + "votervoted");
        }
    }


    public static void registerPollWorker(String ssn, String first_name, String last_name) {
        String sql = "INSERT INTO pollworkers(ssn,first_name,last_name) VALUES(?,?,?)";

        try (PreparedStatement pstmt = pollWorkerConn.prepareStatement(sql)) {
            pstmt.setString(1, ssn);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String[] getPollWorkerInformation(String ssn) {
        String sql = "SELECT ssn, first_name, last_name FROM pollworkers WHERE ssn LIKE ?";
        String[] info = new String[3];

        try (PreparedStatement stmt = pollWorkerConn.prepareStatement(sql)) {
            stmt.setString(1,ssn);
            ResultSet rs = stmt.executeQuery();
                
            while (rs.next()) {
                    info[0] = rs.getString("ssn");
                    info[1] = rs.getString("first_name");
                    info[2] = rs.getString("last_name");
            }

        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return info;
    }

    public static void registerAdministrator(String ssn, String first_name, String last_name) {
        String sql = "INSERT INTO administrators(ssn,first_name,last_name) VALUES(?,?,?)";
    
        try (PreparedStatement pstmt = administratorConn.prepareStatement(sql)) {
            pstmt.setString(1, ssn);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "admin register");
        }
    }

    public static String[] getAdministratorInformation(String ssn) {
        String sql = "SELECT ssn, first_name, last_name FROM administrators WHERE ssn LIKE ?";
        String[] info = new String[3];
            try (PreparedStatement stmt = administratorConn.prepareStatement(sql)) {
                stmt.setString(1,ssn);
                ResultSet rs = stmt.executeQuery();
                
            while (rs.next()) {
                    info[0] = rs.getString("ssn");
                    info[1] = rs.getString("first_name");
                    info[2] = rs.getString("last_name");
            }
    
        }
        catch(SQLException e) {
            System.out.println(e.getMessage() + "getadmin");
        }
    
        return info;
    }

    public static void registerCandidate(String first_name, String last_name, String party, int vote) {
        String sql = "INSERT INTO candidates(first_name,last_name,party,votes) VALUES(?,?,?,?)";

        String votes = Integer.toString(vote);
    
        try (PreparedStatement pstmt = candidatesConn.prepareStatement(sql)) {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, party);
            pstmt.setString(4, votes);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "registercandidate");
        }
    }

    public static String[] getCandidate(String party) {
        String sql = "SELECT first_name, last_name, party, votes FROM candidates WHERE party LIKE ?";
        String[] info = new String[4];
            try (PreparedStatement stmt = candidatesConn.prepareStatement(sql)) {
                stmt.setString(1,party);
                ResultSet rs = stmt.executeQuery();
                
            while (rs.next()) {
                    info[0] = rs.getString("first_name");
                    info[1] = rs.getString("last_name");
                    info[2] = rs.getString("party");
                    info[3] = rs.getString("votes");
            }
    
        }
        catch(SQLException e) {
            System.out.println(e.getMessage() + "getcandidate");
        }
    
        return info;
    }

    // This returns an arraylist of string arrays for display the entire candidate database, I assume
    // you could write javafx code that loops through and gets all the candidate information
    public static ArrayList<String[]> getAllCandidates() {
        String sql = "SELECT first_name, last_name, party, votes FROM candidates";
        ArrayList<String[]> allCandidates = new ArrayList<>();

            try (Statement stmt = candidatesConn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
                
            while (rs.next()) {
                    String[] info = new String[4];
                    info[0] = rs.getString("first_name");
                    info[1] = rs.getString("last_name");
                    info[2] = rs.getString("party");
                    info[3] = rs.getString("votes");
                    allCandidates.add(info);
            }
    
        }
        catch(SQLException e) {
            System.out.println(e.getMessage() + "displayallcandidates");
        }
    
        return allCandidates;
    }





    public static Connection connect(String url) {
        Connection conn = null;

        Database.createNewDatabase(url);

        try {
            // db parameters
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void createNewDatabase(String url) {

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
