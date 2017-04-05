package kr.edcan.exampleapplication.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import kr.edcan.exampleapplication.R;
import kr.edcan.exampleapplication.databinding.ActivityLoginBinding;
import kr.edcan.exampleapplication.utils.SharedPrefManager;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        SharedPrefManager.getInstance(getApplicationContext()).destroy();
        binding.exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.id.setText(SharedPrefManager.getInstance(getApplicationContext()).getId());
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!binding.id.getText().toString().equals("") && !binding.pw.getText().toString().equals("")) {
                    startActivity(new Intent(getApplicationContext(), AfterLoginActivity.class)
                            .putExtra("id", binding.id.getText().toString()));
                    SharedPrefManager.getInstance(getApplicationContext()).saveId(binding.id.getText().toString());
                } else Toast.makeText(LoginActivity.this, "빈칸 빼놓지마라", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (binding != null) {
            binding.id.setText(SharedPrefManager.getInstance(getApplicationContext()).getId());
        }
    }
}
