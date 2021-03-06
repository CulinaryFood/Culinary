package id.ac.polinema.culinaryfood.adapters;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.ac.polinema.culinaryfood.R;
import id.ac.polinema.culinaryfood.activities.detailActivity;
import id.ac.polinema.culinaryfood.models.RestoModel;

public class Adapters extends RecyclerView.Adapter<Adapters.MyViewHolder> implements Filterable {
    List<RestoModel> restoModelList;
    List<RestoModel> restoModelListFull;
    ArrayList<String> mName = new ArrayList<>();
    ArrayList<String> mAlamat = new ArrayList<>();
    Context mContext;

    public Adapters(List<RestoModel> restoModelList){
        this.restoModelList = restoModelList;
        restoModelListFull = new ArrayList<>(restoModelList);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.activity_item_resto, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        RestoModel restoModel = restoModelList.get(position);
        holder.image.setImageResource(restoModel.getImage());
        holder.name.setText(restoModel.name);
        holder.alamat.setText(restoModel.alamat);

        holder.layout_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,detailActivity.class);
                intent.putExtra("name", mName);
                intent.putExtra("alamat", mAlamat);
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return (restoModelList != null) ? restoModelList.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView name;
        public TextView alamat;
        public RelativeLayout layout_parent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image =itemView.findViewById(R.id.gambar);
            name = itemView.findViewById(R.id.name);
            alamat = itemView.findViewById(R.id.alamat);
            layout_parent = itemView.findViewById(R.id.parent_Layout);
        }
    }
    public void filterList(List<RestoModel> filteredList) {
        restoModelList = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return Filters;
    }
    private Filter Filters = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<RestoModel> filteredList = new ArrayList<>();
            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(restoModelListFull);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (RestoModel item : restoModelListFull){
                    if (item.getName().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values =filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            restoModelList.clear();
            restoModelList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
