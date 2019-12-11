package id.ac.polinema.culinaryfood.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import id.ac.polinema.culinaryfood.R;

public class detailActivity extends AppCompatActivity {

    private static final String TAG = "detailActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Log.d(TAG,"onCreate: started.");
        getIncomingIntent();

    }

    public void click_detail(View view)
    {
        Intent intent = new Intent(this,detailActivity.class);
        startActivity(intent);
    }

    private void getIncomingIntent()
    {
        if(getIntent().hasExtra("name"))
        {
            String name = getIntent().getStringExtra("name");

            TextView TVname = findViewById(R.id.name);
            TVname.setText(name);
        }
    }
}
