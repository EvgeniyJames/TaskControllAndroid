package com.zamkovenko.taskcontroll.service;

import com.zamkovenko.taskcontroll.manager.AccountManager;
import com.zamkovenko.taskcontroll.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * User: Yevgeniy Zamkovenko
 * Date: 09.05.2017
 */

public interface FriendService {

    @GET("{user}/friends")
    Call<List<User>> listFriends(@Header("Authorization") String token, @Path("user") String user);

}
