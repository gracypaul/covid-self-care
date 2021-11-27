package com.example.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity1 extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText phone;
    EditText Email;
    Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        Email = findViewById(R.id.Email);
        signup = findViewById(R.id.signupbtn);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDataEntered();
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered(){
        if (isEmpty(username)) {
            Toast t = Toast.makeText(this, "You must enter username to register!", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(password)) {
            password.setError("Last name is required!");
        }
        if (isEmail(Email) == false) {
            Email.setError("Enter valid email!");
        }
    }

}
