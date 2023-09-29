package digi.coders.newsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import digi.coders.newsapp.Models.AllNewsModel;
import digi.coders.newsapp.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyNewsViewHolder> {
    Context context;
    List<AllNewsModel>allNewsModelList;

    public NewsAdapter(Context context, List<AllNewsModel> allNewsModels) {
        this.context = context;
        this.allNewsModelList = allNewsModels;
    }

    @NonNull
    @Override
    public MyNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyNewsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.news_lay,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyNewsViewHolder holder, int position) {

        AllNewsModel allNewsModel=allNewsModelList.get(position);

        holder.txtTitle.setText(allNewsModel.getTitle());
        holder.txtDescription.setText(allNewsModel.getDescription());
        holder.txtauthor.setText(""+allNewsModel.getAuthor());
        holder.txtpublishedAt.setText(allNewsModel.getPublishedAt());

        String url = allNewsModel.getUrlToImage();
        Picasso.get().load(url).into(holder.txturlToImage);
    }

    @Override
    public int getItemCount() {
        return allNewsModelList.size();
    }

    public class MyNewsViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtDescription,txtpublishedAt,txtauthor;
        ImageView txturlToImage;
        public MyNewsViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtauthor = itemView.findViewById(R.id.txtauthor);
            txtpublishedAt = itemView.findViewById(R.id.txtpublishedAt);
            txturlToImage = itemView.findViewById(R.id.txturlToImage);
        }
    }
}
