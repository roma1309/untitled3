package sample.sample;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Sigame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Closed;

    @FXML
    private Button btn;

    @FXML
    private RadioButton radio5;

    @FXML
    private ToggleGroup answers;

    @FXML
    private RadioButton radio3;

    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio4;

    @FXML
    private Button btn1;

    @FXML
    private Text Text1;
 int i,y,z,k,number,nowQuestion;
 String correct;
    @FXML
    void initialize() {
        Text1.setTextAlignment(TextAlignment.CENTER);
        btn1.setVisible(false);
    String []questions = new String[100];
    String []answer = new String[100];
        try
        {
            File file = new File("D://MyFile.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                i++;
               if(i%5==1||i==1){
                    questions[z]=line;
                   z++;
                }
                if(i>1&&i%5!=1) {
                    y++;
                    answer[y] = line;
                }

               System.out.println(line);
                line = reader.readLine();
            }
        }
        catch(IOException ex) {

            System.out.println("BAD");
        }
        String [][] matrix = new String[100][100];
        for (int x=0;x<z;x++){
            for (int e=0;e<4;e++){
                k++;
                matrix[x][e]=answer[k];
            }
        }

       Text1.setText(questions[0]);
       radio2.setText(answer[1]);
       radio3.setText(answer[2]);
       radio4.setText(answer[3]);
       radio5.setText(answer[4]);
       correct = answer[1];

       btn.setOnAction(event -> {
           RadioButton selectedRadio =(RadioButton) answers.getSelectedToggle();
           if(selectedRadio!=null){
               String toggleGroupValue = selectedRadio.getText();
               if(toggleGroupValue.equals(correct)){
                   number++;
                   System.out.println("Верно");
               }
               else {
                   System.out.println("не верно");
               }
           }
           if(nowQuestion+1==z){
               radio2.setVisible(false);
               radio5.setVisible(false);
               radio4.setVisible(false);
               radio3.setVisible(false);
               btn.setVisible(false);
               Text1.setText("Верно "+number+" из "+ z);
           }
           else {
               nowQuestion++;
               Text1.setText(questions[nowQuestion]);
               List<String> stringList= Arrays.asList(matrix[nowQuestion][0],matrix[nowQuestion][1],matrix[nowQuestion][2],matrix[nowQuestion][3]);
               correct =matrix[nowQuestion][0];
               Collections.shuffle(stringList);
               radio2.setText(stringList.get(0));
               radio3.setText(stringList.get(1));
               radio4.setText(stringList.get(2));
               radio5.setText(stringList.get(3));
               selectedRadio.setSelected(false);
           }
       });
       Closed.setOnAction(event -> {
           Closed.getScene().getWindow().hide();
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
