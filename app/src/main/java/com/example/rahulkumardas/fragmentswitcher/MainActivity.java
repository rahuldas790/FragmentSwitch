package com.example.rahulkumardas.fragmentswitcher;

import android.support.v4.app.FragmentManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static FragmentTransaction ft;
    private static FragmentManager fm;
    private static boolean isMain = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fm = getSupportFragmentManager();

        // Transaction start
        ft = fm.beginTransaction();

        ft.add(R.id.container, new MainFragment());
        ft.commit();

    }

    public static View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            isMain = false;
            int tag = (int) view.getTag();
            switch (tag) {
                case 1:
                    ft = fm.beginTransaction();
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.replace(R.id.container, new FragmentOne());
                    ft.commit();
                    break;
                case 2:
                    ft = fm.beginTransaction();
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.replace(R.id.container, new FragmentTwo());
                    ft.commit();
                    break;
                case 3:
                    ft = fm.beginTransaction();
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.replace(R.id.container, new FragmentThree());
                    ft.commit();
                    break;
                case 4:
                    ft = fm.beginTransaction();
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.replace(R.id.container, new FragmentFour());
                    ft.commit();
                    break;
            }
        }
    };

    @Override
    public void onBackPressed() {
        if(isMain){
            super.onBackPressed();
        }else{
            isMain = true;
            ft = fm.beginTransaction();
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            ft.replace(R.id.container, new MainFragment());
            ft.commit();
        }
    }
}
