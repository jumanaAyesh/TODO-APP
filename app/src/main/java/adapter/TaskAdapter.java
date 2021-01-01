package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.todolist.todolist.R;
import com.todolist.todolist.ui.DetailsActivity;
import com.todolist.todolist.ui.TaskDescriptionActivity;

import java.util.ArrayList;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskVh> {

    Context context;
    ArrayList<Task> taskArrayList;

    public TaskAdapter(Context context, ArrayList<Task> taskArrayList) {
        this.context = context;
        this.taskArrayList = taskArrayList;
    }

    @NonNull
    @Override
    public TaskVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.task_row, parent, false);
        return new TaskVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskVh holder, int position) {
        Task task = taskArrayList.get(position);
        holder.nameTask.setText(task.getTaskName());

        holder.taskRowRelative.setOnClickListener(v -> {
            context.startActivity(new Intent(context, TaskDescriptionActivity.class));
        });

//        list.remove(position);
//        recycler.removeViewAt(position);
//        mAdapter.notifyItemRemoved(position);
//        mAdapter.notifyItemRangeChanged(position, list.size());

    }

    @Override
    public int getItemCount() {
        return taskArrayList.size();
    }

    public class TaskVh extends RecyclerView.ViewHolder {

        CheckBox checkBox;
        AppCompatTextView nameTask;
        RelativeLayout taskRowRelative;
        public TaskVh(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.taskCheck);
            nameTask = itemView.findViewById(R.id.taskName);
            taskRowRelative = itemView.findViewById(R.id.taskRowRelative);
        }
    }
}
