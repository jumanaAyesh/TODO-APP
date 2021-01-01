package helperclass;

import android.view.View;
import android.widget.EditText;

import com.todolist.todolist.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
    private static EmailValidation instance = new EmailValidation();


    //make the constructor private so that this class cannot be
    //instantiated
    private EmailValidation(){}

    //Get the only object available
    public static EmailValidation getInstance(){
        return instance;
    }

    public boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
