package android.example.com.tour_guide_bad_arolsen.poi.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.example.com.tour_guide_bad_arolsen.BR;
import android.example.com.tour_guide_bad_arolsen.R;
import android.example.com.tour_guide_bad_arolsen.databinding.PoiListItemBinding;
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




public class GenericPoiAdapter extends RecyclerView.Adapter<GenericPoiAdapter.ViewHolder>{

    private List<PointOfInterest> items;


    public GenericPoiAdapter(List<PointOfInterest> items) {
        this.items = items;
      }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // this was ViewDataBinding binding but you can't assign handlers
        PoiListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.poi_list_item, parent, false);
        binding.setHandlers(new PoiHandlers()); //use my handlers class
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }


    @Override
    public int getItemCount() {
        return items.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        /**
         *
         * @param binding of type ViewDataBinding which is an
         * abstract Base Class for generated binding classes
         */
        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object obj) {
            binding.setVariable(BR.poi, obj);
            binding.executePendingBindings();

        }
    }

}
