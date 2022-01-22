package com.babulgam.facebookdemo.sqllogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {
    DabaseHelper dataseHelper;
    private Button signInButton;
    private TextView signIntextView;
    private EditText usernameEditText;
    private EditText passwordEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataseHelper=new DabaseHelper(this);
        SQLiteDatabase sqLiteDatabase=dataseHelper.getWritableDatabase();

        signInButton=findViewById(R.id.loginButton_id);
        signIntextView=findViewById(R.id.signInTextView_id);
        usernameEditText=findViewById(R.id.UserIdedittext_id);
        passwordEditText=findViewById(R.id.Userpasswordedittext_id);


        signInButton.setOnClickListener(this);
        signIntextView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String username=usernameEditText.getText().toString();
        String password=passwordEditText.getText().toString();

        if (v.getId()==R.id.loginButton_id)
        {
            Boolean result=dataseHelper.findpassword(username,password);

            if (result==true)
            {

                Intent intent=new Intent(getApplicationContext(),Result_Activity.class);
                startActivity(intent);
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Don't Match Username Or Password", Toast.LENGTH_SHORT).show();
            }




        }
        if (v.getId()==R.id.signInTextView_id)
        {
            Intent intent=new Intent(Login_Activity.this,REgistration_activity.class);
            startActivity(intent);
        }
    }
}
