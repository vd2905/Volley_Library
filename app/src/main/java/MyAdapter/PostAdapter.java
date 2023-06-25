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

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.viewholder> {

    Context context;
    ArrayList<PostModel> list2;

    public PostAdapter(Context context, ArrayList<PostModel> list2) {
        this.context = context;
        this.list2 = list2;
    }

    @NonNull
    @Override
    public PostAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.post_item,parent,false);
        viewholder viewholder=new viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.viewholder holder, int position) {

        holder.title.setText(list2.get(position).getTitle());
        holder.id.setText(""+list2.get(position).getId());
        holder.body.setText(""+list2.get(position).getBody());


    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView id,title,body;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.id);
            title=itemView.findViewById(R.id.title);
            body=itemView.findViewById(R.id.body);

        }
    }
}
