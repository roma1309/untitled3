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

public class PersonalThree {

    @FXML
    private Text win;

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
    private TextField text1;

    @FXML
    private TextField text2;

    int x;
    int nowQuestion=0;
    @FXML
    void initialize() {
        text.setAlignment(Pos.CENTER);
        text1.setAlignment(Pos.CENTER);
        text2.setAlignment(Pos.CENTER);
        int i=0;
        win.setVisible(false);
        TextHelp.setVisible(false);
        text.setVisible(false);
        String[]personals = new String[5];
        personals[0]="Вито";
        personals[1]="Тони";
        personals[2]="Северус";
        personals[3]="смауг";
        personals[4]="кей";

        String[]name = new String[5];
        name[0]="Корлеоне";
        name[1]= "Монтана";
        name[2]= "Снегг";

        Image image1 = new Image(getClass().getResourceAsStream("/sample/sample/picture/Top-250-фильмов-IMDb-Крёстный-отец-The-Godfather-1972.jpg"));
        Image image2 = new Image(getClass().getResourceAsStream("/sample/sample/picture/shram.jpg"));
        Image image3 = new Image(getClass().getResourceAsStream("/sample/sample/picture/1073752.900xp.jpg"));
        Image image4 = new Image(getClass().getResourceAsStream("/sample/sample/picture/5ad54e214c1cc0396eb4ab2aacaa5e02.png"));
        Image image5 = new Image(getClass().getResourceAsStream("/sample/sample/picture/2040426043-tommy-lee-jones-as-agent-k-in-men-in-black.jpg"));
        image.setImage(image1);
        Image[] images = new Image[7];
        images[0]=image1;images[1]=image2;images[2]=image3;images[3]=image4;images[4]=image5;

        answer.setOnAction(event->{
            Shake an = new Shake(answer);
            an.PlayAnim();
            if(x>2) {
                text.setVisible(true);
                text1.setVisible(false);
                text2.setVisible(false);
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
                   if (x==3){
                       text.setVisible(true);
                       text1.setVisible(false);
                       text2.setVisible(false);
                    }
                }
            }

            if(nowQuestion==personals.length){
                text1.setVisible(false);
                text2.setVisible(false);
                text.setVisible(false);
                help.setVisible(false);
                answer.setVisible(false);
                win.setVisible(false);
                Image gif = new Image(getClass().getResourceAsStream("/sample/sample/assets/10507180927522101.gif"));
                image.setImage(gif);
                win.setVisible(true);
            }
        });

        help.setOnAction(event->{
            String[]helps = new String[5];
            helps[0]="Два слова, первая буква имени (В)";
            helps[1]="Два слова, первая буква имени (Т)";
            helps[2]="два слова начинаются на (С)";
            helps[3]="Дракон из вселенной про кольцо";
            helps[4]="агент людей в черном";
            TextHelp.setVisible(true);
            TextHelp.setText(helps[x]);

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
