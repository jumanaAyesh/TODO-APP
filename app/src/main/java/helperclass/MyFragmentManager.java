package helperclass;

import android.content.Context;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.todolist.todolist.R;

public class MyFragmentManager {

    private static MyFragmentManager instance = new MyFragmentManager();


    //make the constructor private so that this class cannot be
    //instantiated
    private MyFragmentManager(){}

    //Get the only object available
    public static MyFragmentManager getInstance(){
        return instance;
    }


    public void switchFragment(Fragment fragment, int id, Context context) {
        ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction()
                .replace(id, fragment).addToBackStack(null)
                .commit();
    }

    public void switchFragmentWithoutBack(Fragment fragment, int id, Context context) {
        ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction()
                .replace(id, fragment)
                .commit();
    }

    public void finishFragment(Context context){
        ((AppCompatActivity)context).onBackPressed();
    }

}
