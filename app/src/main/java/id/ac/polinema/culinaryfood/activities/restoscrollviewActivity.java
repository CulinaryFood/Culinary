package id.ac.polinema.culinaryfood.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.Uri;

import id.ac.polinema.culinaryfood.R;

public class restoscrollviewActivity extends AppCompatActivity {
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
            nama1.setText("The Arbanat");
            image1.setBackgroundResource(R.drawable.arbanat);
            alamat1.setText("Jl. Terusan Dieng No.4, RW.6, Pisang Candi, Kec. Sukun, Kota Malang, Jawa Timur 65146");

            nama2.setText("Javanine");
            image2.setBackgroundResource(R.drawable.javanine);
            alamat2.setText("Jalan Pahlawan Trip A5, Oro-oro Dowo, Kec. Klojen, Kota Malang, Jawa Timur 65119");

            nama3.setText("Hok Lay");
            image3.setBackgroundResource(R.drawable.hoklay);
            alamat3.setText("Jl. KH Ahmad Dahlan No.10, Sukoharjo, Kec. Klojen, Kota Malang, Jawa Timur 65118");


            alamat1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uriUrl = Uri.parse("https://www.google.com/maps/place/The+Arbanat+Kitchen+Cafe+Lounge/@-7.972211,112.607147,15z/data=!4m5!3m4!1s0x0:0x122f370bc58dee11!8m2!3d-7.972211!4d112.607147");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
            });


            image1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(restoscrollviewActivity.this , MenuActivity.class);
                    intent.putExtra("code_daerah","malang");
                    intent.putExtra("kode_resto","arbanat");
                    startActivity(intent);
                }
            });

            image2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(restoscrollviewActivity.this , MenuActivity.class);
                    intent.putExtra("code_daerah","malang");
                    intent.putExtra("kode_resto","javanine");
                    startActivity(intent);
                }
            });

            image3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(restoscrollviewActivity.this , MenuActivity.class);
                    intent.putExtra("code_daerah","malang");
                    intent.putExtra("kode_resto","hoklay");
                    startActivity(intent);
                }
            });

        }

//        if(code.equals("blitar"))
//        {
//            nama1.setText("Warung Mak Nyak");
//            image1.setBackgroundResource(R.drawable.waroeng_mak_nyak);
//            alamat1.setText("Jl. Ir. Soekarno No.184, Bendogerit, Kec. Sananwetan, Kota Blitar, Jawa Timur 66113");
//
//            nama2.setText("RM Joglo");
//            image2.setBackgroundResource(R.drawable.rm_joglo);
//            alamat2.setText("Jalan Maluku No.59, Karangtengah, Kanigoro, Selatan, Kuningan, Kec. Kanigoro, Kota Blitar, Jawa Timur 66171");

//            nama3.setText("Soto Kudus Bu Is");
//            image3.setBackgroundResource(R.drawable.soto_kudus);
//            alamat3.setText("Jl. Jenderal Sudirman No.30, Kepanjen Lor, Kec. Kepanjenkidul, Kota Blitar, Jawa Timur 66112");

//            image1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(restoscrollviewActivity.this , MenuActivity.class);
//                    intent.putExtra("code_daerah","blitar");
//                    intent.putExtra("kode_resto","warung_mak_nyak");
//                    startActivity(intent);
//                }
//            });
//
//            image2.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(restoscrollviewActivity.this , MenuActivity.class);
//                    intent.putExtra("code_daerah","blitar");
//                    intent.putExtra("kode_resto","rm_joglo");
//                    startActivity(intent);
//                }
//            });

//            image3.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(restoscrollviewActivity.this , MenuActivity.class);
//                    intent.putExtra("code_daerah","blitar");
//                    intent.putExtra("kode_resto","soto_kudus");
//                    startActivity(intent);
//                }
//            });
//        }

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
            alamat3.setText("Jl. Cangkringan KM. 0,3, Tirtomartani, Karang Kalasan, Tirtomartani, Kec. Kalasan, Kabupaten Sleman, Daerah Istimewa Yogyakarta 55571");

            image1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(restoscrollviewActivity.this , MenuActivity.class);
                    intent.putExtra("code_daerah","jogja");
                    intent.putExtra("kode_resto","jejamuran");
                    startActivity(intent);
                }
            });

            image2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(restoscrollviewActivity.this , MenuActivity.class);
                    intent.putExtra("code_daerah","jogja");
                    intent.putExtra("kode_resto","pelem_golek");
                    startActivity(intent);
                }
            });

            image3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(restoscrollviewActivity.this , MenuActivity.class);
                    intent.putExtra("code_daerah","jogja");
                    intent.putExtra("kode_resto","ledok_garden");
                    startActivity(intent);
                }
            });
        }

        else if(code.equals("surabaya"))
        {
            nama1.setText("Arumanis Restaurant");
            image1.setBackgroundResource(R.drawable.arumanis);
            alamat1.setText("Jl. Basuki Rachmad no. 106-128 | Bumi Surabaya City Resort, Surabaya 60271, Indonesia");

            nama2.setText("Ayam Bakar Primarasa");
            image2.setBackgroundResource(R.drawable.primarasa);
            alamat2.setText("Fontage Rd Ahmad Yani No.166, Gayungan, Surabaya City, East Java 60235");

            nama3.setText("Kahyangan Resto");
            image3.setBackgroundResource(R.drawable.kahyangan);
            alamat3.setText("Jl. Puri Widya Kencana, RW.05, Lidah Kulon, Kec. Lakarsantri, Kota SBY, Jawa Timur 60213");

            image1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(restoscrollviewActivity.this , MenuActivity.class);
                    intent.putExtra("code_daerah","surabaya");
                    intent.putExtra("kode_resto","arumanis");
                    startActivity(intent);
                }
            });

            image2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(restoscrollviewActivity.this , MenuActivity.class);
                    intent.putExtra("code_daerah","surabaya");
                    intent.putExtra("kode_resto","primarasa");
                    startActivity(intent);
                }
            });

            image3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(restoscrollviewActivity.this , MenuActivity.class);
                    intent.putExtra("code_daerah","surabaya");
                    intent.putExtra("kode_resto","khayangan");
                    startActivity(intent);
                }
            });
        }

    }



//    public void click_detail1(View view) {
//
//        Bundle extras = getIntent().getExtras();
//        String code="";
//
//        if(extras!=null)
//        {
//            code = extras.getString("kode_resto");
//        }
//
//        Intent intent = new Intent(this,MenuModel.class);
//        startActivity(intent);
//
//    }

}
