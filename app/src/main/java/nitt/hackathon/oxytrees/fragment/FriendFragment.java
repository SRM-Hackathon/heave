package nitt.hackathon.oxytrees.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nitt.hackathon.oxytrees.R;
//import nitt.paritosh.o2.TambahTemanActivity;


public class FriendFragment extends Fragment {
    public FriendFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        //FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View view) {
                //Intent intent = new Intent(getActivity(), TambahTemanActivity.class);
                //startActivity(intent);
           // }
        //});
        return view;
    }
}
