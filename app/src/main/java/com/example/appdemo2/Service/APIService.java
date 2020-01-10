package com.example.appdemo2.Service;

public class APIService {

    private static String base_url = "https://posological-wreck.000webhostapp.com/Server/";

    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}
