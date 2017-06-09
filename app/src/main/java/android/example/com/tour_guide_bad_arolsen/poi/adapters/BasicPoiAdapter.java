package android.example.com.tour_guide_bad_arolsen.poi.adapters;

import android.databinding.DataBindingUtil;
import android.example.com.tour_guide_bad_arolsen.R;

import android.example.com.tour_guide_bad_arolsen.databinding.PoiListItemBinding;
import android.example.com.tour_guide_bad_arolsen.poi.HistoricalPlace;
import android.example.com.tour_guide_bad_arolsen.poi.handlers.PoiHandlers;
import android.example.com.tour_guide_bad_arolsen.poi.interfaces.PointOfInterest;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ByteTonight on 02.06.2017.
 *
 *
 * TODO : READ https://www.bignerdranch.com/blog/descent-into-databinding/
 *
 * https://stackoverflow.com/questions/38818199/android-databindingutils-how-to-use-a-single-adapter-for-the-whole-project
 */




public class BasicPoiAdapter extends RecyclerView.Adapter<BasicPoiAdapter.SimplePoiHolder>{

    private List<PointOfInterest> items;


    public BasicPoiAdapter(List<PointOfInterest> items) {
        super();
        this.items = items; //This is being overwritten by the list from GastronomyPoiAdapter and I don't know why. It's not static !!
    }

    @Override
    public SimplePoiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*PoiListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.poi_list_item, parent, false);*/
        PoiListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.poi_list_item, parent, false);

        binding.setHandlers(new PoiHandlers()); //use my handlers class
        return new SimplePoiHolder(binding);
    }


    @Override
    public void onBindViewHolder(SimplePoiHolder holder, int position) {
        holder.bindConnection(items.get(position));
    }


    @Override
    public int getItemCount() {
        return items.size();
    }



    public class SimplePoiHolder extends RecyclerView.ViewHolder {
        private PoiListItemBinding binding;

        public SimplePoiHolder(PoiListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindConnection(PointOfInterest poi) {
            binding.setPoi(poi);
        }
    }

}
