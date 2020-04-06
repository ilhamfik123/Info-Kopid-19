package com.ilhamfikri.info_kopid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ilhamfikri.info_kopid19.api.ApiService;
import com.ilhamfikri.info_kopid19.api.ApiUrl;
import com.ilhamfikri.info_kopid19.model.ModelIndonesia;
import com.ilhamfikri.info_kopid19.model.Provinsi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private TextView tvpositif, tvsembuh, tvmeninggal, tvjatimpositif, tvjatimsembuh, tvjatimmeninggal, seeall;
    private String positif, sembuh, meninggal, jatimpositif, jatimsembuh, jatimmeninggal;
    private static final int NUM_PAGES = 4;
    private ViewPager mPager;
    private PagerAdapter pageradapter;
    private List<ModelIndonesia> dataCorona;
    private List<Provinsi> dataCoronajatim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.activity_screen_slide_pager);
        mPager=(ViewPager) findViewById(R.id.pager);
        pageradapter=new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pageradapter);
        tvpositif=findViewById(R.id.positif);
        tvmeninggal=findViewById(R.id.meninggal);
        tvsembuh=findViewById(R.id.sembuh);
        tvjatimpositif=findViewById(R.id.jatim_positif);
        tvjatimmeninggal=findViewById(R.id.jatim_meninggal);
        tvjatimsembuh=findViewById(R.id.jatim_sembuh);
        seeall=findViewById(R.id.seeall);

        seeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ListKotaActivity.class);
                startActivity(intent);
            }
        });
        getIndonesia();
        getProvinsi();
    }
    public void onBackPressed(){
        if(mPager.getCurrentItem()==0){
            super.onBackPressed();
        }else{
            mPager.setCurrentItem(mPager.getCurrentItem()-1);
        }
    }
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm){
            super(fm);
        }
        public Fragment getItem(int position){
            return new ScreenSlidePageFragment();
        }
        public int getCount(){
            return NUM_PAGES;
        }
    }
    public void getIndonesia(){
        // Membuat Loading Screen
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Please Wait / Silahkan tunggu ...");
        progressDialog.show();

        // Menyambungkan aplikasi dengan internet
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.URL_ROOT_HTTP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Membuat objek Apiservice
        ApiService apiService = retrofit.create(ApiService.class);

        Call<List<ModelIndonesia>> call = apiService.getIndonesia();

        call.enqueue(new Callback<List<ModelIndonesia>>() {
            @Override
            public void onResponse(Call<List<ModelIndonesia>> call, Response<List<ModelIndonesia>> response) {
                // Menghilangkan Loading Screen
                progressDialog.dismiss();
                // Jika Response berhasil
                if (response.isSuccessful()) {
                    // Menampung item yang ada JSON API ke dalam variabel
                    dataCorona = response.body();
                    positif = dataCorona.get(0).getPositif();
                    sembuh = dataCorona.get(0).getSembuh();
                    meninggal = dataCorona.get(0).getMeninggal();
                    // Merubah item di layout XML menjadi variabel yang sudah di isi dari API
                    tvpositif.setText(String.valueOf(positif));
                    tvmeninggal.setText(String.valueOf(meninggal));
                    tvsembuh.setText(String.valueOf(sembuh));

                    // Jika Response gagal
                } else {
                }
            }

            @Override
            public void onFailure(Call<List<ModelIndonesia>> call, Throwable t) {
                // Menghilangkan Loading Screen
                progressDialog.dismiss();
                Log.d(">>>", t.getLocalizedMessage());
                Toast.makeText(MainActivity.this, "Sorry, please try again... server Down..", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getProvinsi(){

        // Menyambungkan aplikasi dengan internet
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.URL_KAB)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Membuat objek Apiservice
        ApiService apiService = retrofit.create(ApiService.class);

        Call<List<Provinsi>> call = apiService.getProvinsi();

        call.enqueue(new Callback<List<Provinsi>>() {
            @Override
            public void onResponse(Call<List<Provinsi>> call, Response<List<Provinsi>> response) {

                // Jika Response berhasil
                if (response.isSuccessful()) {
                    // Menampung item yang ada JSON API ke dalam variabel
                    dataCoronajatim = response.body();
                    jatimpositif = dataCoronajatim.get(0).getPositif();
                    jatimsembuh = dataCoronajatim.get(0).getSembuh();
                    jatimmeninggal = dataCoronajatim.get(0).getMeninggal();
                    // Merubah item di layout XML menjadi variabel yang sudah di isi dari API
                    tvjatimpositif.setText(String.valueOf(jatimpositif));
                    tvjatimmeninggal.setText(String.valueOf(jatimmeninggal));
                    tvjatimsembuh.setText(String.valueOf(jatimsembuh));

                    // Jika Response gagal
                } else {
                }
            }

            @Override
            public void onFailure(Call<List<Provinsi>> call, Throwable t) {
                // Menghilangkan Loading Screen
                progressDialog.dismiss();
                Log.d(">>>", t.getLocalizedMessage());
                Toast.makeText(MainActivity.this, "Sorry, please try again... server Down..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
