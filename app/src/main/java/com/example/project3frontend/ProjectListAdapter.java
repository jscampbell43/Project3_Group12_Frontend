package com.example.project3frontend;

import static java.lang.Integer.parseInt;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * The type Project list adapter.
 */
public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ProjectListViewHolder> {

    List<Project> projects;
    Context context;
    OnProjectClickListener onProjectClickListener;

    //Constructor
    // Needs array input parameter
    public ProjectListAdapter(Context c, List<Project> d, OnProjectClickListener listener){
        context = c;
        projects = d;
        onProjectClickListener = listener;

    }

    @NonNull
    @Override
    public ProjectListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.project_itemview, parent, false);
        return new ProjectListViewHolder(view, onProjectClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectListViewHolder holder, int position) {
        holder.titleText.setText(projects.get(position).getProjectName());
        holder.descriptionText.setText(projects.get(position).getDescription());
        if(projects.get(position).getUrlString() != "") {
            Picasso.get().load(projects.get(position).getUrlString()).into(holder.projectImage);
        }
        else{
            Picasso.get().load("https://i.ibb.co/n60FksF/Fila-logo1-small.png").into(holder.projectImage);
        }
        //.setImageResource(projects.get(position).getUrlString());

//        holder.projectDetailsLayout.setOnClickListener(new View.OnClickListener(){
//
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, OpenProjectDetailsActivity.class);
//                intent.putExtra("data", data[position]);
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public class ProjectListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView titleText, descriptionText;
        ImageView projectImage;
        ConstraintLayout projectDetailsLayout;
        public OnProjectClickListener onProjectClickListener;

        public ProjectListViewHolder(@NonNull View itemView, OnProjectClickListener listener) {
            super(itemView);
            titleText = itemView.findViewById(R.id.textViewProjectTitle);
            descriptionText = itemView.findViewById(R.id.textViewProjectDescription);
            projectImage = itemView.findViewById(R.id.imageViewProjectImage);
            projectDetailsLayout = itemView.findViewById(R.id.projectDetailsLayout);
            onProjectClickListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onProjectClickListener.onProjectClick(getAbsoluteAdapterPosition());
        }
    }

    public interface OnProjectClickListener{
        void onProjectClick(int position);
    }

}
