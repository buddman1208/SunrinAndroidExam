package kr.edcan.exampleapplication.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import kr.edcan.exampleapplication.R;
import kr.edcan.exampleapplication.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {

    Intent receivedIntent;
    ActivityMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu);
        receivedIntent = getIntent();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                receivedIntent.putExtra("name", binding.editText.getText().toString().trim());
                setResult(RESULT_OK, receivedIntent);
                finish();
            }
        });
    }
}
