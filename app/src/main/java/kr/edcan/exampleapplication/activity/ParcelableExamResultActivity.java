package kr.edcan.exampleapplication.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import kr.edcan.exampleapplication.R;
import kr.edcan.exampleapplication.databinding.ActivityParcelableExamMenuBinding;
import kr.edcan.exampleapplication.databinding.ActivityParcelableExamResultBinding;
import kr.edcan.exampleapplication.models.SimpleData;

public class ParcelableExamResultActivity extends AppCompatActivity {

    ActivityParcelableExamResultBinding binding;
    Intent intent;
    static final String KEY_SIMPLE_DATA = "data";
    static final int REQUEST_CODE_MENU = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_parcelable_exam_result);
        intent = getIntent();
        processIntent(intent);
    }

    void processIntent(Intent intent) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            SimpleData data = (SimpleData) bundle.getParcelable(KEY_SIMPLE_DATA);
            binding.text.setText(data.getNumber() + " "+data.getData());
        } else return;
    }
}
