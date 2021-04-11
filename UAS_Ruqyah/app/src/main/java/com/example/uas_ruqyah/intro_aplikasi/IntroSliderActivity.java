package com.example.tugas_akhir_p_tahap1_art2.intro_aplikasi;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.tugas_akhir_p_tahap1_art2.R;
import com.example.tugas_akhir_p_tahap1_art2.login_dan_register.LoginActivity;

public class IntroSliderActivity extends AppCompatActivity {
    private static final int MAX_STEP = 4;
    private Button btn_got_it;

    private String[] judul_array = {"Daftar", "Aman", "Profesional", "Sehat"};
    private String[] description_array = {
            "Daftarkan Segera JRA Sekarang", "Pastinya Aman",
            "Dengan Dokter - Dokter Profesional", "InsyaAllah Jiwa dan Raga Menjadi Sehat"
    };
    private int[] about_images_array = {
            R.drawable.wanita, R.drawable.aman, R.drawable.timdokter, R.drawable.sehat
    };
    private int[] color_array = {R.color.warnaBiru, R.color.warnaMerah,
            R.color.warnaKuning, R.color.warnaUngu
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_slider);
        initComponent();
    }

    private void initComponent() {
        ViewPager viewPager = findViewById(R.id.view_pager);
        btn_got_it = findViewById(R.id.btn_gotIt);

        bottomProgressDots(0);
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(myViewPagerPageChangeListener);

        btn_got_it.setVisibility(View.GONE);
        btn_got_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroSliderActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        findViewById(R.id.btn_skip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroSliderActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void bottomProgressDots(int index) {
        LinearLayout dotsLayout = findViewById(R.id.layoutDots);
        ImageView[] dots = new ImageView[MAX_STEP];

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++){
            dots[i] = new ImageView(this);
            int width_height = 15;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(
                    width_height, width_height
            ));
            params.setMargins(10,10,10,10);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.dot);
            dots[i].setColorFilter(getResources().getColor(R.color.warnaPutih), PorterDuff.Mode.SRC_IN);
            dotsLayout.addView(dots[i]);
        }
        dots[index].setImageResource(R.drawable.dot);
        dots[index].setColorFilter(getResources().getColor(R.color.warnaKuning), PorterDuff.Mode.SRC_IN);
    }

    ViewPager.OnPageChangeListener myViewPagerPageChangeListener = new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageSelected(final int position) {
            bottomProgressDots(position);
            if (position == judul_array.length - 1){
                btn_got_it.setVisibility(View.VISIBLE);
            }
            else{
                btn_got_it.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public class MyViewPagerAdapter extends PagerAdapter{
        MyViewPagerAdapter(){
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.item_intro, container, false);
            ((TextView) view.findViewById(R.id.title)).setText(judul_array[position]);
            ((TextView) view.findViewById(R.id.description)).setText(description_array[position]);
            ((ImageView) view.findViewById(R.id.image)).setImageResource(about_images_array[position]);
            view.findViewById(R.id.lyt_parent).setBackgroundColor(getResources().getColor(color_array[position]));
            container.addView(view);
            return view;
        }
        @Override
        public int getCount() {
            return judul_array.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}
