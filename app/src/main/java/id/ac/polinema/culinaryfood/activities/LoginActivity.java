package id.ac.polinema.culinaryfood.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import id.ac.polinema.culinaryfood.R;

public class LoginActivity extends AppCompatActivity {
    EditText email,pass;
    Button log;
    DatabaseHelper db;
    TextView mTextViewRegister;
    ViewGroup progressView;
    protected boolean isProgressShowing = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        Dialog dialog = new Dialog(this,android.R.style.Theme_Translucent_NoTitleBar);
//        View v = this.getLayoutInflater().inflate(R.layout.progress_bar,null);
//        dialog.setContentView(v);
//        dialog.show();
        db = new DatabaseHelper(this);
        email = findViewById(R.id.edittext_username);
        pass = findViewById(R.id.edittext_password);
        mTextViewRegister = findViewById(R.id.textview_register);
        log = findViewById(R.id.button_login);
        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = email.getText().toString().trim();
                String p = pass.getText().toString().trim();
                Boolean res = db.checkUser(e,p);
                if(res==true){
//                    Toast.makeText(getApplicationContext(),"Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
//                    Boolean insert = db.insert(e,p);
//                    if (insert==true){
////                        Toast.makeText(getApplicationContext(),"Login Successfully", Toast.LENGTH_SHORT).show();
//                        Intent i = new Intent(LoginActivity.this,MainActivity.class);
//                        startActivity(i);
//                    }
                }else {
                    Toast.makeText(getApplicationContext(),"Login Error ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
