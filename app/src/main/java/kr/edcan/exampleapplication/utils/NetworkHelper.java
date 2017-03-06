package kr.edcan.exampleapplication.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by Sunrin on 2017-03-06.
 */

public class NetworkHelper {
    private Context context;
    final public static String url = "http://hangeulro.iwin247.kr";
    final public static int port = 80;

    public NetworkHelper(Context context) {
        this.context = context;
    }

    public static Retrofit retrofit;

    public static APIRequest getNetworkInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url + ":" + port)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(APIRequest.class);
    }

    public static boolean returnNetworkState(Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
