package gui;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.*;

public class TestFX extends Application
{
    public void start( Stage primaryStage )
    {
        GridPane pane = new GridPane();
        Label label = new Label("Geef je naam in: ");
        TextField invoer = new TextField();
        Text uitvoer = new Text();
        pane.add(label,0,0);
        pane.add(invoer,0,1);
        pane.add(uitvoer,0,2);
        pane.setLayoutX(10);
        pane.setLayoutY(10);

        invoer.setOnAction(eventInvoer -> {
            uitvoer.setText("Welkom " + invoer.getText() + " bij je eerste stappen met JavaFx");
        });

        Scene scene = new Scene(pane,500,350);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setTitle("Dit is een JavaFx test");
    }

    public static void main( String[] args )
    {
        launch();
    }
}