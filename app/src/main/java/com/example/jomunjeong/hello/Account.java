package com.example.jomunjeong.hello;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jomunjeong on 2015. 11. 18..
 */
public class Account {

    String siteName;
    String url;
    String id;
    String pw;


    Account(){
        super();
    }

    Account(String siteName, String url, String id, String pw){
        this.siteName = siteName;
        this.url = url;
        this.id = id;
        this.pw = pw;
    }


    private static List<Account> accounts;

    // This method creates an ArrayList that has three Account objects
    // Checkout the project associated with this tutorial on Github if
    // you want to use the same images.

    public static List<Account> initializeData(){
        accounts = new ArrayList<>();
        accounts.add(new Account("네이버", "www.naver.com", "dnpsel04", "ubcare1!"));
        accounts.add(new Account("ubware", "www.ubware.com", "mjjo04", "dbqlzpdj1!"));
        accounts.add(new Account("자연이랑", "www.abc.com", "mjjo04", "ubcare1!"));

        return accounts;
    }

}

