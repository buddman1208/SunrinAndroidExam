package kr.edcan.exampleapplication.activity;

import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
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
        ((RadioGroup) findViewById(R.id.group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                Toast.makeText(MainActivity.this, ((checkedId == R.id.button01) ? "남성" : "여성") + "이 선택되었습니다", Toast.LENGTH_SHORT).show();
            }
        });
        BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(R.mipmap.ic_launcher);
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Toast.makeText(this, width + " " +height+"", Toast.LENGTH_LONG).show();
    }

}
