package MyAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.volley_library.R;

import java.util.ArrayList;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.viewholder> {

    Context context;
    ArrayList<PhotoModel> list1;

    public PhotoAdapter(Context context, ArrayList<PhotoModel> list1) {
        this.context = context;
        this.list1 = list1;
    }

    @NonNull
    @Override
    public PhotoAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.photo_item,parent,false);
        viewholder viewholder=new viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.viewholder holder, int position) {

        holder.title.setText(list1.get(position).getTitle());
        holder.id.setText(""+list1.get(position).getId());
        Glide.with(context)
                .load(list1.get(position)
                        .getThumbnailUrl()). centerCrop()
                .into(holder.thumbnailUrl);

    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView id,title;
        ImageView thumbnailUrl;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.id);
            title=itemView.findViewById(R.id.title);
            thumbnailUrl=itemView.findViewById(R.id.thumbnailUrl);

        }
    }
}
