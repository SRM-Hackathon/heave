package nitt.hackathon.oxytrees.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nitt.hackathon.oxytrees.R;
//import nitt.paritosh.o2.adapter.CustomAdapter;

public class ChatFragment extends Fragment {

    public ChatFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        // mTabhost = (FragmentTabHost)view.findViewById(android.R.id.tabhost);
        // mTabhost.setup(getActivity(), getChildFragmentManager(),R.id.realtabcontent);
        //  mTabhost.addTab(mTabhost.newTabSpec("post").setIndicator("Post"), FriendFragment.class,null);
        //  mTabhost.addTab(mTabhost.newTabSpec("search").setIndicator("Search"), ExploreFragment.class,null);
        return view;
    }
}
