package id.ac.polinema.culinaryfood.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import id.ac.polinema.culinaryfood.R;
import id.ac.polinema.culinaryfood.adapters.Adapters;
import id.ac.polinema.culinaryfood.adapters.NewAdapters;
import id.ac.polinema.culinaryfood.models.MenuModel;
import id.ac.polinema.culinaryfood.models.RestoModel;

public class MenuActivity extends AppCompatActivity {

    private ArrayList<MenuModel> menuModels;
    private RecyclerView recyclerView;
    private NewAdapters newAdapters;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle extras = getIntent().getExtras();
        String code="";

        if(extras!=null)
        {
            code = extras.getString("kode_resto");
        }


        //String code = args.putString("Judul", getIntent().getExtras().getString("Judul"));

        if(code.equals("jejemuran"))
        {
            resto_jejemuran();
        }

        buildRecyclerView();
    }

    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        newAdapters = new NewAdapters(menuModels);


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(newAdapters);
    }

    private void resto_jejemuran() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.jejamuran,"ayam goreng","Rp.50000"));
    }
}
