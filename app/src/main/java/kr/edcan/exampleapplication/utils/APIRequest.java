package kr.edcan.exampleapplication.utils;

import com.squareup.okhttp.ResponseBody;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Sunrin on 2017-03-06.
 */

public interface APIRequest {

    @GET("/request")
    Call<ResponseBody> getRequest();
}
