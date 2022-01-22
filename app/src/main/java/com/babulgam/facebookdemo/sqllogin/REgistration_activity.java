package com.babulgam.facebookdemo.sqllogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class REgistration_activity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameET,emailET,userET,passwordET;
    private Button signUpButton;
    private TextView signUpTextView;
    DabaseHelper databaseHelper;
    UserDetails userDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        nameET=findViewById(R.id.nameEditText_id);
        emailET=findViewById(R.id.emailEditText_id);
        userET=findViewById(R.id.usernameEditText_id);
        passwordET=findViewById(R.id.passwordEditText_id);
        signUpButton=findViewById(R.id.signUpButton_id);
        signUpTextView=findViewById(R.id.singUptextView_id);

        userDetails=new UserDetails();
        databaseHelper=new DabaseHelper(this);


        signUpButton.setOnClickListener(this);
        signUpTextView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String name=nameET.getText().toString();
        String email=emailET.getText().toString();
        String username=userET.getText().toString();
        String password=passwordET.getText().toString();



        if (v.getId()==R.id.signUpButton_id)
        {

            userDetails.setName(name);
            userDetails.setEmail(email);
            userDetails.setUsername(username);
            userDetails.setPassword(password);

            long rowid= databaseHelper.insertData(userDetails);

            if (rowid>0)
            {
                Toast.makeText(this, "Row "+rowid+" Is successfully inserted ", Toast.LENGTH_SHORT).show();
            }else
            {
                Toast.makeText(this, "Row inserted failed ", Toast.LENGTH_SHORT).show();
            }
            nameET.setText("");
            emailET.setText("");
            passwordET.setText("");
            userET.setText("");


        }
        if (v.getId()==R.id.singUptextView_id)
        {
            Intent intent=new Intent(getApplicationContext(), Login_Activity.class);
            startActivity(intent);

        }

    }
}
