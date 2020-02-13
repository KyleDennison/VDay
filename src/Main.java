import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
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
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

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
        Font font = javafx.scene.text.Font.font("Toppan Bunkyu Gothic", FontWeight.BOLD ,30 );
        Text text = new Text("Happy Valentines Day " + name + "!");
        text.setFont(font);
        text.setFill(Color.PURPLE);


        text.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().addAll( text);
        StackPane.setAlignment(text, Pos.CENTER);

        //Setting the properties of the arc
        /*
        Arc a = new Arc();
        a.setCenterX(80);
        a.setCenterY(100);
        a.setRadiusX(50);
        a.setRadiusY(50);
        a.setStartAngle(0);
       a.setLength(180);
        a.setType(ArcType.ROUND);

        Arc a2 = new Arc();
        a2.setCenterX(170);
        a2.setCenterY(100);
        a2.setRadiusX(50);
        a2.setRadiusY(50);
        a2.setStartAngle(0);
        a2.setLength(180);
        a2.setType(ArcType.ROUND);

        Polygon tri = new Polygon();
        tri.getPoints().addAll(new Double[]{
                220.0, 100.0, //right point
                125.0, 200.0, //Center Point
                30.0, 100.0 }); //left point

         */
        int[] radis = new int[]{20,25,26,30,25, 32, 22, 28, 32, 35, 27, 21, 19,17, 18, 19, 20, 21, 22, 23, 24, 16, 32, 22,35, 20, 15, 27,30};
        Group hearts = new Group();
        for(int x : radis){
            Arc a1 = new Arc();
            a1.setCenterX(100);
            a1.setCenterY(100);
            a1.setRadiusX(x);
            a1.setRadiusY(x);
            a1.setStartAngle(0);
            a1.setLength(180);
            a1.setType(ArcType.ROUND);

            Arc a2 = new Arc();
            double a2x = 100 + ((x * 2)-10);
            a2.setCenterX(a2x);
            a2.setCenterY(100);
            a2.setRadiusX(x);
            a2.setRadiusY(x);
            a2.setStartAngle(0);
            a2.setLength(180);
            a2.setType(ArcType.ROUND);

            Polygon tri = new Polygon();
            tri.getPoints().addAll(new Double[]{
                    a2x + x, 100.0, //right point
                    ((100.0 + x) + (a2x - x))/2, (x *2.0) + 100.0, //Center Point
                    100.0 - x, 100.0 }); //left point

            javafx.scene.shape.Shape heart = javafx.scene.shape.Shape.union(a1, a2);
            heart = javafx.scene.shape.Shape.union(heart, tri);

            heart.setFill(Color.RED);
            heart.setSmooth(true);
            heart.setStroke(Color.PALEVIOLETRED);
            heart.setStrokeWidth(4.0);
            hearts.getChildren().add(heart);
        }




        /*
        //Small Heart
        Arc a3 = new Arc();
        a3.setCenterX(5);
        a3.setCenterY(5);
        a3.setRadiusX(25);
        a3.setRadiusY(25);
        a3.setStartAngle(0);
        a3.setLength(180);
        a3.setType(ArcType.ROUND);
        a3.setFill(Color.BLACK);

        Arc a4 = new Arc();
        a4.setCenterX(45);
        a4.setCenterY(5);
        a4.setRadiusX(25);
        a4.setRadiusY(25);
        a4.setStartAngle(0);
        a4.setLength(180);
        a4.setType(ArcType.ROUND);
        a4.setFill(Color.BLACK);




        Polygon tri2 = new Polygon();
        tri.getPoints().addAll(new Double[]{
                220.0, 100.0, //right point
                125.0, 200.0, //Center Point
                30.0, 100.0 }); //left point



        javafx.scene.shape.Shape heart = javafx.scene.shape.Shape.union(a, a2);
        heart = javafx.scene.shape.Shape.union(heart, tri);

        javafx.scene.shape.Shape heart2 = javafx.scene.shape.Shape.union(a3, a4);

         */



        //c1.setFill(Color.RED);
        //c2.setFill(Color.BLUE);

        //c1.setCenterX(100);
        //c1.setCenterY(100);
        //c2.setCenterX(150);
        //c2.setCenterY(100);

        //Group g = new Group();
        //g.getChildren().addAll(a, a2, tri);
        root.getChildren().addAll(hearts);
        /*
        StackPane.setAlignment(h1, Pos.CENTER_LEFT);
        StackPane.setAlignment(h2, Pos.CENTER_RIGHT);
        StackPane.setAlignment(h3, Pos.BOTTOM_CENTER);

         */







        /*
        //Creating Translate Transition
        TranslateTransition translateTransition = new TranslateTransition();

        //Setting the duration of the transition
        translateTransition.setDuration(Duration.millis(4000));

        //Setting the node for the transition
        translateTransition.setNode(heart);

        //Setting the value of the transition along the x axis.
        translateTransition.setByY(-200);
        Random r = new Random();
        translateTransition.setByX(r.nextInt(100 - (-100)) + (-100) );
        //Setting the cycle count for the transition
        translateTransition.setCycleCount(50);

        //Setting auto reverse value to false
        translateTransition.setAutoReverse(true);

        //Playing the animation
        translateTransition.play();

         */



        Random r = new Random();
        Timeline timeline = new Timeline();
        for (Node heart: hearts.getChildren()) {
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO, // set start position at 0
                            new KeyValue(heart.translateXProperty(), r.nextInt(800 - (-100) + (-100))),
                            new KeyValue(heart.translateYProperty(), r.nextInt(800 - (-100) + (-100)))
                    ),
                    new KeyFrame(new Duration(40000), // set end position at 40s
                            new KeyValue(heart.translateXProperty(), r.nextInt(800 - (-100) + (-100))),
                            new KeyValue(heart.translateYProperty(), r.nextInt(800 - (-100) + (-100)))
                    )
            );
        }


        timeline.play();



        text.toFront();
        Scene s = new Scene(root, 800, 600);
        primaryStage.setScene(s);






        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
