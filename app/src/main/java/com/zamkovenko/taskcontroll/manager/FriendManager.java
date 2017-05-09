package com.zamkovenko.taskcontroll.manager;

import com.zamkovenko.taskcontroll.model.User;

import java.util.ArrayList;

/**
 * User: EvgeniyJames
 * Date: 28.02.2017
 */

public class FriendManager {
    private static FriendManager s_instance;

    private FriendManager(){

    }

    public static FriendManager GetInstance(){
        if (s_instance == null) {
            s_instance = new FriendManager();
        }
        return s_instance;
    }

    public ArrayList<User> GetFriends() {
        ArrayList<User> friends = new ArrayList<>();

        friends.add(new User("Francis", "+380965354234"));
        friends.add(new User("Bill", "+380965354234"));
        friends.add(new User("Louis", "+380965354234"));
        friends.add(new User("Zoey", "+380965354234"));

        return friends;
    }
}
