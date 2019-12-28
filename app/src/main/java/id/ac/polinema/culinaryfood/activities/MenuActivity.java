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
import id.ac.polinema.culinaryfood.Filter.FilterMenuAdapters;
import id.ac.polinema.culinaryfood.models.MenuModel;

public class MenuActivity extends AppCompatActivity {

    private ArrayList<MenuModel> menuModels;
    private RecyclerView recyclerView;
    private FilterMenuAdapters newAdapters;
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
            if(code.equals("arbanat"))
            {
                resto_arbanat();
            }

            else if(code.equals("javanine"))
            {
                resto_javanine();
            }
            else if(code.equals("hoklay"))
            {
                resto_hoklay();
            }
        }
        else if(code_daerah.equals(("surabaya")))
        {
            if(code.equals("arumanis"))
            {
                resto_arumanis();
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
//        else if(code_daerah.equals(("blitar")))
//        {
//            if(code.equals("warung_mak_nyak"))
//            {
//                resto_warung_mak_nyak();
//            }
//
//            else if(code.equals("rm_joglo"))
//            {
//                resto_rm_joglo();
//            }
//            else if(code.equals("soto_kudus"))
//            {
//                resto_soto_kudus();
//            }
//        }

        buildRecyclerView();
    }

    //malang
    private void resto_arbanat() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.arbanat4,"Chicken raulade","Rp.42000"));
        menuModels.add(new MenuModel(R.drawable.arbanat6,"Nasi Lemak","Rp.52000"));
        menuModels.add(new MenuModel(R.drawable.arbanat5,"Vanila panakota","Rp.35000"));
        menuModels.add(new MenuModel(R.drawable.arbanat2,"Banana dulche de leche wafle","Rp.32000"));
        menuModels.add(new MenuModel(R.drawable.arbanat1,"Sour sally pounch","Rp.45000"));
        menuModels.add(new MenuModel(R.drawable.arbanat3,"Ice flash","Rp.30000"));
        menuModels.add(new MenuModel(R.drawable.arbanat7,"Mango cream ice","Rp.32000"));
        menuModels.add(new MenuModel(R.drawable.arbanat8,"Frozen kiwi","Rp.32000"));
    }

    private void resto_javanine() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.javanine1,"Fried Duck (1/2 ekor)","Rp.85000"));
        menuModels.add(new MenuModel(R.drawable.javanine2,"Penyet Ikan Pari","Rp.38000"));
        menuModels.add(new MenuModel(R.drawable.javanine3,"Nasi Goreng Jawa","Rp.48500"));
        menuModels.add(new MenuModel(R.drawable.javanine5,"Nasi Goreng Ampela","Rp.40500"));
        menuModels.add(new MenuModel(R.drawable.javanine4,"Es Teller Durian","Rp.39500"));
        menuModels.add(new MenuModel(R.drawable.javanine6,"Es Teh","Rp.13500"));
        menuModels.add(new MenuModel(R.drawable.javanine7,"Es Blewah","Rp.22500"));
    }

    private void resto_hoklay() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.hoklay1,"Lunpia Semarang","Rp.20000"));
        menuModels.add(new MenuModel(R.drawable.hoklay2,"Lomie","Rp.22000"));
        menuModels.add(new MenuModel(R.drawable.hoklay3,"Pangsit cwimie bakso","Rp.18000"));
        menuModels.add(new MenuModel(R.drawable.hoklay4,"Nasi Goreng","Rp.20000"));
        menuModels.add(new MenuModel(R.drawable.hoklay5,"Es Puding Manalagi","Rp.12000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran8,"Teh Panas","Rp.4000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran6,"Es Squash","Rp.8000"));
    }

    //blitar
//    private void resto_soto_kudus() {
//        menuModels =  new ArrayList<>();
//        menuModels.add(new MenuModel(R.drawable.soto1,"Menu Soto Kudus Blitar.","Rp."));
//        menuModels.add(new MenuModel(R.drawable.jejamuran8,"Teh Panas","Rp.3000"));
//    }

//    private void resto_rm_joglo() {
//        menuModels =  new ArrayList<>();
//        menuModels.add(new MenuModel(R.drawable.joglo2,"Gurame Asam Manis","Rp.35000"));
//        menuModels.add(new MenuModel(R.drawable.joglo1,"Tumis Kangkung","Rp.14000"));
//        menuModels.add(new MenuModel(R.drawable.joglo4,"Jamur Crispy","Rp.10000"));
//        menuModels.add(new MenuModel(R.drawable.joglo3,"Es Dawet","Rp.8000"));
//        menuModels.add(new MenuModel(R.drawable.jejamuran8,"Teh Panas","Rp.4000"));
//    }
//
//    private void resto_warung_mak_nyak() {
//        menuModels =  new ArrayList<>();
//        menuModels.add(new MenuModel(R.drawable.maknyak1,"Capjay Blitar","Rp.25000"));
//        menuModels.add(new MenuModel(R.drawable.maknyak2,"Gurami Goreng","Rp.45000"));
//        menuModels.add(new MenuModel(R.drawable.maknyak3,"Es Buah","Rp.12000"));
//        menuModels.add(new MenuModel(R.drawable.jejamuran8,"Teh Panas","Rp.6000"));
//        menuModels.add(new MenuModel(R.drawable.jejamuran7,"Es Jeruk","Rp.6000"));
//    }


    //surabaya
    private void resto_khayangan() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.kayangansby1,"Oseng Gurame","Rp.75000"));
        menuModels.add(new MenuModel(R.drawable.kayangansby2,"Gurame Kribo (Krispi Boow)","Rp.75000"));
        menuModels.add(new MenuModel(R.drawable.primarasa4,"Ayam Bakar Madu.","Rp.47000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran8,"Teh Panas","Rp.15000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran7,"Ice Orange","Rp.15000"));
        menuModels.add(new MenuModel(R.drawable.maknyak3,"Es Buah","Rp.18000"));
    }

    private void resto_primarasa() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.primarasa3,"Ikan Gurame Bumbu Kuning.","Rp.55000"));
        menuModels.add(new MenuModel(R.drawable.primarasa4,"Ayam Bakar Madu.","Rp.37000"));
        menuModels.add(new MenuModel(R.drawable.primarasa5,"Ikan Gurame Bakar.","Rp.53000"));
        menuModels.add(new MenuModel(R.drawable.primarasa2,"Tumis Tauge","Rp.25000"));
        menuModels.add(new MenuModel(R.drawable.primarasa1,"Es Dawet","Rp.12000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran7,"Es Jeruk","Rp.10000"));
        menuModels.add(new MenuModel(R.drawable.maknyak3,"Es Buah","Rp.15000"));

    }

    private void resto_arumanis() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.arumanis1,"Satay with peanut sauce","Rp.37000"));
        menuModels.add(new MenuModel(R.drawable.arumanis6,"Grilled octopus","Rp.42000"));
        menuModels.add(new MenuModel(R.drawable.arumanis2,"Nasi campur","Rp.47000"));
        menuModels.add(new MenuModel(R.drawable.arumanis3,"Baby kailan with meat slice","Rp.35000"));
        menuModels.add(new MenuModel(R.drawable.arumanis4,"Nasi goreng emping","Rp.43000"));
        menuModels.add(new MenuModel(R.drawable.arumanis5,"Green duck","Rp.30000"));
        menuModels.add(new MenuModel(R.drawable.jejamuran7,"Carica Squash","Rp.25000"));
        menuModels.add(new MenuModel(R.drawable.arumanis7,"Ice Cincau","Rp.23000"));
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
        newAdapters = new FilterMenuAdapters(menuModels);
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
