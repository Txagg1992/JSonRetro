package com.curiousca.jsonretro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.curiousca.jsonretro.model.Data;
import com.curiousca.jsonretro.model.PayLoad;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "payloadName";

    public static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private JsonAdapter mJsonAdapter;
    //private ArrayList<ExampleItemPost> mExampleItemPost;
    private ArrayList<PayLoad> mPayload;
    private static final String BASE_URL = "https://one-np.stg.telematicsct.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildRecyclerView();
        parseJson();

        mPayload = new ArrayList<>();

    }

    private void parseJson() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);

        Call<Data> call = jsonPlaceHolder.getPayload();

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Code: " + response.code(),
                            Toast.LENGTH_LONG).show();
                    Log.d("NotResponseSuccessful", "Code: " + response.code());
                    return;
                }else {
                    Toast.makeText(getApplicationContext(), "Code: " + response.code(),
                            Toast.LENGTH_LONG).show();
                    Log.d("Success!", "Response Code is " + response.code());
                }

                ArrayList<PayLoad> payload = response.body().getPayload();
                for (int i = 0; i < payload.size(); i++){

                    payload.get(i).getName();
                    payload.get(i).getSubtitle();
                    payload.get(i).getPushAvailable();
                    payload.get(i).getSmsAvailable();
                    payload.get(i).getEmailAvailable();
                    payload.get(i).getPushEnabled();
                    payload.get(i).getSmsEnabled();
                    payload.get(i).getEmailEnabled();

                    Log.d(TAG, "onResponse: \n" +
                            "Name: " + payload.get(i).getName() + "\n" +
                            "Subtitle: " + payload.get(i).getSubtitle()+ "\n" +
                            "Push Available: " + payload.get(i).getPushAvailable() + "\n" +
                            "Email Available: " + payload.get(i).getEmailAvailable() + "\n" +
                            "Sms Available: " + payload.get(i).getSmsAvailable());
                }
                mJsonAdapter = new JsonAdapter(getApplicationContext(), payload);
                mRecyclerView.setAdapter(mJsonAdapter);

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("onFailure", t.getMessage());
            }
        });

    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
