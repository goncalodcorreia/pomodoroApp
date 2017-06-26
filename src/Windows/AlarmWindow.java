package Windows;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.plugin2.main.client.ModalityInterface;

import java.awt.event.KeyEvent;

/**
 * Created by Correia on 25/06/2017.
 */
public class AlarmWindow {

    public static void display(String title, String text){
        //Stage
        Stage primaryStage = new Stage();
        primaryStage.setTitle(title);
        primaryStage.initModality(Modality.APPLICATION_MODAL);

        //Layout and Components
        VBox layout = new VBox();

        Label label = new Label(text);

        Button button = new Button("Close");
        button.setAlignment(Pos.CENTER);
        button.setOnAction(e-> primaryStage.close());



        layout.getChildren().addAll(label,button);
        layout.setPadding(new Insets(20,10,10,10));


        Scene primaryScene = new Scene(layout,300,250);

        primaryScene.setOnKeyPressed(e -> primaryStage.close());

        primaryStage.setScene(primaryScene);
        primaryStage.showAndWait();


    }
}
