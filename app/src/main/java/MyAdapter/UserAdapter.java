package MyAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.volley_library.R;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.viewholder> {

    Context context;
    ArrayList<UserModel> list;

    public UserAdapter(Context context, ArrayList<UserModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public UserAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.user_item,parent,false);
        viewholder viewholder=new viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.viewholder holder, int position) {
        holder.id.setText(""+list.get(position).getId());
        holder.name.setText(""+list.get(position).getName());
        holder.username.setText(""+list.get(position).getUsername());
        holder.phone.setText(""+list.get(position).getPhone());
        holder.company.setText(""+list.get(position).getCompany());
        holder.website.setText(""+list.get(position).getWebsite());
        holder.address.setText(""+list.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView id,name,username,phone,company,website,address;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.re_name);
            id=itemView.findViewById(R.id.re_id);
            username=itemView.findViewById(R.id.re_username);
            phone=itemView.findViewById(R.id.re_phone);
            company=itemView.findViewById(R.id.re_company);
            website=itemView.findViewById(R.id.re_website);
            address=itemView.findViewById(R.id.re_address);
        }
    }
}
