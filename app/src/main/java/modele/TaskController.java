package modele;

import java.util.ArrayList;
import java.util.List;

public class TaskController{
    private List<Task> taskList;
    public TaskController() {
        taskList=new ArrayList<>();
    }
    public void addTask(String title, String description){
        Task task = new Task(title,description);
        taskList.add(task);
    }
    public List<Task>getTasks(){
        return taskList;
    }
    public void updateTask(int index,String title,String description){
        if(index >= 0 && index < taskList.size()){
            Task task =taskList.get(index);
            task.setTitle(title);
            task.setDescription(description);
        }
    }
}
