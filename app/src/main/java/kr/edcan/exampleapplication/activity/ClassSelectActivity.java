package kr.edcan.exampleapplication.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import kr.edcan.exampleapplication.R;
import kr.edcan.exampleapplication.databinding.ActivityClassSelectBinding;
import kr.edcan.exampleapplication.utils.SharedPrefManager;

public class ClassSelectActivity extends AppCompatActivity {

    Intent intent;
    ActivityClassSelectBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_class_select);
        setDefault();
    }

    private void setDefault() {
        intent = getIntent();
        int selectedIndex = intent.getIntExtra("class", -1);
        SharedPrefManager.getInstance(getApplicationContext()).saveSelectedClass(selectedIndex);
        binding.statusText.setText("3학년 " + selectedIndex + "반");
        binding.returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
    }
}
