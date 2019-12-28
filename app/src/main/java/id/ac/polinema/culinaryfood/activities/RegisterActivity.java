package id.ac.polinema.culinaryfood.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import id.ac.polinema.culinaryfood.R;
import id.ac.polinema.culinaryfood.adapters.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText email, pass, cpass;
    Button reg;
    TextView mTextViewLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        email = findViewById(R.id.edittext_username);
        pass = findViewById(R.id.edittext_password);
        cpass = findViewById(R.id.edittext_conf_password);
        reg = findViewById(R.id.button_register);
        mTextViewLogin = findViewById(R.id.textview_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(LoginIntent);
                finish();
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = email.getText().toString().trim();
                String p = pass.getText().toString().trim();
                String cp = cpass.getText().toString().trim();
                if (e.equals("") || p.equals("") || cp.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    if(p.equals(cp)){
                        long val = db.adduser(e,p);
                        if(val > 0){
                            Toast.makeText(RegisterActivity.this,"You have registered",Toast.LENGTH_SHORT).show();
                            Intent moveToLogin = new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(moveToLogin);
                            finish();
                        }
                        else{
                            Toast.makeText(RegisterActivity.this,"Registeration Error",Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
