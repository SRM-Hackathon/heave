package nitt.hackathon.oxytrees.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nitt.hackathon.oxytrees.R;

/**
 * Created by HP on 06-Oct-17.
 */

public class Browsetrees extends Fragment {

    public Browsetrees() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.browse_trees, container, false);

        return view;
    }
}
