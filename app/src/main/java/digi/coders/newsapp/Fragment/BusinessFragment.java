package digi.coders.newsapp.Fragment;

import android.app.ProgressDialog;
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

public class BusinessFragment extends Fragment {

    RecyclerView recylerBusiness;
    String Country = "in";
    String Category = "business";
    int num = 100;
    String QUERY = "78b4332ce5a544f5bffc19e03cf7c6be";
    List<AllNewsModel> allNewsModelList=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_business, container, false);

        recylerBusiness=view.findViewById(R.id.recylerBusiness);

        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Please wait");
        //progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // progressDialog.setProgress(0);
        // progressDialog.setMax(100);
        progressDialog.show();

        RetrofitClient.getClient().getCategoriesNews(Country, Category, num, QUERY).enqueue(new Callback<SecondModel>() {
            @Override
            public void onResponse(Call<SecondModel> call, Response<SecondModel> response) {
                if (response.isSuccessful())
                {
                    progressDialog.dismiss();
                    allNewsModelList.addAll(response.body().getArticles());

                }
                recylerBusiness.setLayoutManager(new LinearLayoutManager(getContext()));
                NewsAdapter userAdapter=new NewsAdapter(getContext(),allNewsModelList);
                userAdapter.notifyDataSetChanged();
                recylerBusiness.setAdapter(userAdapter);

            }
            @Override
            public void onFailure(Call<SecondModel> call, Throwable t) {

            }
        });

        return view;
    }
}