package com.zamkovenko.taskcontroll.manager;

import com.zamkovenko.taskcontroll.model.Account;

import java.util.List;

/**
 * User: Yevgeniy Zamkovenko
 * Date: 09.05.2017
 */

public class AccountManager {

    private static AccountManager m_instance;

    private String m_token;

    private Account currentAccount;

    public static AccountManager GetInstance(){
        if(m_instance == null){
            m_instance = new AccountManager();
        }
        return m_instance;
    }

    private AccountManager(){

    }

    public void SetAccount(Account account){
        currentAccount = account;
    }

    public boolean IsLogedIn(){
        return currentAccount != null;
    }

    public String getAccountId(){
        return currentAccount.getLogin();
    }

    public void SetToken(String token) {
        m_token = token;
    }

    public String GetToken() {
        return m_token;
    }
}
