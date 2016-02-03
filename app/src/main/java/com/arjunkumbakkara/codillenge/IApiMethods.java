package com.arjunkumbakkara.codillenge;

/**
 * Created by Arjun Kumbakkara on 31-01-2016.
 */
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;

public interface IApiMethods {

    @GET("/api/rest/subcategory/5174")
    public void getJson(Callback<Response> callback);
}