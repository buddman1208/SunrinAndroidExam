package kr.edcan.exampleapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNetwork();
        setDB();
    }

    private void setDB() {
        SharedPreferences sharedPreferences = getSharedPreferences("KOHA", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Write
        editor.putBoolean("AM_I_STUDYING", false);
        editor.apply();
    }

    private void setNetwork() {
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

    }
}
