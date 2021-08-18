package sample.sample;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Button Button4;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    void initialize() {
Button1.setOnAction(event -> {
    Button1.getScene().getWindow().hide();
    Parent root = null;
    try {
        root = FXMLLoader.load(getClass().getResource("/sample/sample/app.fxml"));
    } catch (IOException e) {
        e.printStackTrace();
    }
    Stage primaryStage = new Stage();
    primaryStage.setTitle("Знание фильмов");
    primaryStage.setScene(new Scene(root, 800, 600));
    primaryStage.setResizable(false);
    primaryStage.show();
 });
        Button2.setOnAction(event -> {
            Button2.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/sample/appPerson.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Знание фильмов");
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.setResizable(false);
            primaryStage.show();
        });
        Button4.setOnAction(event -> {
            Button4.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/sample/create.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Знание фильмов");
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.setResizable(false);
            primaryStage.show();
        });
        Button3.setOnAction(event -> {
            System.exit(1);
        });

    }
}
