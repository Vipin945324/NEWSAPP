package digi.coders.newsapp.Interface;

import digi.coders.newsapp.Models.SecondModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIServices {

    @GET("top-headlines")
    Call<SecondModel>getAllNews(
            @Query("country")String country,
            @Query("pageSize")int pageSize,
            @Query("apiKey")String apiKey
    );

    @GET("top-headlines")
    Call<SecondModel>getCategoriesNews(
            @Query("country")String country,
            @Query("category")String category,
            @Query("pageSize")int pageSize,
            @Query("apiKey")String apiKey
    );
}
