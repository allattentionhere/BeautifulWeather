package com.allattentionhere.beautifulweather.network;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SkeletonServiceAPI {

  @GET("users/{username}/repos")
  Call<List<String>> getReposForUser(@Path("username") String username);

  @GET("repositories")
  Call<List<String>> getAllRepos();

  @GET("users/{username}")
  Call<String> getUser(@Path("username") String username);
}
