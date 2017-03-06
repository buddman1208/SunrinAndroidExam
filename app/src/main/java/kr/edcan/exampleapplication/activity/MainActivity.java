package kr.edcan.exampleapplication.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import kr.edcan.exampleapplication.R;
import kr.edcan.exampleapplication.utils.NetworkHelper;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDefault();
        setNetwork();
        setDB();
    }

    private void setDefault() {
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkHelper.getNetworkInstance().getRequest().enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        switch (response.code()) {
                            case 200:
                                try {
                                    Toast.makeText(MainActivity.this, response.body().string() + "", Toast.LENGTH_SHORT).show();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
            }
        });
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
