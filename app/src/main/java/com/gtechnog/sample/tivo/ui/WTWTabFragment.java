package com.gtechnog.sample.tivo.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.gtechnog.sample.tivo.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class WTWTabFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    static WTWTabFragment newInstance(int index) {
        WTWTabFragment fragment = new WTWTabFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        return root;
    }
}