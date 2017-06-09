package android.example.com.tour_guide_bad_arolsen.poi.adapters;

import android.databinding.DataBindingUtil;
import android.example.com.tour_guide_bad_arolsen.R;
import android.example.com.tour_guide_bad_arolsen.databinding.PoiListItemGastronomyBinding;
import android.example.com.tour_guide_bad_arolsen.databinding.PoiListItemSportsBinding;
import android.example.com.tour_guide_bad_arolsen.poi.SportsPlace;
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




public class SportsPoiAdapter extends RecyclerView.Adapter<SportsPoiAdapter.SportsPoiHolder>{

    private List<SportsPlace> items;


    public SportsPoiAdapter(List<SportsPlace> items) {
        super();
        this.items = items;
    }

    @Override
    public SportsPoiHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        PoiListItemSportsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.poi_list_item_sports, parent, false);

        binding.setHandlers(new PoiHandlers()); //use my handlers class
        return new SportsPoiHolder(binding);
    }


    @Override
    public void onBindViewHolder(SportsPoiHolder holder, int position) {
        holder.bindConnection(items.get(position));
    }


    @Override
    public int getItemCount() {
        return items.size();
    }


    public class SportsPoiHolder extends RecyclerView.ViewHolder {
        private PoiListItemSportsBinding binding;

        public SportsPoiHolder(PoiListItemSportsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindConnection(PointOfInterest poi) {
            binding.setPoi(poi);
        }
    }
}
