package com.example.madcampweek2.api;

import com.example.madcampweek2.model.Contact;
import com.example.madcampweek2.model.MapUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetroApi {
    // Get : load list of all users in database
    @GET("api/users")
    Call<List<MapUser>> getUsers();

    // Get : load user's contacts via uid
    @GET("api/contacts/{uid}")
    Call<List<Contact>> getUserContacts(@Path("uid") String uid);

    // Get : load user's images via uid
    @GET("api/images/{uid}")
    Call<List<MapUser>> getUserImages(@Path("uid") String uid);

    // Post : register in user database
    @POST("api/register")
    Call<MapUser> registerUser(@Body MapUser mapUser);

    // Post : ??
    @POST("api/login")
    Call<MapUser> loginUser(@Body MapUser mapUser);

}