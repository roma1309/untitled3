package sample.sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddOne {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField quest;

    @FXML
    private TextField ans;

    @FXML
    private TextField ans1;

    @FXML
    private TextField ans2;

    @FXML
    private TextField ans3;

    @FXML
    private Button add;

    @FXML
    private Button closed;
    int i,x;
    @FXML
    void initialize() {


        add.setOnAction(event -> {

            String quest0 = quest.getText().trim();
            String an1 = ans.getText().trim();
            String an2 = ans1.getText().trim();
            String an3 = ans2.getText().trim();
            String an4 = ans3.getText().trim();


            if(!an1.equals("")&&!an2.equals("")&&!an3.equals("")&&!an4.equals("")&&!quest0.equals("")) {
                i++;
                System.out.println(i);
                try {
                    File newFile = new File("D://MyFile.txt");
                    if (!newFile.exists()) {
                        newFile.createNewFile();
                    }
                    System.out.println("File has been created");
                    FileWriter pw = new FileWriter(newFile, true);
                    pw.write(quest0+"\n");
                    pw.write(an1 + "\n");
                    pw.write(an2 + "\n");
                    pw.write(an3 + "\n");
                    pw.write(an4 + "\n");
                    pw.close();
                } catch (IOException ex) {
                    System.out.println("yes");
                }
            }
            quest.clear();
            ans.clear();
            ans2.clear();
            ans1.clear();
            ans3.clear();
        });
        closed.setOnAction(event -> {
            closed.getScene().getWindow().hide();
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

    }
}
