package id.ac.polinema.culinaryfood.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import id.ac.polinema.culinaryfood.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handlerClickBlitar(View view) {
    }

    public void handlerClickSurabaya(View view) {
    }

    public void handlerClickMalang(View view) {
        Intent intent = new Intent(this,MalangActivity.class);
        startActivity(intent);
    }

    public void handlerClickJogja(View view) {
    }
}
