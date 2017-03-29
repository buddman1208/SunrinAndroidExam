package kr.edcan.exampleapplication.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import kr.edcan.exampleapplication.R;
import kr.edcan.exampleapplication.databinding.ActivityParcelableExamMenuBinding;
import kr.edcan.exampleapplication.models.SimpleData;

public class ParcelableExamMenuActivity extends AppCompatActivity {
    ActivityParcelableExamMenuBinding binding;
    static final String KEY_SIMPLE_DATA = "data";
    static final int REQUEST_CODE_MENU = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_parcelable_exam_menu);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), ParcelableExamResultActivity.class)
                        .putExtra(KEY_SIMPLE_DATA, new SimpleData(100, "Hello Android")), REQUEST_CODE_MENU);
            }
        });
    }
}
