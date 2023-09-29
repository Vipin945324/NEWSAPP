package digi.coders.newsapp.Models;

import java.util.ArrayList;

import digi.coders.newsapp.Models.AllNewsModel;

public class SecondModel {
    private String status;
    private String totalResults;
    private ArrayList<AllNewsModel> articles;

    public SecondModel() {
    }

    public SecondModel(String status, String totalResults, ArrayList<AllNewsModel> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<AllNewsModel> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<AllNewsModel> articles) {
        this.articles = articles;
    }
}
