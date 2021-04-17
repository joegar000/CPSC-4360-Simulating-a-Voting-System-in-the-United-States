/* This class will contain the method for setting the JavaFX scene to the login screen
   I (David) have tested setting JavaFX scenes this way and it works */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LoginWindow extends Application {
    private static StackPane root = new StackPane();
    private static Scene scene;

    @Override
    public void start(Stage arg0) throws Exception {
        // Ignore this
	}

    public static Scene getScene(Stage loginStage) {
        //Creates a scene that will link to others.
        Scene loginScene;

        //Displays instructions to the voter. Also, changes text font and size.
        Label firstLabel = new Label("Please enter your information to continue.");
        firstLabel.setFont(new Font("Arial", 18));

        //Create a somewhat nice layout.
        VBox layout1 = new VBox(15, firstLabel);
        layout1.setAlignment(Pos.CENTER);

        layout1.setPadding(new Insets(10, 10, 10, 10));
        layout1.getChildren().addAll(
                new Label("Please enter your first name"),
                new TextField(),
                new Label("Please enter your last name"),
                new TextField(),
                new Label("Please enter your SSN"),
                new TextField(),
                new Label("Please enter your password"),
                new PasswordField(),
                new Button("Login"));

        loginScene = new Scene(layout1, 800, 750);

        return loginScene;
    }
}