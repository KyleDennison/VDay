import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Valentines Day Presentation");
        //primaryStage.setMaximized(true);
        Color c = new Color(255,102,102);
        StackPane root = new StackPane();
        BackgroundFill bf = new BackgroundFill(javafx.scene.paint.Color.PINK, CornerRadii.EMPTY, Insets.EMPTY);
        Background b = new Background(bf);
        root.setBackground(b);


        String name = "Name";
        Font font = javafx.scene.text.Font.font("Toppan Bunkyu Gothic",25 );
        Text text = new Text("Happy Valentines Day " + name + "!");
        text.setFont(font);
        System.out.println(javafx.scene.text.Font.getFamilies());


        text.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().addAll( text);
        StackPane.setAlignment(text, Pos.CENTER);


        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
