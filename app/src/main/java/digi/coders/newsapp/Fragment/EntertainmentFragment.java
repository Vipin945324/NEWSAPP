package digi.coders.newsapp.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import digi.coders.newsapp.Models.AllNewsModel;
import digi.coders.newsapp.Adapter.NewsAdapter;
import digi.coders.newsapp.R;
import digi.coders.newsapp.Retrofit.RetrofitClient;
import digi.coders.newsapp.Models.SecondModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntertainmentFragment extends Fragment {

    RecyclerView recyleEntertainment;
    String Country = "in";
    String Category = "entertainment";
    int num = 100;
    String QUERY = "78b4332ce5a544f5bffc19e03cf7c6be";

    List<AllNewsModel> allNewsModelList=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_entertainment, container, false);

        recyleEntertainment=view.findViewById(R.id.recyleEntertainment);

        RetrofitClient.getClient().getCategoriesNews(Country, Category, num, QUERY).enqueue(new Callback<SecondModel>() {
            @Override
            public void onResponse(Call<SecondModel> call, Response<SecondModel> response) {
                if (response.isSuccessful())
                {
                    allNewsModelList.addAll(response.body().getArticles());

                }
                recyleEntertainment.setLayoutManager(new LinearLayoutManager(getContext()));
                NewsAdapter userAdapter=new NewsAdapter(getContext(),allNewsModelList);
                userAdapter.notifyDataSetChanged();
                recyleEntertainment.setAdapter(userAdapter);

            }
            @Override
            public void onFailure(Call<SecondModel> call, Throwable t) {

            }
        });

        return view;
    }
}