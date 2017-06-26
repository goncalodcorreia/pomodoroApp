package Windows;

import Functionality.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.applet.Main;

import java.util.LinkedList;

/**
 * Created by Correia on 24/06/2017.
 */
public class TaskCreationWindow {

    private static Task taskMade;

    public static Task display(){
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

        Button submit = new Button("Submit");
        GridPane.setConstraints(submit,1,3);
        submit.setOnAction(e->
                taskMade = validateInfo(taskNameInsert.getText(),defaultPomodoroInsert.getText(),tagsInsert.getText()));


        layout.getChildren().addAll(taskName,taskNameInsert,defaultPomodoro,defaultPomodoroInsert,tags,tagsInsert,submit);

        Scene scene = new Scene(layout,400,300);

        taskStage.setScene(scene);
        taskStage.showAndWait();

        return taskMade;


    }
    //Function still has problems validating repeated tagnames. I believe that happens because i'm not updating the taskList in this function
    public static Task validateInfo(String taskName,String defaultPomodoros,String tags){
            String tempTaskName;
            int tempDefPomodoro;
            String[] auxTags = tags.trim().split(";");

            LinkedList<String> temptags = new LinkedList<String>();
            for(Task x : MainWindow.getINSTANCE().getTasks()) {
                if (x.getTaskName().equalsIgnoreCase(taskName)) {
                    AlarmWindow.display("Error", "Task already exists!");
                    return null;

                }
            }
            tempTaskName = taskName;

            try{
                tempDefPomodoro = Integer.parseInt(defaultPomodoros);
            }catch(NumberFormatException e){
                AlarmWindow.display("Error", "Amount of default pomodoros is not valid!");
                return null;
            }
            //Validate Tags
            for(int i = 0; i != auxTags.length; i++){
                if(!temptags.contains(auxTags[i])){
                    temptags.add(auxTags[i]);
                }
            }
        AlarmWindow.display("Sucess!", tempTaskName + "has been created!");
        return new Task(tempTaskName,tempDefPomodoro,0,temptags);
    }
}
