import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Valentines Day Presentation");
        //primaryStage.setMaximized(true);
        StackPane root = new StackPane();
        BackgroundFill bf = new BackgroundFill(javafx.scene.paint.Color.PINK, CornerRadii.EMPTY, Insets.EMPTY);
        Background b = new Background(bf);
        root.setBackground(b);


        String name = "Name";
        Font font = javafx.scene.text.Font.font("Toppan Bunkyu Gothic",25 );
        Text text = new Text("Happy Valentines Day " + name + "!");
        text.setFont(font);


        text.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().addAll( text);
        StackPane.setAlignment(text, Pos.CENTER);

        Circle c1 = new Circle();
        c1.setRadius(50);

        Circle c2 = new Circle();
        c2.setRadius(50);

        Polygon tri = new Polygon();
        tri.getPoints().addAll(new Double[]{
                125.0, 150.0,
                100.0, 100.0,
                100.0, 150.0 });
        tri.setFill(Color.GREEN);

        c1.setFill(Color.RED);
        c2.setFill(Color.BLUE);

        c1.setCenterX(100);
        c1.setCenterY(100);
        c2.setCenterX(150);
        c2.setCenterY(100);

        Group g = new Group();
        g.getChildren().addAll(c1, c2, tri);
        root.getChildren().addAll(g);
        g.setTranslateX(root.getPrefWidth() / 3);
        g.setTranslateY(root.getPrefHeight() / 3);





        /*
        //Creating Translate Transition
        TranslateTransition translateTransition = new TranslateTransition();

        //Setting the duration of the transition
        translateTransition.setDuration(Duration.millis(1000));

        //Setting the node for the transition
        translateTransition.setNode(circle);

        //Setting the value of the transition along the x axis.
        translateTransition.setByX(300);

        //Setting the cycle count for the transition
        translateTransition.setCycleCount(50);

        //Setting auto reverse value to false
        translateTransition.setAutoReverse(false);

        //Playing the animation
        translateTransition.play();

         */
        Scene s = new Scene(root, 800, 600);
        primaryStage.setScene(s);






        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
