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

    private void resto_soto_kudus() {
    }

    private void resto_rm_joglo() {
    }

    private void resto_warung_mak_nyak() {
    }

    //surabaya
    private void resto_khayangan() {
    }

    private void resto_primarasa() {
    }

    private void resto_asian_king() {
    }

    //malang
    private void resto_bensu() {
    }

    private void resto_nelongso() {
    }

    private void resto_solaria() {
    }


    //jogja
    private void ledok_garden() {
    }

    private void resto_pelem_golek() {
    }

    private void buildRecyclerView() {
        recyclerView = findViewById(R.id.recylerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        newAdapters = new NewAdapters(menuModels);


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(newAdapters);
    }

    private void resto_jejamuran() {
        menuModels =  new ArrayList<>();
        menuModels.add(new MenuModel(R.drawable.jejamuran,"ayam goreng","Rp.50000"));
    }
}
