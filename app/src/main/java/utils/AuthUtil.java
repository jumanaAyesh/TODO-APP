package utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import helperclass.MyFragmentManager;

public class AuthUtil {

    private final String TAG = "AuthUtil";

    private static final AuthUtil instance = new AuthUtil();


    //make the constructor private so that this class cannot be
    //instantiated
    private AuthUtil(){}

    //Get the only object available
    public static AuthUtil getInstance(){
        return instance;
    }

    private final FirebaseAuth mAuth  = FirebaseAuth.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    public Boolean getCurrentUser(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        return user != null;
    }

    public void singUp(String email, String password,Activity activity, CallBackAuth callBack){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        callBack.onComplete(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        callBack.onComplete(null);
                    }

                    // ...
                });
    }

    public void singIn(String email, String password,Activity activity, CallBackAuth callBack){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        callBack.onComplete(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        callBack.onComplete(null);
                        // ...
                    }

                    // ...
                });
    }

    public interface CallBackAuth {
        // this can be any type of method
        void onComplete(FirebaseUser account);
    }
}
