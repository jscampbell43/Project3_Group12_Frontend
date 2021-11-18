package com.example.project3frontend;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project3frontend.ProjectListViewModel;
import com.example.project3frontend.R;

/**
 * The type <Projects> list view holder.
 */


public class ProjectListViewHolder extends RecyclerView.ViewHolder {


    //Help from https://willowtreeapps.com/ideas/android-fundamentals-working-with-the-recyclerview-adapter-and-viewholder-pattern

    /**
     * The Id.
     */
    TextView id;
    /**
     * The Title.
     */
    TextView title;
    /**
     * The Description.
     */
    TextView description;

    /**
     * The Gender.
     */
    TextView image;
    /**
     * The Trash btn.
     */
//    ImageView trashBtn;
//    /**
//     * The Fav info btn.
//     */
//    ImageView favInfoBtn;


    /**
     * Instantiates a new Pet list view holder.
     *
     * @param itemView the item view
     */
    public ProjectListViewHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.textViewProjectId);
        title = itemView.findViewById(R.id.textViewProjectTitle);
        description = itemView.findViewById(R.id.textViewProjectDescription);
        image = itemView.findViewById(R.id.imageViewProjectImage);

//        trashBtn = itemView.findViewById(R.id.ivTrash);
//        favInfoBtn = itemView.findViewById(R.id.ivInfoFav);
    }

    /**
     * Bind data.
     *
     * @param viewModel the view model
     */
    public void bindData(final ProjectListViewModel viewModel) {
        id.setText(String.valueOf(viewModel.getId()));
        title.setText(viewModel.getTitle());
        description.setText(viewModel.getDescription());
        image.setText(viewModel.getImage());

    }
}