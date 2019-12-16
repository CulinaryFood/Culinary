package id.ac.polinema.culinaryfood.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import java.util.ArrayList;

import id.ac.polinema.culinaryfood.R;
import id.ac.polinema.culinaryfood.adapters.NewAdapters;
import id.ac.polinema.culinaryfood.models.MenuModel;

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
        String code="" , code_daerah="";

        if(extras!=null)
        {
            code_daerah = extras.getString("code_daerah");
            code = extras.getString("kode_resto");
        }


        //String code = args.putString("Judul", getIntent().getExtras().getString("Judul"));

        if(code_daerah.equals("jogja"))
        {
           if(code.equals("jejamuran"))
           {
               resto_jejamuran();
           }

           else if(code.equals("pelem_golek"))
           {
               resto_pelem_golek();
           }
           else if(code.equals("ledok_garden"))
           {
                ledok_garden();
           }

        }
        else if(code_daerah.equals(("malang")))
        {
            if(code.equals("solaria"))
            {
                resto_solaria();
            }

            else if(code.equals("bensu"))
            {
                resto_bensu();
            }
            else if(code.equals("nelongso"))
            {
                resto_nelongso();
            }
        }
        else if(code_daerah.equals(("surabaya")))
        {
            if(code.equals("asian_king"))
            {
                resto_asian_king();
            }

            else if(code.equals("primarasa"))
            {
                resto_primarasa();
            }
            else if(code.equals("khayangan"))
            {
                resto_khayangan();
            }
        }
        else if(code_daerah.equals(("blitar")))
        {
            if(code.equals("warung_mak_nyak"))
            {
                resto_warung_mak_nyak();
            }

            else if(code.equals("rm_joglo"))
            {
                resto_rm_joglo();
            }
            else if(code.equals("soto_kudus"))
            {
                resto_soto_kudus();
            }
        }

        buildRecyclerView();
    }
    //blitar
    private void resto_soto_kudus() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.soto1,"Menu Soto Kudus Blitar.","Rp."));
        menuModels.add(new MenuModel(R.drawable.jejamuran8,"Teh Panas","Rp.3000"));
    }

    private void resto_rm_joglo() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.joglo2,"Gurame Asam Manis","Rp.35000"));
        menuModels.add(new MenuModel(R.drawable.joglo1,"Tumis Kangkung","Rp.14000"));
        menuModels.add(new MenuModel(R.drawable.joglo4,"Jamur Crispy","Rp.10000"));
        menuModels.add(new MenuModel(R.drawable.joglo3,"Es Dawet","Rp.8000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran8,"Teh Panas","Rp.4000"));
    }

    private void resto_warung_mak_nyak() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.maknyak1,"Capjay Blitar","Rp.25000"));
        menuModels.add(new MenuModel(R.drawable.maknyak2,"Gurami Goreng","Rp.45000"));
        menuModels.add(new MenuModel(R.drawable.maknyak3,"Es Buah","Rp.12000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran8,"Teh Panas","Rp.6000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran7,"Es Jeruk","Rp.6000"));
    }


    //surabaya
    private void resto_khayangan() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.kayangansby1,"Oseng Gurame","Rp.75000"));
        menuModels.add(new MenuModel(R.drawable.kayangansby2,"Gurame Kribo (Krispi Boow)","Rp.75000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran8,"Teh Panas","Rp.15000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran7,"Ice Orange","Rp.15000"));

    }

    private void resto_primarasa() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.primarasa3,"Menu Soto Kudus Blitar.","Rp."));
        menuModels.add(new MenuModel(R.drawable.primarasa4,"Menu Soto Kudus Blitar.","Rp."));
        menuModels.add(new MenuModel(R.drawable.primarasa5,"Menu Soto Kudus Blitar.","Rp."));
        menuModels.add(new MenuModel(R.drawable.primarasa2,"Menu Soto Kudus Blitar.","Rp."));
        menuModels.add(new MenuModel(R.drawable.primarasa1,"Es Dawet","Rp.10000"));

    }

    private void resto_asian_king() {
    }


    //malang
    private void resto_bensu() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.bensu1,"Paket Garpu","Rp.5000"));
        menuModels.add(new MenuModel(R.drawable.bensu2,"Paket Geprek Keju","Rp.20000"));
        menuModels.add(new MenuModel(R.drawable.bensu3,"Paket Geprek","Rp.15000"));
        menuModels.add(new MenuModel(R.drawable.bensu4,"Paket Geprek Leleh","Rp.25000"));
    }

    private void resto_nelongso() {
    }

    private void resto_solaria() {
    }


    //jogja
    private void resto_jejamuran() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.jejamuran1,"Sate Jamur","Rp.8000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran2,"Tongseng Jamur","Rp.8000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran3,"Pepes Jamur Merang","Rp.5000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran4,"Rendang Jamur","Rp.8000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran5,"Sop Jamur","Rp.8000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran6,"Jeruk Panas","Rp.4500"));
        menuModels.add(new MenuModel(R.drawable.jejamuran7,"Carica Squash","Rp.8000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran8,"Teh Panas","Rp.2500"));
    }
    private void ledok_garden() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.ledokgarden1,"Nasgor Special Lemah Ledok","Rp.35000"));
        menuModels.add(new MenuModel(R.drawable.ledokgarden2,"Ayam Bakar Bumbu Rujak","Rp.30000 / Potong"));
        menuModels.add(new MenuModel(R.drawable.ledokgarden3,"Sop Iga Sapi","Rp.75000"));
        menuModels.add(new MenuModel(R.drawable.ledokgarden4,"Ikan Bakar Mozarella","Rp.80000"));
        menuModels.add(new MenuModel(R.drawable.ledokgarden8,"Ikan Gurame Bakar Madu","Rp.85000"));
        menuModels.add(new MenuModel(R.drawable.ledokgarden5,"Infuse Water Orange","Rp.28000"));
        menuModels.add(new MenuModel(R.drawable.ledokgarden6,"Hot Chocolate Java","Rp.25000"));
        menuModels.add(new MenuModel(R.drawable.ledokgarden7,"Ice Cappucino ","Rp.25000"));
    }
    private void resto_pelem_golek() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.palemgolek1,"Fried fish with bbq sauce","Rp.65000"));
        menuModels.add(new MenuModel(R.drawable.palemgolek2,"Deep fried tofu","Rp.18000"));
        menuModels.add(new MenuModel(R.drawable.palemgolek3,"Salted egg yolk squid","Rp.30000"));
        menuModels.add(new MenuModel(R.drawable.palemgolek4,"Honey grilles squids","Rp.42000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran8,"Hot Tea","Rp.12000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran7,"Ice Orange","Rp.12000"));
    }

    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        newAdapters = new NewAdapters(menuModels);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(newAdapters);
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
                newAdapters.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
