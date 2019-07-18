package com.gtechnog.sample.tivo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gtechnog.sample.tivo.R;
import com.gtechnog.sample.tivo.constants.BundleKeys;
import com.gtechnog.sample.tivo.viewmodel.WTWRootViewModel;

import java.util.Objects;


/**
 * A placeholder fragment containing a simple view.
 */
public class WTWTabFragment extends Fragment {

    private static final String TAG = WTWTabFragment.class.getSimpleName();
    private WTWRootViewModel sharedViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    static WTWTabFragment newInstance(String fragmentId,
                                      String type) {
        WTWTabFragment fragment = new WTWTabFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BundleKeys.FRAGMENT_ID, fragmentId);
        bundle.putString(BundleKeys.FRAGMENT_TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sharedViewModel = ViewModelProviders.of(Objects.requireNonNull(this.getActivity())).get(WTWRootViewModel.class);
        sharedViewModel.getFeedItemList(getArguments().getString(BundleKeys.FRAGMENT_TYPE));
    }

    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        if (root instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) root;
            recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
            recyclerView.setAdapter(new StripListAdapter());
        }
        return root;
    }
}