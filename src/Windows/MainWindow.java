package Windows;

import Functionality.Task;
import Functionality.TaskIO;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sun.applet.Main;

import java.util.ArrayList;

import static javafx.application.Application.launch;

/**
 * Created by Correia on 23/06/2017.
 */
public class MainWindow extends Application{

    private Stage primaryStage;
    private Scene mainScene;
    private String name;
    private String style;
    private ArrayList<Task> tasks = new ArrayList<Task>();
    private final static MainWindow INSTANCE = new MainWindow();


    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception{
        //Setting up the Stage
        this.primaryStage = primaryStage;
        primaryStage.setTitle("PomodoroApp");

        //Choose Username
        setUsername();
        //Loads data if user exists
        loadData();

        //Define Layout and Stuff for the Layout
        BorderPane layout = new BorderPane();
        String style = "-fx-background-color: #336699";

        //Bottom
        Button quickStart = new Button("QuickStart");
        Button newPomodoro = new Button("New Pomodoro");
        Button statistics = new Button ("Statistics");
        Button settings = new Button ("Settings");


        HBox botLayout = new HBox();
        botLayout.setPadding(new Insets(10,20,15,20));
        botLayout.setSpacing(10);

        botLayout.setStyle(style);
        botLayout.getChildren().addAll(quickStart,newPomodoro,statistics,settings);

        //Top
        HBox topLayout = new HBox();
        topLayout.setPadding(new Insets(10,10,15,20));
        topLayout.setAlignment(Pos.CENTER);
        Label label = new Label(name +"'s" +  "Task List : ");



        //Center
        VBox centerLayout = new VBox();
        if(tasks != null) {
                HBox auxiliaryLayout = new HBox();
                HBox.setMargin(auxiliaryLayout,new Insets(10,10,10,10));
                Label taskName = new Label("Name:");
                Label defaultPomodoros = new Label("Default Pomodoros");
                Label donePomodoros = new Label("Done Pomdoros");
                Label tags = new Label("Tags");

                auxiliaryLayout.getChildren().addAll(taskName,defaultPomodoros,donePomodoros,tags);
                centerLayout.getChildren().add(auxiliaryLayout);

            for (int i = 0; i < tasks.size(); i++) {
                Node toadd = new TaskDisplayWindow().display(tasks.get(i));
                centerLayout.getChildren().add(toadd);
            }


        }else{
            tasks = new ArrayList<Task>();
            Label noTasks = new Label("You have no tasks!");
            noTasks.setAlignment(Pos.CENTER);

            //This code shouldn't be as stated. i need to change this.
            Button addTasks = new Button("Add Task");
            addTasks.setOnAction(e ->{
                Task x = TaskCreationWindow.display();
                if(x != null){
                    tasks.add(x);
                    System.out.println(tasks);

                }
            });
            
            centerLayout.getChildren().addAll(noTasks,addTasks);
        }



        topLayout.setStyle(style);
        topLayout.getChildren().add(label);



        layout.setBottom(botLayout);
        layout.setTop(topLayout);
        layout.setCenter(centerLayout);


        //Setting up the Scene
        mainScene = new Scene(layout,500,500);
        primaryStage.setScene(mainScene);
        primaryStage.show();

    }


    private void setUsername(){
        //Setup Username
        while(name == null || name.isEmpty()) {
            name = Windows.PromptWindow.display("Login", "Username:","username");
        }

    }

    private void loadData(){
        TaskIO  t = new TaskIO();
        tasks = t.readTaskList(name.trim()+ ".txt");

        if(tasks == null){
            AlarmWindow.display("New User","Welcome aboard, " + name + " enjoy the App!");
        }else{
            AlarmWindow.display("Welcome back", "Hi " + name + ", Glad to see you back!");
        }

    }
    public static MainWindow getINSTANCE(){
        return INSTANCE;
    }

    public ArrayList<Task> getTasks(){ return tasks; }


}
