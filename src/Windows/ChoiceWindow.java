package Windows;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Correia on 24/06/2017.
 */
public class ChoiceWindow {

    private static boolean answer;

    public static boolean display(String title, String prompt) {
        Stage promptStage = new Stage();
        promptStage.setTitle(title);
        promptStage.initModality(Modality.APPLICATION_MODAL);

        //Layout
        VBox layout = new VBox();
        Label label = new Label(prompt);

        Button yes = new Button("Yes");
        yes.setOnAction(e-> answer = true);

        Button no = new Button("No");
        yes.setOnAction(e-> answer = false);

        layout.getChildren().addAll(label,yes,no);

        //Scene
        Scene promptScene = new Scene(layout, 300, 300);

        promptStage.setScene(promptScene);
        promptStage.showAndWait();


        return answer;

    }
}


