package ma.ofppt.a22octnewprojetmcv;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import modele.Task;
import modele.TaskController;

public class MainActivity extends AppCompatActivity {
    private TaskController taskController;
    private EditText titleInput, descriptionInput;
    private TextView taskListDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        taskController=new TaskController();

        titleInput=findViewById(R.id.titleInput);
        descriptionInput=findViewById(R.id.descriptionInput);
        taskListDisplay=findViewById(R.id.taskListDisplay);
        Button addButton=findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleInput.getText().toString();
                String description = descriptionInput.getText().toString();
                taskController.addTask(title,description);
                displayTask();

            }
        });
    }
    private void displayTask(){
        List<Task>tasks = taskController.getTasks();
        StringBuilder taskListDisplay = new StringBuilder();

        for(Task task: tasks){
            taskListDisplay.append("Title:").append(task.getTitle()).append("\n")
                    .append("Description: ").append(task.getDescription()).append("\n\n");
            taskListDisplay.substring(Integer.parseInt(taskListDisplay.toString()));
        }
    }
}

