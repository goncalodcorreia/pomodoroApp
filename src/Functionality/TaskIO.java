package Functionality;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Correia on 24/06/2017.
 */
public class TaskIO {
//Should it be a Singleton?

    //private static ArrayList<Task> tasks = new ArrayList<>();

    public  ArrayList<Task> readTaskList(String fileName){
        ArrayList<Task> tasks = new ArrayList<>();
        try{
            File f = new File("C:\\Users\\Correia\\Dropbox\\JavaProjects\\PomodoroApp\\" + fileName);
            Scanner scan = new Scanner(f);
            while(scan.hasNextLine()) {
                String[] tokens = scan.nextLine().trim().split(";");
                try {
                    String taskName = tokens[0];
                    int defaultPomodoros = Integer.parseInt(tokens[1]);
                    int donePomodoros = Integer.parseInt(tokens[2]);

                    LinkedList<String> tags = new LinkedList<String>();

                    for (int i = 3; i != tokens.length; i++) {
                        if (!tags.contains(tokens[i]))
                            tags.add(tokens[i]);
                    }

                    Task madeTask = new Task(taskName, defaultPomodoros, donePomodoros, tags);
                    tasks.add(madeTask);

                } catch (NumberFormatException e) {
                    //Do Nothing

                }

            }
            scan.close();
            }catch(FileNotFoundException e){
                return null;

            }
            return tasks;
        }

    public void write(String fileName, ArrayList<Task> tasks){
            try{
                PrintWriter pw = new PrintWriter(new File(fileName));
                for(Task x : tasks){
                    pw.write(x.getTaskName() + ";");
                    pw.write(x.getDefaultPomodoros()+";");
                    pw.write(x.getDonePomodoros() + ";");
                    System.out.println("hehe");
                    for(String y : x.getTags()){
                        pw.write(y+";");
                    }
                }
                pw.close();
            }catch(FileNotFoundException e){

            }
        }

//        public static void main(String[] args){
//
//        TaskIO stuff = new TaskIO();
//        stuff.readTaskList("Tasks.txt");
//        for(int i = 0; i != tasks.size(); i++){
//            if(tasks != null) {
//                System.out.println(tasks.get(i).getTags());
//            }
//        }
//        stuff.write("Tasks.txt");
//        }
    }


