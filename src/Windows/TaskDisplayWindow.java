package Windows;

import Functionality.Task;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Created by Correia on 24/06/2017.
 */
public class TaskDisplayWindow {

private GridPane layout;

    public GridPane display(Task task){
        GridPane layout = new GridPane();
        layout.setHgap(20);

        Label name = new Label(task.getTaskName());
        GridPane.setConstraints(name,0,0);

        Label defaultPomodoro = new Label(task.getDefaultPomodoros()+"");
        GridPane.setConstraints(defaultPomodoro,1,0);

        Label donePomodoro = new Label(task.getDonePomodoros()+"" );
        GridPane.setConstraints(donePomodoro,2,0);

        Button checkTags = new Button("Show Tags");
        GridPane.setConstraints(checkTags,3,0);


        Button delete = new Button("Delete");
        GridPane.setConstraints(delete,4,0);

        layout.getChildren().addAll(name,defaultPomodoro,donePomodoro,checkTags,delete);

        return layout;









    }

    public GridPane getLayout(){
        return layout;
    }
}
