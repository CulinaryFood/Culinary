package id.ac.polinema.culinaryfood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ConcurrentModificationException;
import java.util.List;

import id.ac.polinema.culinaryfood.R;
import id.ac.polinema.culinaryfood.models.RestoModel;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {
    List<RestoModel> restoModelList;
    public adapter(List<RestoModel> restoModelList){
        this.restoModelList = restoModelList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_resto, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RestoModel restoModel = restoModelList.get(position);
        holder.image.setImageResource(restoModel.getImage());
        holder.name.setText(restoModel.name);
        holder.alamat.setText(restoModel.alamat);
    }

    @Override
    public int getItemCount() {
        return (restoModelList != null) ? restoModelList.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView name;
        public TextView alamat;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image =itemView.findViewById(R.id.gambar);
            name = itemView.findViewById(R.id.name);
            alamat = itemView.findViewById(R.id.alamat);
        }
    }
}
