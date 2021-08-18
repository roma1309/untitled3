package sample.sample;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Create {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add;

    @FXML
    private Button closed;

    @FXML
    private Button add1;

    @FXML
    private Button add2;

    @FXML
    private Button add3;

    @FXML
    private Button add4;

    @FXML
    void initialize() {
        add2.setVisible(false);
        add3.setVisible(false);
        add4.setVisible(false);
        closed.setOnAction(event -> {
            closed.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/sample/sample.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Знание фильмов");
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.setResizable(false);
            primaryStage.show();
        });
        add.setOnAction(event -> {
  add.setVisible(false);
  add1.setVisible(false);
  closed.setVisible(false);
            add2.setVisible(true);
            add3.setVisible(true);
            add4.setVisible(true);
        });
        add1.setOnAction(event -> {

            try {
                File file = new File("D://MyFile.txt");
                //создаем объект FileReader для объекта File
                FileReader fr = new FileReader(file);
                //создаем BufferedReader с существующего FileReader для построчного считывания
                BufferedReader reader = new BufferedReader(fr);
                // считаем сначала первую строку
                String line = reader.readLine();
                    if (!line.equals("")) {
                        add1.getScene().getWindow().hide();
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("/sample/sample/sigame.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage primaryStage = new Stage();
                        primaryStage.setTitle("Знание фильмов");
                        primaryStage.setScene(new Scene(root, 800, 600));
                        primaryStage.setResizable(false);
                        primaryStage.show();
                    }
            }
            catch(Exception e)
            {
                System.err.println("Error in file cleaning: ");
            }
        });

        add2.setOnAction(event -> {
            add.setVisible(true);
            add1.setVisible(true);
            closed.setVisible(true);
            add2.setVisible(false);
            add3.setVisible(false);
            add4.setVisible(false);
        });
        add4.setOnAction(event -> {

            try {
                File newFile = new File("D://MyFile.txt");
                if (!newFile.exists()) {
                    newFile.createNewFile();
                }
                PrintWriter writer = new PrintWriter(newFile);
                writer.print("");
                writer.close();
            } catch (Exception e)
            {
                System.err.println("Error in file cleaning: ");
            }
            add4.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/sample/Add.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Знание фильмов");
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.setResizable(false);
            primaryStage.show();
        });
        add3.setOnAction(event -> {
            add3.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/sample/Add.fxml"));
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

