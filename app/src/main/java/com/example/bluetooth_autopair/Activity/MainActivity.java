package com.example.bluetooth_autopair.Activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;

import com.example.bluetooth_autopair.Adapter.ViewPagerAdapter;
import com.example.bluetooth_autopair.Fragment.HomeFragment;
import com.example.bluetooth_autopair.Fragment.SettingFragment;
import com.example.bluetooth_autopair.R;
import com.example.bluetooth_autopair.Util.XPermissionUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    public static final int BLUE_TOOTH_DIALOG = 0x111;
    public static final int BLUE_TOOTH_TOAST = 0x123;
    public static final int BLUE_TOOTH_WRAITE = 0X222;
    public static final int BLUE_TOOTH_READ = 0X333;
    public static final int BLUE_TOOTH_WRAITE_FILE_NOW = 0X511;
    public static final int BLUE_TOOTH_READ_FILE_NOW = 0X996;
    public static final int BLUE_TOOTH_WRAITE_FILE = 0X555;
    public static final int BLUE_TOOTH_READ_FILE = 0X888;
    public static final int BLUE_TOOTH_SUCCESS = 0x444;

    private ViewPager viewPager;
    private MenuItem menuItem;
    private BottomNavigationView bottomNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.navigation_setting:
                    viewPager.setCurrentItem(1);
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("??????????????????");
        initView();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initView() {
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager = findViewById(R.id.viewpager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        setupViewPager(viewPager);
        XPermissionUtil.requestPermissions(this, 1,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.BLUETOOTH,
                        Manifest.permission.BLUETOOTH_ADMIN,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION},
                new XPermissionUtil.OnPermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        //??????????????????
                    }

                    @Override
                    public void onPermissionDenied() {
                        //??????????????????
                        Snackbar.make(bottomNavigationView, "??????????????????????????????????????????", Snackbar.LENGTH_LONG).show();
                    }
                });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new SettingFragment());
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        XPermissionUtil.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
