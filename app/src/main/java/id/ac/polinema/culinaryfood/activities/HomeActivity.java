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

public class HomeActivity extends AppCompatActivity {
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

        if(extras!=null){
            code = extras.getString("kode_resto");
        }

        //String code = args.putString("Judul", getIntent().getExtras().getString("Judul"));

        if(code.equals("malang")){
            resto_malang();
        }
        else if(code.equals("jogja")){
            resto_jogja();
        }
        else if(code.equals("surabaya")){
            resto_surabaya();
        }
        //        else if(code.equals("blitar"))
//        {
//            resto_blitar();
//        }
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
        restoModels.add(new RestoModel(R.drawable.arbanat, "The Arbanat", " Jl. Terusan Dieng No.4, RW.6, Pisang Candi, Kec. Sukun, Kota Malang, Jawa Timur 65146"));
        restoModels.add(new RestoModel(R.drawable.javanine, "Javanine", "Jalan Pahlawan Trip A5, Oro-oro Dowo, Kec. Klojen, Kota Malang, Jawa Timur 65119"));
        restoModels.add(new RestoModel(R.drawable.hoklay, "Depot Hok Lay", "Jl. KH Ahmad Dahlan No.10, Sukoharjo, Kec. Klojen, Kota Malang, Jawa Timur 65118"));
    }

    public void resto_jogja(){

        restoModels = new ArrayList<>();
        restoModels.add(new RestoModel(R.drawable.jejamuran, "Jejamuran", " Jl. Pendowoharjo No.RT.01, RW.20, Niron, Pandowoharjo, Kec. Sleman, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55512"));
        restoModels.add(new RestoModel(R.drawable.pelem_golek, "Pondok Makan Pelem Golek", "Jalan Palagan Tentara Pelajar KM.7 No.99, Sariharjo, Ngaglik, Mudal, Sariharjo, Kec. Ngaglik, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55581"));
        restoModels.add(new RestoModel(R.drawable.lemah_ledok_garden, "Lemah Ledok Garden Resto", " Jl. Cangkringan KM. 0,3, Tirtomartani, Karang Kalasan, Tirtomartani, Kec. Kalasan, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55571"));
    }

//    public void resto_blitar()
//    {
//        restoModels = new ArrayList<>();
//        restoModels.add(new RestoModel(R.drawable.waroeng_mak_nyak, "Waroeng Mak Nyak", " Jl. Ir. Soekarno No.184, Bendogerit, Kec. Sananwetan, Kota Blitar, Jawa Timur 66113"));
//        restoModels.add(new RestoModel(R.drawable.rm_joglo ,"RM Joglo", " Jalan Maluku No.59, Karangtengah, Kanigoro, Selatan, Kuningan, Kec. Kanigoro, Kota Blitar, Jawa Timur 66171"));
//        restoModels.add(new RestoModel(R.drawable.soto_kudus, "Soto Kudus Bu Is", " Jl. Jenderal Sudirman No.30, Kepanjen Lor, Kec. Kepanjenkidul, Kota Blitar, Jawa Timur 66112"));
//    }

    public void resto_surabaya(){
        restoModels = new ArrayList<>();
        restoModels.add(new RestoModel(R.drawable.arumanis, "Arumanis Resto", "  Jl. Basuki Rachmad no. 106-128 | Bumi Surabaya City Resort, Surabaya 60271, Indonesia"));
        restoModels.add(new RestoModel(R.drawable.primarasa, "Ayam Bakar Primarasa", " Fontage Rd Ahmad Yani No.166, Gayungan, Surabaya City, East Java 60235"));
        restoModels.add(new RestoModel(R.drawable.kahyangan, "Kahyangan Resto", " Jl. Puri Widya Kencana, RW.05, Lidah Kulon, Kec. Lakarsantri, Kota SBY, Jawa Timur 60213"));

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
