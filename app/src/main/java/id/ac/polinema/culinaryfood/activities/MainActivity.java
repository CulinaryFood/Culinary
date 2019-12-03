package id.ac.polinema.culinaryfood.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

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
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.btnMalang);
        if(fragment == null){
            getSupportFragmentManager().beginTransaction()
//                    .setCustomAnimations(R.anim.enter_from_left,R.anim.enter_from_right)
                    .replace(R.id.btnMalang,new MalangFragment(), "SEARCH_FRAGMENT")
                    .addToBackStack(null)
                    .commit();
        }
    }

    public void handlerClickJogja(View view) {
    }
}
