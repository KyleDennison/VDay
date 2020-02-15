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
        primaryStage.setTitle("Valentines Day Presentation");

        //Setting up the Pink Background
        StackPane root = new StackPane();
        BackgroundFill mPinkBackground = new BackgroundFill(javafx.scene.paint.Color.PINK, CornerRadii.EMPTY, Insets.EMPTY);
        Background mBackground = new Background(mPinkBackground);
        root.setBackground(mBackground);

        //Creating the text
        Font mFont = javafx.scene.text.Font.font("Toppan Bunkyu Gothic", FontWeight.BOLD ,30 );
        Text mText = new Text("Happy Valentines Day !");
        mText.setFont(mFont);
        mText.setFill(Color.PURPLE);

        //Placing the text
        mText.setTextAlignment(TextAlignment.CENTER);
        root.getChildren().addAll( mText);
        StackPane.setAlignment(mText, Pos.CENTER);

        //Creating the list of hearts
        int[] mRadius = new int[]{20,25,26,30,25, 32, 22, 28, 32, 35, 27, 21, 19,17, 18, 19, 20, 21, 22, 23, 24, 16, 32, 22,35, 20, 15, 27,30};
        Group mHearts = new Group();
        for(int x : mRadius){
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
            mHearts.getChildren().add(heart);
        }
        root.getChildren().addAll(mHearts);



        //Animating the hearts
        Random r = new Random();
        Timeline timeline = new Timeline();
        for (Node heart: mHearts.getChildren()) {
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



        mText.toFront();
        Scene s = new Scene(root, 800, 600);
        primaryStage.setScene(s);






        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
