package digi.coders.newsapp.Retrofit;

import digi.coders.newsapp.Interface.APIServices;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public  static APIServices getClient(){
        Retrofit retrofit=new Retrofit
                .Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIServices apiServices=retrofit.create(APIServices.class);
        return apiServices;
    }
}
