package fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.todolist.todolist.R;
import com.todolist.todolist.ui.AuthActivity;
import com.todolist.todolist.ui.MainActivity;
import com.todolist.todolist.ui.SplashActivity;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import helperclass.EmailValidation;
import helperclass.MyFragmentManager;
import utils.AuthUtil;


public class SingUpFragment extends Fragment {

    String TAG= "SingUpFragment";
    Button button;
    AppCompatTextView haveAccountLogin;
    AppCompatEditText singUpPassword, singUpEmail;
    FirebaseAuth mAuth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_sing_up, container, false);
        init(root);

        button.setOnClickListener(v -> {
            String email = Objects.requireNonNull(singUpEmail.getText()).toString();
            String password = singUpPassword.getText().toString();
            if (email!=null && password!=null && EmailValidation.getInstance().isEmailValid(email)){
                AuthUtil.getInstance().singUp(email, password,getActivity(), this::updateUI);
            }else Snackbar.make(getActivity().findViewById(android.R.id.content), "Enter Valid data", Snackbar.LENGTH_LONG).show();


        });


        haveAccountLogin.setOnClickListener(v ->
                MyFragmentManager.getInstance().switchFragment(new LoginFragment(),R.id.auth_frame,getContext())
        );




        return root;
    }


    public void init(View root){
        button = root.findViewById(R.id.btn);
        haveAccountLogin = root.findViewById(R.id.haveAccountLogin);
        singUpPassword = root.findViewById(R.id.singUpPassword);
        singUpEmail = root.findViewById(R.id.singUpEmail);
        mAuth = FirebaseAuth.getInstance();
    }




    public void updateUI(FirebaseUser account){

        if(account != null){
            Toast.makeText(getContext(),"U Signed In successfully",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getContext(), MainActivity.class));
            getActivity().finish();
        }else {
            //Toast.makeText(getContext(),"U Didnt signed in",Toast.LENGTH_LONG).show();
            Snackbar.make(getActivity().findViewById(android.R.id.content), "U Didnt signed in", Snackbar.LENGTH_LONG).show();
        }

    }


}