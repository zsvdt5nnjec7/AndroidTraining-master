package jp.mixi.assignment.controller;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Title_Activity extends Fragment {

    public static Title_Activity newInstance() {
        Title_Activity title_activity = new Title_Activity();
        Bundle args = new Bundle();
        title_activity.setArguments(args);
        return title_activity;
    }

    public Title_Activity() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_title, container, false);
    }

}
