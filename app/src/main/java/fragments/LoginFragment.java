package fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseUser;
import com.todolist.todolist.R;
import com.todolist.todolist.ui.MainActivity;

import java.util.Objects;

import helperclass.EmailValidation;
import helperclass.MyFragmentManager;
import utils.AuthUtil;


public class LoginFragment extends Fragment {

    private Button login;
    private AppCompatEditText loginEmail, loginPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        init(root);

        login.setOnClickListener(v -> {
            String email = Objects.requireNonNull(loginEmail.getText()).toString();
            String password = Objects.requireNonNull(loginPassword.getText()).toString();
            if (email!=null && password!=null && EmailValidation.getInstance().isEmailValid(email)){
                AuthUtil.getInstance().singIn(email, password,getActivity(), this::updateUI);
            }else Snackbar.make(getActivity().findViewById(android.R.id.content), "Enter Valid data", Snackbar.LENGTH_LONG).show();

        });

        AppCompatTextView createAccountFromLogin = root.findViewById(R.id.createAccountFromLogin);
        createAccountFromLogin.setOnClickListener(v -> {
            //getActivity().onBackPressed();
            MyFragmentManager.getInstance().finishFragment(getContext());
        });

        return root;
    }

    private void init(View root){
        login = root.findViewById(R.id.login);
        loginEmail = root.findViewById(R.id.loginEmail);
        loginPassword = root.findViewById(R.id.loginPassword);
    }

    public void updateUI(FirebaseUser account){

        if(account != null){
            Toast.makeText(getContext(),"U Signed In successfully",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getContext(), MainActivity.class));
            getActivity().finish();

        }else {
            //Toast.makeText(getContext(),"U Didnt signed in",Toast.LENGTH_LONG).show();
            Snackbar.make(getActivity().findViewById(android.R.id.content), "U dont have an account", Snackbar.LENGTH_LONG).show();
        }

    }
}