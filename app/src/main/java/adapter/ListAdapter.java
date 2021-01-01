package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.todolist.todolist.R;
import com.todolist.todolist.ui.AuthActivity;
import com.todolist.todolist.ui.DetailsActivity;
import com.todolist.todolist.ui.SplashActivity;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.TaskVh> {

    Context context;
    ArrayList<ToDoLists> toDoList;

    public ListAdapter(Context context, ArrayList<ToDoLists> toDoList) {
        this.context = context;
        this.toDoList = toDoList;
    }

    @NonNull
    @Override
    public TaskVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false);
        return new TaskVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskVh holder, int position) {
        ToDoLists toDoLists = toDoList.get(position);
        holder.nameList.setText(toDoLists.getNameList());
        holder.numTask.setText(Integer.toString(toDoLists.getNumTask()));
        holder.listRowRelative.setOnClickListener(v -> {
            context.startActivity(new Intent(context, DetailsActivity.class));
        });

    }

    @Override
    public int getItemCount() {
        return toDoList.size();
    }

    public class TaskVh extends RecyclerView.ViewHolder {

        AppCompatTextView nameList, numTask;
        RelativeLayout listRowRelative;
        public TaskVh(@NonNull View itemView) {
            super(itemView);
            nameList = itemView.findViewById(R.id.list_name);
            numTask = itemView.findViewById(R.id.tasks_num);
            listRowRelative = itemView.findViewById(R.id.listRowRelative);
        }
    }
}
