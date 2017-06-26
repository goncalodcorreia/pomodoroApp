package Windows;

import Functionality.Task;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Correia on 24/06/2017.
 */
public class TaskCreationWindow {

    private Task taskMade;

    public static void display(){
        //Stage
        Stage taskStage = new Stage();
        taskStage.setTitle("New Task");
        taskStage.initModality(Modality.APPLICATION_MODAL);

        GridPane layout = new GridPane();

        Label taskName = new Label("Task Name : ");
        GridPane.setConstraints(taskName,0,0);

        TextField taskNameInsert = new TextField();
        taskNameInsert.setPromptText("task name");
        GridPane.setConstraints(taskNameInsert,1,0);

        taskNameInsert.setOnAction(e -> {
            taskNameInsert.getText();
        });



        Label defaultPomodoro = new Label("How many Pomodoros? ");
        GridPane.setConstraints(defaultPomodoro,0,1);


        TextField defaultPomodoroInsert = new TextField();
        defaultPomodoroInsert.setPromptText("amount of pomodoros");
        GridPane.setConstraints(defaultPomodoroInsert,1,1);


        Label tags = new Label("Insert tags (Separate using \";\")");
        GridPane.setConstraints(tags,0,2);

        TextField tagsInsert = new TextField();
        tagsInsert.setPromptText("tag names");
        GridPane.setConstraints(tagsInsert,1,2);


        layout.getChildren().addAll(taskName,taskNameInsert,defaultPomodoro,defaultPomodoroInsert,tags,tagsInsert);

        Scene scene = new Scene(layout,400,300);

        taskStage.setScene(scene);
        taskStage.showAndWait();


    }
}
