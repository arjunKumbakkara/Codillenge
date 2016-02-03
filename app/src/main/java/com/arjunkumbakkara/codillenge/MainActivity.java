package com.arjunkumbakkara.codillenge;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;


public class MainActivity extends ActionBarActivity {
    @SuppressWarnings("unused")
    private static final int ITEM_COUNT = 50;
    private List<Item> items;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create some items

        items = new ArrayList<>();


        getItem();
    }

    public void getItem(){

        //While the app fetched data we are displaying a progress dialog
        final ProgressDialog loading = ProgressDialog.show(this,"Fetching Data","Please wait...",false,false);

        //Creating a rest adapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://www.freshon.in")
                .build();

        //Creating an object of our api interface
        IApiMethods api = adapter.create(IApiMethods.class);

        //Defining the method
        api.getJson(new Callback<Response>(){
            @Override
            public void success(Response list, Response response) {
                JSONObject lister;
                try {
                    lister = new JSONObject(new String(((TypedByteArray) response.getBody()).getBytes()));
                    Log.d("List", lister.getJSONArray("subcategory_details").toString());
                    Gson gson = new Gson();
                    Type listType = new TypeToken<List<Item>>(){}.getType();
                    List<Item> posts = (List<Item>) gson.fromJson(lister.getJSONArray("subcategory_details").toString(), listType);
                    Log.d("List", posts.get(0).getprduct_name());
                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                    recyclerView.setAdapter(new Adapter(getApplicationContext(), posts));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //Dismissing the loading progressbar
                loading.dismiss();

            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("Failure",error.toString());
                //you can handle the errors here
            }
        });
    }




}