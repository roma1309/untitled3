package sample.sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Personal {

    @FXML
    private Button next;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField text;

    @FXML
    private ImageView image;

    @FXML
    private Button help;

    @FXML
    private Button closed;

    @FXML
    private Text TextHelp;

    @FXML
    private Button answer;

    @FXML
    private TextField text1;

    @FXML
    private TextField text2;

    int x;
 int nowQuestion=0;
    @FXML
    void initialize() {
        text1.setVisible(false);
        text2.setVisible(false);
        text.setAlignment(Pos.CENTER);
        text1.setAlignment(Pos.CENTER);
        text2.setAlignment(Pos.CENTER);
        int i=0;
     next.setVisible(false);
     TextHelp.setVisible(false);
        String[]personals = new String[5];
        personals[0]="джокер";
        personals[1]="Питер" ;
        personals[2]="Джон";
        personals[3]="Кэлвин";
        personals[4]="Микки";

        String[]name = new String[5];
        name[1]="паркер";
        name[2]= "Сноу";
        name[3]= "Кэнди";
        name[4]="Пирсон";

        Image image1 = new Image(getClass().getResourceAsStream("/sample/sample/picture/aIQrRkNh.jpg"));
        Image image2 = new Image(getClass().getResourceAsStream("/sample/sample/picture/spider-man3-vrag-2.jpg"));
        Image image3 = new Image(getClass().getResourceAsStream("/sample/sample/picture/VslzYT6.png"));
        Image image4 = new Image(getClass().getResourceAsStream("/sample/sample/picture/big_startfilmru1338949.jpg"));
        Image image5 = new Image(getClass().getResourceAsStream("/sample/sample/picture/the-gentlemen-filmi-dizi-oluyor-5f7aee75bc661.jpg"));
        image.setImage(image1);
        Image[] images = new Image[7];
        images[0]=image1;images[1]=image2;images[2]=image3;images[3]=image4;images[4]=image5;

     answer.setOnAction(event->{
             Shake an = new Shake(answer);
             an.PlayAnim();
         if(x==0) {
             text.setVisible(true);
             String personage = text.getText().trim();
                 if (personage.equalsIgnoreCase(personals[x])) {
                     System.out.println("ВЕРНО!");
                     x++;
                     nowQuestion++;
                     text.clear();
                     TextHelp.setVisible(false);
                     image.setImage(images[nowQuestion]);
                 }

         }

         if(x!=0) {
             text.setVisible(false);
             text1.setVisible(true);
             text2.setVisible(true);
             String per = text1.getText().trim();
             String per1 = text2.getText().trim();
             if (per.equalsIgnoreCase(personals[x])&&per1.equalsIgnoreCase(name[x])) {
                 System.out.println("ВЕРНО!");
                 x++;
                 nowQuestion++;
                 text1.clear();
                 text2.clear();;
                 TextHelp.setVisible(false);
                 image.setImage(images[nowQuestion]);
             }

         }
         if(nowQuestion==personals.length){
             text.setVisible(false);
             help.setVisible(false);
             image.setVisible(false);
             answer.setVisible(false);
             next.setVisible(true);
             text2.setVisible(false);
             text1.setVisible(false);
         }
     });

     help.setOnAction(event->{
         String[]helps = new String[5];
         helps[0]="Первая буква (Д)";
         helps[1]="Два слова начинаются на (П)";
         helps[2]="Главный персонаж Игры Престолов";
         helps[3]="Два слова начинаются на (К)";
         helps[4]="Главный персонаж фильма Джетельмены";
         TextHelp.setVisible(true);
         TextHelp.setText(helps[x]);

     });

     next.setOnAction(event -> {
        next.getScene().getWindow().hide();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/sample/sample/appPersonTwo.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Знание фильмов");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setResizable(false);
        primaryStage.show();

});
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
    }
}