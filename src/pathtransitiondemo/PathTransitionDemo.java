/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathtransitiondemo;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.WHITE;
import static javafx.scene.paint.Color.YELLOW;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author chris
 */
public class PathTransitionDemo extends Application {
    
    Circle circulo = new Circle(125, 100, 50);
    Rectangle cuadrado = new Rectangle(30,60);
    
    @Override
    public void start(Stage primaryStage) {
        
        circulo.setFill(WHITE);
        circulo.setStroke(BLACK);
        circulo.setCenterX(150);
        circulo.setCenterY(125);
        
        cuadrado.setFill(YELLOW);
        //cuadrado.setX(circulo.getCenterX() - circulo.getRadius() - cuadrado.getWidth()/2);
        //cuadrado.setY(circulo.getCenterY() - cuadrado.getHeight()/2);
        
        Pane root = new Pane();
        root.getChildren().add(circulo);
        root.getChildren().add(cuadrado);
        
        // Create a path transition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(circulo);
        pt.setNode(cuadrado);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(false);
        pt.play();// Start animation
        circulo.setOnMousePressed(e->pt.pause());
        circulo.setOnMouseReleased(e->pt.play());
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Path Transition");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
