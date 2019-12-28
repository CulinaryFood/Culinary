package id.ac.polinema.culinaryfood.Filter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.ac.polinema.culinaryfood.R;
import id.ac.polinema.culinaryfood.models.MenuModel;

public class FilterMenuAdapters extends RecyclerView.Adapter<FilterMenuAdapters.MyHolder> implements Filterable {
    List<MenuModel> menuModelList;
    List<MenuModel> menuModelListFull;

    public FilterMenuAdapters(List<MenuModel> menuModelList) {
        this.menuModelList = menuModelList;
        menuModelListFull = new ArrayList<>(menuModelList);
    }

    @NonNull
    @Override
    public FilterMenuAdapters.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_menu, parent, false);
        MyHolder viewHolder = new MyHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilterMenuAdapters.MyHolder holder, int position) {
        MenuModel menuModel = menuModelList.get(position);
        holder.image.setImageResource(menuModel.getImage());
        holder.menu.setText(menuModel.Menu);
        holder.harga.setText(menuModel.harga);
    }

    @Override
    public int getItemCount() {
        return (menuModelList != null) ? menuModelList.size() : 0;
    }

    public void filterList(List<MenuModel> filteredList) {
        menuModelList = filteredList;
        notifyDataSetChanged();
    }
    @Override
    public Filter getFilter() {
        return Filters;
    }

    private Filter Filters = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<MenuModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(menuModelListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (MenuModel item : menuModelListFull) {
                    if (item.getMenu().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            menuModelList.clear();
            menuModelList.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class MyHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView menu;
        public TextView harga;
//        public RelativeLayout layout_parent;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            image =itemView.findViewById(R.id.gambar);
            menu = itemView.findViewById(R.id.name);
            harga = itemView.findViewById(R.id.harga);
//            layout_parent = itemView.findViewById(R.id.parent_Layout);
        }
    }


}
