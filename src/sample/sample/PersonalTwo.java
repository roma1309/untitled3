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

public class PersonalTwo {

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
    private Button answer;

    @FXML
    private Text TextHelp;

    @FXML
    private Button closed;

    @FXML
    private Button next;

    @FXML
    private TextField text2;

    @FXML
    private TextField text1;

    int x;
    int nowQuestion=0;

    @FXML
    void initialize() {
        text.setAlignment(Pos.CENTER);
        text1.setAlignment(Pos.CENTER);
        text2.setAlignment(Pos.CENTER);
        text1.setVisible(false);
        text2.setVisible(false);
        int i=0;
        next.setVisible(false);
        TextHelp.setVisible(false);
        String[]personals = new String[5];
        personals[2]="шерлок";
        personals[3]="судья";
        personals[4]="черная";
        personals[0]="Шрек";
        personals[1]="Добби";

        String[]name = new String[5];
        name[2]="холмс";
        name[3]= "дредд";
        name[4]= "пантера";
        Image image2 = new Image(getClass().getResourceAsStream("/sample/sample/picture/D7ymT-6UwAAKlzH.jpg"));
        Image image3 = new Image(getClass().getResourceAsStream("/sample/sample/picture/cc6d5a544962542bddf916c2336cf9f6.jpeg"));
        Image image4 = new Image(getClass().getResourceAsStream("/sample/sample/picture/a257c128419603.55bf8e74a5100.png"));
        Image image0 = new Image(getClass().getResourceAsStream("/sample/sample/picture/245354155_29fd3b14f087b9aeda2bcfa591071cac_800.jpg"));
        Image image1 = new Image(getClass().getResourceAsStream("/sample/sample/picture/harry_potter_7_262.jpg"));
        image.setImage(image0);
        Image[] images = new Image[7];
        images[1]=image1;images[2]=image2;images[3]=image3;images[4]=image4;images[0]=image0;

        answer.setOnAction(event->{
            Shake an = new Shake(answer);
            an.PlayAnim();
            if(x<2) {
                String personage = text.getText().trim();
                if (personage.equalsIgnoreCase(personals[x])) {
                    System.out.println("ВЕРНО!");
                    x++;
                    nowQuestion++;
                    text.clear();
                    TextHelp.setVisible(false);
                    image.setImage(images[nowQuestion]);
                    if (x==2){
                        text.setVisible(false);
                        text1.setVisible(true);
                        text2.setVisible(true);
                    }
                }
            }

            else {
                text.setVisible(false);
                text1.setVisible(true);
                text2.setVisible(true);
                String per1 = text2.getText().trim();
                String per = text1.getText().trim();
                if (per.equalsIgnoreCase(personals[x])&&per1.equalsIgnoreCase(name[x])) {
                    System.out.println("ВЕРНО!");
                    x++;
                    nowQuestion++;
                    text1.clear();
                    text2.clear();
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
            helps[2]="Лучший детектив";
            helps[3]="Два слова, второе начинается на (Д)";
            helps[4]="Король Ваканды";
            helps[0]="самый страшный огр";
            helps[1]="Первая буква (Д)";
            TextHelp.setVisible(true);
            TextHelp.setText(helps[x]);

        });

        next.setOnAction(event -> {
            next.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/sample/appPersonThree.fxml"));
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
