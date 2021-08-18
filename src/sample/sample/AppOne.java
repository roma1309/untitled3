package sample.sample;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.sample.Questions;

public class AppOne {
    @FXML
    private Text Text1;

    @FXML
    private ImageView gif;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private ImageView image;

    @FXML
    private ResourceBundle resources;

    @FXML
    private Text Text;

    @FXML
    private URL location;

    @FXML
    private Button Closed;

    @FXML
    private RadioButton radio_btn;

    @FXML
    private ToggleGroup answers;

    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio3;

    @FXML
    private RadioButton radio4;

    @FXML
    private RadioButton radio5;

    @FXML
    private Button btn;

   private Questions[] questions=new Questions[]{
           new Questions("Назовите фильм",new String[]{"Такси", "Вий", "Начало", "Таксист","Пила"}),
           new Questions("Назовите фильм",new String[]{"Игра", "Легенда", "Престиж", "Таксист","Начало"}),
           new Questions("Назовите фильм",new String[]{"Дюнкерк", "Побег из Шоушенка", "Час пик", "Выживший","Зеленая миля"}),
           new Questions("Назовите фильм",new String[]{"Пила 3", "Список Шиндлера", "Побег", "Джокер","Игра"}),
           new Questions("Назовите фильм",new String[]{"Неприкасаемые", "Я вернусь", "Судья", "Зеленая книга","1+1"})
    };

private int nowQuestion=0,correctAnswer;
private String nowCorrectAnswer = questions[nowQuestion].correctAnswer();
 int i=0;
    @FXML
    void initialize() {
        Image image1 = new Image(getClass().getResourceAsStream("/sample/sample/picture/Movie-Jigsaw-2017.jpg"));
        Image image2 = new Image(getClass().getResourceAsStream("/sample/sample/picture/maxresdefault.jpg"));
        Image image3 = new Image(getClass().getResourceAsStream("/sample/sample/picture/1920x1080_0xac120003_17505174691594294645.jpg"));
        Image image4 = new Image(getClass().getResourceAsStream("/sample/sample/picture/EPsuVj3WsAA6ast.jpg"));
        Image image5 = new Image(getClass().getResourceAsStream("/sample/sample/picture/p1709j89pjfsj1pmt1lbtg4t1bqv1.jpg"));
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
        btn2.setOnAction(event -> {
            btn2.getScene().getWindow().hide();
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
        Closed.setOnAction(event -> {
            Closed.getScene().getWindow().hide();
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
