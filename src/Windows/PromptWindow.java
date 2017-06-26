package Windows;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Correia on 23/06/2017.
 */
public class PromptWindow{

    private static String name;

    public static String display(String title, String promptText,String prompt){
        Stage promptStage = new Stage();
        promptStage.setTitle(title);
        promptStage.initModality(Modality.APPLICATION_MODAL);

        //Layout
        VBox layout = new VBox();

        Label text = new Label(promptText);

        TextField answer = new TextField();
        answer.setPromptText(prompt);

        answer.setOnAction(e -> {
            name = answer.getText();
            promptStage.close();

        });

        layout.getChildren().addAll(text,answer);
        layout.setPadding(new Insets(20,10,10,10));

        Scene promptScene = new Scene(layout,250,250);
        promptStage.setScene(promptScene);
        promptStage.showAndWait();

        return name;
    }


}
