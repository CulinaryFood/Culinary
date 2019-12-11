package id.ac.polinema.culinaryfood.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import id.ac.polinema.culinaryfood.R;

public class restoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto);

        ImageView image1 = findViewById(R.id.gambar);
        TextView nama1 = findViewById(R.id.name);
        TextView alamat1 = findViewById(R.id.alamat);

        ImageView image2 = findViewById(R.id.gambar2);
        TextView nama2 = findViewById(R.id.name2);
        TextView alamat2 = findViewById(R.id.alamat2);

        ImageView image3 = findViewById(R.id.gambar3);
        TextView nama3 = findViewById(R.id.name3);
        TextView alamat3 = findViewById(R.id.alamat3);



        Bundle extras = getIntent().getExtras();
        String code="";

        if(extras!=null)
        {
            code = extras.getString("kode_resto");
        }



        if(code.equals("malang"))
        {
            nama1.setText("Solaria");
            image1.setBackgroundResource(R.drawable.solaria);
            alamat1.setText("Kawi St No.24, 3, Kauman, Klojen, Malang City, East Java 65119");

            nama2.setText("Geprek Bensu");
            image2.setBackgroundResource(R.drawable.bensu);
            alamat2.setText("Ruko Grand Suhat No, Jl. Soekarno Hatta No.6, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141");

            nama3.setText("Ayam Nelongso");
            image3.setBackgroundResource(R.drawable.nelongso);
            alamat3.setText("Jl. Dieng, Sumberjo, Kalisongo, Kec. Dau, Malang, Jawa Timur 65116");

        }

        else if(code.equals("jogja"))
        {
            nama1.setText("Jejamuran");
            image1.setBackgroundResource(R.drawable.jejamuran);
            alamat1.setText("Jl. Pendowoharjo No.RT.01, RW.20, Niron, Pandowoharjo, Kec. Sleman, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55512");

            nama2.setText("Pondok Makan Pelem Golek");
            image2.setBackgroundResource(R.drawable.pelem_golek);
            alamat2.setText("Jalan Palagan Tentara Pelajar KM.7 No.99, Sariharjo, Ngaglik, Mudal, Sariharjo, Kec. Ngaglik, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55581");

            nama3.setText("Lemah Ledok Garden Resto");
            image3.setBackgroundResource(R.drawable.lemah_ledok_garden);
            alamat3.setText("JJl. Cangkringan KM. 0,3, Tirtomartani, Karang Kalasan, Tirtomartani, Kec. Kalasan, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55571");


        }




    }

    private void resto_malang() {



    }

}