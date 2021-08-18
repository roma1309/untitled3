package sample.sample;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppOneLevelTwo {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Closed;

    @FXML
    private Button btn;

    @FXML
    private ImageView image;

    @FXML
    private Text Text;

    @FXML
    private RadioButton radio5;

    @FXML
    private ToggleGroup answers;

    @FXML
    private RadioButton radio_btn;

    @FXML
    private RadioButton radio3;

    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio4;

    @FXML
    private Button btn1;

    @FXML
    private ImageView gif;

    @FXML
    private Text Text1;

    @FXML
    private Button btn2;

    private Questions[] questions=new Questions[]{
            new Questions("Назовите фильм",new String[]{"Авиатор", "Нефть", "Таксист", "Мюнхен","Терминал"}),
            new Questions("Назовите фильм",new String[]{"К звездам", "Цвет денег", "Король комедии", "Сапожник","Управление гневом"}),
            new Questions("Назовите фильм",new String[]{"Игры разума", "Схватка", "Пленницы", "Семь","Зодиак"}),
            new Questions("Назовите фильм",new String[]{"Бесславные ублюдки", "Уцелевший", "Севастополь", "Сталинград","1917"}),
            new Questions("Назовите фильм",new String[]{"Гран Торино", "Мотылек", "Судья", "Цвет денег","Помни"})
    };
    private int nowQuestion=0,correctAnswer;
    private String nowCorrectAnswer;
    private int i=0;

    @FXML
    void initialize() {
            Image image1 = new Image(getClass().getResourceAsStream("/sample/sample/picture/The-terminal.jpg"));
            Image image2 = new Image(getClass().getResourceAsStream("/sample/sample/picture/321864.jpg"));
            Image image3 = new Image(getClass().getResourceAsStream("/sample/sample/picture/c0ca3fb0616d32e12dc320ed5f57ce9f.png"));
            Image image4 = new Image(getClass().getResourceAsStream("/sample/sample/picture/180299.jpg"));
            Image image5 = new Image(getClass().getResourceAsStream("/sample/sample/picture/xj91iy7eu3cbf5l.jpg"));
            image.setImage(image1);
            btn1.setVisible(false);
            btn2.setVisible(false);
            Text1.setVisible(false);
            Image[] images = new Image[5];
            images[0]=image1;images[1]=image2;images[2]=image3;images[3]=image4;images[4]=image5;
            nowCorrectAnswer = questions[nowQuestion].correctAnswer();
            btn.setOnAction(event -> {
                RadioButton selectedRadio =(RadioButton) answers.getSelectedToggle();
                if(selectedRadio!=null){
                    String toggleGroupValue=selectedRadio.getText();
                    if(toggleGroupValue.equals(nowCorrectAnswer)){
                        System.out.println("Верный ответ");
                        correctAnswer++;
                    }
                    else{
                        System.out.println("Не верный ответ");
                    }
                }
                if(correctAnswer==5) {
                    Text.setVisible(false);
                    btn.setVisible(false);
                    radio_btn.setVisible(false);
                    radio2.setVisible(false);
                    radio3.setVisible(false);
                    radio4.setVisible(false);
                    radio5.setVisible(false);
                    image.setVisible(false);
                    Text1.setVisible(true);
                    Text1.setText("Вы ответили корректно на все вопросы "+
                            "Начните следующий уровень !!!");
                    Image g = new Image(getClass().getResourceAsStream("/sample/assets/1rRk.gif"));
                    gif.setImage(g);
                    btn2.setVisible(true);
                }
                if (nowQuestion+1==questions.length&&correctAnswer<5){
                    btn1.setVisible(true);
                    btn.setVisible(false);
                    radio_btn.setVisible(false);
                    radio2.setVisible(false);
                    radio3.setVisible(false);
                    radio4.setVisible(false);
                    radio5.setVisible(false);
                    image.setVisible(false);
                    Text.setText("Вы ответили корректно на " + correctAnswer + " из " + questions.length + " вопросов! " +
                            "Попробуйте еще !!!");
                    btn1.setText("Играть");
                }

                if(nowQuestion+1!=questions.length)  {
                    btn1.setVisible(false);
                    nowQuestion++; i++;
                    image.setImage(images[i]);
                    nowCorrectAnswer = questions[i].correctAnswer();
                    Text.setText(questions[nowQuestion].getQuestions());
                    String[] answers =questions[nowQuestion].getAnswers();
                    List<String> stringList= Arrays.asList(answers);
                    Collections.shuffle(stringList);
                    radio_btn.setText(stringList.get(0));
                    radio2.setText(stringList.get(1));
                    radio3.setText(stringList.get(2));
                    radio4.setText(stringList.get(3));
                    radio5.setText(stringList.get(4));
                    selectedRadio.setSelected(false);
                }


            });
        btn1.setOnAction(event -> {
            btn1.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/sample/appLevel2.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Знание фильмов");
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.setResizable(false);
            primaryStage.show();
        });
        btn2.setOnAction(event -> {
            btn2.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/sample/appLevel3.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Знание фильмов");
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.setResizable(false);
            primaryStage.show();
        });
        Closed.setOnAction(event ->{
                Closed.getScene().getWindow().hide();
        Parent root=null;
        try {
            root= FXMLLoader.load(getClass().getResource("/sample/sample/sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage primaryStage=new Stage();
        primaryStage.setTitle("Знание фильмов");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
        });
    }
}
