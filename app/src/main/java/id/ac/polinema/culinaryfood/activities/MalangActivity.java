package id.ac.polinema.culinaryfood.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;

import id.ac.polinema.culinaryfood.R;
import id.ac.polinema.culinaryfood.adapters.Adapters;
import id.ac.polinema.culinaryfood.models.RestoModel;

public class MalangActivity extends AppCompatActivity {
    private ArrayList<RestoModel> restoModels;
    private RecyclerView recyclerView;
    private Adapters adapters;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malang);

        Bundle extras = getIntent().getExtras();
        String code="";

        if(extras!=null)
        {
            code = extras.getString("kode_resto");
        }


        //String code = args.putString("Judul", getIntent().getExtras().getString("Judul"));

        if(code.equals("malang"))
        {
            resto_malang();
        }
        else if(code.equals("jogja"))
        {
            resto_jogja();
        }
        buildRecyclerView();
    }
    private void filter(String text) {
        ArrayList<RestoModel> filteredList = new ArrayList<>();

        for (RestoModel item : restoModels) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }

        adapters.filterList(filteredList);
    }
    public void resto_malang(){

        restoModels = new ArrayList<>();
        restoModels.add(new RestoModel(R.drawable.solaria, "Solaria", " Kawi St No.24, 3, Kauman, Klojen, Malang City, East Java 65119"));
        restoModels.add(new RestoModel(R.drawable.bensu, "Geprek Bensu", "Ruko Grand Suhat No, Jl. Soekarno Hatta No.6, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141"));
        restoModels.add(new RestoModel(R.drawable.nelongso, "Ayam Nelongso", "Jl. Dieng, Sumberjo, Kalisongo, Kec. Dau, Malang, Jawa Timur 65116"));
    }

    public void resto_jogja(){

        restoModels = new ArrayList<>();
        restoModels.add(new RestoModel(R.drawable.solaria, "Solaria", " Kawi St No.24, 3, Kauman, Klojen, Malang City, East Java 65119"));
        restoModels.add(new RestoModel(R.drawable.bensu, "Geprek Bensu", "Ruko Grand Suhat No, Jl. Soekarno Hatta No.6, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141"));

    }

    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapters = new Adapters(restoModels);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapters);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_check, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapters.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
