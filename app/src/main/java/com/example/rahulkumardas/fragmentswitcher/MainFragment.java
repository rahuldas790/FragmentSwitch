package com.example.rahulkumardas.fragmentswitcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * Created by Rahul Kumar Das on 19-06-2017.
 */

public class MainFragment extends Fragment {

    private HorizontalScrollView horizontalScrollView;
    private final String[] menuList = {"Item1", "Item2", "Item3", "Item4"};

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        horizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.menu);

        addMenu();

        return view;
    }

    private void addMenu() {
        horizontalScrollView.removeAllViews();
        LinearLayout layout = new LinearLayout(getActivity());
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(param);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.removeAllViews();
        int pos = 0;
        for (String item : menuList) {
            pos++;
            Button btn = new Button(getActivity());
            btn.setText(item);
            btn.setTag(pos);
            btn.setOnClickListener(MainActivity.listener);
            layout.addView(btn);
        }
        horizontalScrollView.addView(layout);
    }
}
