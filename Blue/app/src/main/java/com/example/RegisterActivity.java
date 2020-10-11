package com.example.blue_11;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private EditText UserEmail, UserPassword, UserConfirmPassword;
    private Button CreateAcountButton;
    private ProgressDialog loadingBar;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth= FirebaseAuth.getInstance();

        UserEmail=(EditText) findViewById(R.id.register_email);
        UserPassword=(EditText) findViewById(R.id.register_password);
        UserConfirmPassword=(EditText) findViewById(R.id.register_confirm_password);
        CreateAcountButton=(Button) findViewById(R.id.register_create_account);
        loadingBar=new ProgressDialog(this);

        CreateAcountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateNewAccount();
            }
        });
    }

    private void CreateNewAccount(){
        String email= UserEmail.getText().toString();
        String password= UserPassword.getText().toString();
        String confirmPassword= UserConfirmPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),"Please enter a valid Email Address",Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please fill in the Password Field", Toast.LENGTH_SHORT).show();
        }
            else if (TextUtils.isEmpty(confirmPassword)){
                Toast.makeText(getApplicationContext(),"Please fill in the Confirm Password Field",Toast.LENGTH_SHORT).show();
            }

            else if(!password.equals(confirmPassword)) {
            Toast.makeText(getApplicationContext(), "Check that your Password and Confirmed Password are the same", Toast.LENGTH_SHORT).show();
            }

            else{

                loadingBar.setTitle("Creating New Account");
                loadingBar.setMessage("Please wait while we authenticate your account");
                loadingBar.show();
                loadingBar.setCanceledOnTouchOutside(true);
                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            SendUserToSetupActivity();
                            Toast.makeText(RegisterActivity.this,"Your account has been authenticated successfully",Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();
                        }
                        else{
                            String message= task.getException().getMessage();
                            Toast.makeText(RegisterActivity.this,"Error occurred: "+message,Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();
                        }
                    }
                });
        }

        }

    private void SendUserToSetupActivity() {
    Intent setupIntent= new Intent(RegisterActivity.this, SetupActivity.class);
    setupIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
    startActivity(setupIntent);
    finish();

    }
}

