package android.example.com.tour_guide_bad_arolsen.fragments;

import android.content.Context;
import android.example.com.tour_guide_bad_arolsen.R;
import android.example.com.tour_guide_bad_arolsen.data.VirtualDataBase;
import android.example.com.tour_guide_bad_arolsen.poi.adapters.GastronomyPoiAdapter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class GastronomyFragment extends Fragment {

    private static final String ARG_POI_TYPE = "poi_type";
    private VirtualDataBase.Poi poiType;



    public GastronomyFragment() {
        // Required empty public constructor
    }


    public static GastronomyFragment newInstance(VirtualDataBase.Poi poiType) {
        GastronomyFragment fragment = new GastronomyFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_POI_TYPE, poiType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            poiType = (VirtualDataBase.Poi) getArguments().getSerializable(ARG_POI_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //I could load a different Layout each time depending on what poiType is set to
        View rootView = inflater.inflate(R.layout.fragment_recyclerview_list, container, false);

        GastronomyPoiAdapter adapter = new GastronomyPoiAdapter(VirtualDataBase.getGastronomyPlaces(getContext()));


        final RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
        Log.v("GastronomyFragment", adapter.getClass().toString());
        return rootView;
    }


}
