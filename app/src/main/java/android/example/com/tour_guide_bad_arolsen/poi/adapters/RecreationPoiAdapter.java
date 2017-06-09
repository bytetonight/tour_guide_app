package android.example.com.tour_guide_bad_arolsen.poi.adapters;

import android.databinding.DataBindingUtil;
import android.example.com.tour_guide_bad_arolsen.R;
import android.example.com.tour_guide_bad_arolsen.databinding.PoiListItemGastronomyBinding;
import android.example.com.tour_guide_bad_arolsen.databinding.PoiListItemRecreationBinding;
import android.example.com.tour_guide_bad_arolsen.poi.GastronomyPlace;
import android.example.com.tour_guide_bad_arolsen.poi.RecreationPlace;
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
 *
 * https://stackoverflow.com/questions/39364813/android-databinding-mvvm-using-same-layout-files-for-different-conditions-us
 *
 * https://stackoverflow.com/questions/41718377/use-tab-layout-in-mvvm-architecture-with-the-data-binding-library
 */




public class RecreationPoiAdapter extends RecyclerView.Adapter<RecreationPoiAdapter.RecreationPoiHolder>{

    private List<RecreationPlace> items;


    public RecreationPoiAdapter(List<RecreationPlace> items) {
        super();
        this.items = items;
    }

    @Override
    public RecreationPoiHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        PoiListItemRecreationBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.poi_list_item_recreation, parent, false);

        binding.setHandlers(new PoiHandlers()); //use my handlers class
        return new RecreationPoiHolder(binding);
    }


    @Override
    public void onBindViewHolder(RecreationPoiHolder holder, int position) {
        holder.bindConnection(items.get(position));
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    public class RecreationPoiHolder extends RecyclerView.ViewHolder {
        private PoiListItemRecreationBinding binding;

        public RecreationPoiHolder(PoiListItemRecreationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindConnection(PointOfInterest poi) {
            binding.setPoi(poi);
        }
    }
}
