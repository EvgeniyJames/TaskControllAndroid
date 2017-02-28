package com.zamkovenko.taskcontroll.manager;

import com.zamkovenko.taskcontroll.model.Friend;

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

    public ArrayList<Friend> GetFriends() {
        ArrayList<Friend> friends = new ArrayList<>();

        friends.add(new Friend("Francis", "+380965354234"));
        friends.add(new Friend("Bill", "+380965354234"));
        friends.add(new Friend("Louis", "+380965354234"));
        friends.add(new Friend("Zoey", "+380965354234"));

        return friends;
    }
}
