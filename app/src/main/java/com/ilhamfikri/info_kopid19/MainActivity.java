package com.ilhamfikri.info_kopid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.ilhamfikri.info_kopid19.api.ApiService;
import com.ilhamfikri.info_kopid19.api.ApiUrl;
import com.ilhamfikri.info_kopid19.model.ModelIndonesia;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private TextView tvpositif, tvsembuh, tvmeninggal;
    private int positif, sembuh, meninggal;
    private static final int NUM_PAGES = 4;
    private ViewPager mPager;
    private PagerAdapter pageradapter;
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

        getIndonesia();
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

        // Mengeksekusi url kemudian di tampung ke array list ModelJadwal
        Call<ModelIndonesia> call = apiService.getIndonesia();

        // Membuat Response dari API
        call.enqueue(new Callback<ModelIndonesia>() {
            @Override
            public void onResponse(Call<ModelIndonesia> call, Response<ModelIndonesia> response) {

                // Menghilangkan Loading Screen
                progressDialog.dismiss();

                // Jika Response berhasil
                if (response.isSuccessful()) {
                    // Menampung item yang ada JSON API ke dalam variabel
                    positif = response.body().getPositif();
                    sembuh = response.body().getSembuh();
                    meninggal = response.body().getMeninggal();

                    // Merubah item di layout XML menjadi variabel yang sudah di isi dari API
                    tvpositif.setText(positif);
                    tvmeninggal.setText(meninggal);
                    tvsembuh.setText(sembuh);

                    // Jika Response gagal
                } else {

                }
            }

            // Jika tidak ada response
            @Override
            public void onFailure(Call<ModelIndonesia> call, Throwable t) {
                // Menghilangkan Loading Screen
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Sorry, please try again... server Down..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
