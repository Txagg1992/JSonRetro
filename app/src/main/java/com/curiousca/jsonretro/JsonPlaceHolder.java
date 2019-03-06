package com.curiousca.jsonretro;

import com.curiousca.jsonretro.model.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface JsonPlaceHolder {

    String BASE_URL = "https://one-np.stg.telematicsct.com/";

    @Headers("Content-Type: application/json")
    @GET ("notification-preferences/v1/guid//*{guid}*/")
    Call<Data> getPayload(
            /*@Path("guid") String guid*/
    );
}
