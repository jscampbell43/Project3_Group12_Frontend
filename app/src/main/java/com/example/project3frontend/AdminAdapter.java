package com.example.project3frontend;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdminAdapter extends RecyclerView.Adapter<AdminAdapter.AdminAdapterVH> {
    private List<AdminUsers> user;
    private Context context;
    private ClickedItem clickedItem;

    public AdminAdapter(ClickedItem clickedItem) {
        this.clickedItem = clickedItem;
        //set another clicker item here for trash?

    }
    public void setData(List<AdminUsers> user) {
        this.user = user;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdminAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new AdminAdapter.AdminAdapterVH(LayoutInflater.from(context).inflate(R.layout.activity_list_users, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AdminAdapterVH holder, int position) {
        AdminUsers userResponse = user.get(position);
        String textName = userResponse.getUsername();
        String textEmail = userResponse.getEmail();

        holder.textName.setText(textName);
        holder.textEmail.setText(textEmail);
        holder.textEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedItem.ClickedUser(userResponse);
            }
        });
        holder.textDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //pass another call here: clickedItem.ClickedTrash(userResponse);
            }
        });

    }

    public interface ClickedItem{
        public void ClickedUser(AdminUsers adminUsers);
    }
    //set another interface with ClickerTrash here?

    @Override
    public int getItemCount() {
        return user.size();
    }

    public class AdminAdapterVH extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textEmail;
        ImageView textEdit;
        ImageView textDelete;
        public AdminAdapterVH(@NonNull View itemView) {
            super(itemView);
            textName =  itemView.findViewById(R.id.textName);
            textEmail = itemView.findViewById(R.id.textEmail);
            textEdit = itemView.findViewById(R.id.textEdit);
            textDelete = itemView.findViewById(R.id.textDelete);

        }
    }
}
