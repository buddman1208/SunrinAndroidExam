package kr.edcan.exampleapplication.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import kr.edcan.exampleapplication.R;
import kr.edcan.exampleapplication.databinding.ActivityAfterLoginBinding;
import kr.edcan.exampleapplication.utils.SharedPrefManager;

public class AfterLoginActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityAfterLoginBinding binding;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_after_login);
        setDefault();
    }

    private void setDefault() {
        intent = getIntent();
        binding.statusText.setText(intent.getStringExtra("id") + "님 환영합니다");
        binding.class304.setOnClickListener(this);
        binding.class305.setOnClickListener(this);
        binding.class306.setOnClickListener(this);
        binding.selectedClass.setText(SharedPrefManager.getInstance(getApplicationContext()).getSelectedClass());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.class304:
                startActivity(new Intent(getApplicationContext(), ClassSelectActivity.class).putExtra("class", 4));
                break;
            case R.id.class305:
                startActivity(new Intent(getApplicationContext(), ClassSelectActivity.class).putExtra("class", 5));
                break;
            case R.id.class306:
                startActivity(new Intent(getApplicationContext(), ClassSelectActivity.class).putExtra("class", 6));
                break;
            case R.id.logoutBtn:
                finish();
                Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (binding != null)
            binding.selectedClass.setText(SharedPrefManager.getInstance(getApplicationContext()).getSelectedClass());
    }
}
