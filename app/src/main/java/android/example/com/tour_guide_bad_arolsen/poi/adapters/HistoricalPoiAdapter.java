package android.example.com.tour_guide_bad_arolsen.poi.adapters;

import android.databinding.DataBindingUtil;
import android.example.com.tour_guide_bad_arolsen.R;
import android.example.com.tour_guide_bad_arolsen.databinding.PoiListItemHistoricalBinding;
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




public class HistoricalPoiAdapter extends RecyclerView.Adapter<HistoricalPoiAdapter.SimplePoiHolder>{

    private List<HistoricalPlace> items;


    public HistoricalPoiAdapter(List<HistoricalPlace> items) {
        super();
        this.items = items;
        /*This was being overwritten by the list from GastronomyPoiAdapter and I don't know why.
          It's not static !! That's what you get for playing around with very poorly documented
          features like DataBinding. A GOOD documentation includes WORKING EXAMPLES and not 3-liner-
          code-fragments scattered around.
          */
    }

    @Override
    public SimplePoiHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        PoiListItemHistoricalBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.poi_list_item_historical, parent, false);

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
        private PoiListItemHistoricalBinding binding;

        public SimplePoiHolder(PoiListItemHistoricalBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindConnection(PointOfInterest poi) {
            binding.setPoi(poi);
        }
    }

}
