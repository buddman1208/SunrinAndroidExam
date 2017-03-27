package kr.edcan.exampleapplication.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import kr.edcan.exampleapplication.R;
import kr.edcan.exampleapplication.databinding.ActivityInflateBinding;
import kr.edcan.exampleapplication.databinding.Sub1Binding;

public class InflateActivity extends AppCompatActivity {
    ActivityInflateBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_inflate);
        setDefault();
    }

    private void setDefault() {
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sub1Binding sub1Binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.sub1, binding.container, true);
                sub1Binding.checkBox.setText("예아");
            }
        });
    }
}
