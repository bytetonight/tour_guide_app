package android.example.com.tour_guide_bad_arolsen.fragments;

import android.example.com.tour_guide_bad_arolsen.R;

import android.example.com.tour_guide_bad_arolsen.data.VirtualDataBase2;
import android.example.com.tour_guide_bad_arolsen.poi.adapters.GenericPoiAdapter;
import android.example.com.tour_guide_bad_arolsen.poi.interfaces.PointOfInterest;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class GenericFragment extends Fragment {

    private static final String ARG_POI_TYPE = "poi_type";
    private List<PointOfInterest> items;



    public GenericFragment() {
        // Required empty public constructor
    }


    public static GenericFragment newInstance(ArrayList<PointOfInterest> items) {
        GenericFragment fragment = new GenericFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList("items", items);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            items = getArguments().getParcelableArrayList("items");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //I could load a different Layout each time depending on what poiType is set to
        View rootView = inflater.inflate(R.layout.fragment_recyclerview_list, container, false);


        GenericPoiAdapter adapter = new GenericPoiAdapter(items);


        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);


        return rootView;
    }


}
