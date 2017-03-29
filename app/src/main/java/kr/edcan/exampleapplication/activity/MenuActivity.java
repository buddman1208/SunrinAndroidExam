package kr.edcan.exampleapplication.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import kr.edcan.exampleapplication.R;
import kr.edcan.exampleapplication.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    Intent receivedIntent;
    ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu);
        receivedIntent = getIntent();
        binding.controlGuest.setOnClickListener(this);
        binding.controlItem.setOnClickListener(this);
        binding.controlMoney.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.controlGuest:
                receivedIntent.putExtra("type", 0);
                break;
            case R.id.controlMoney:
                receivedIntent.putExtra("type", 1);
                break;
            case R.id.controlItem:
                receivedIntent.putExtra("type", 2);
                break;
        }
        setResult(RESULT_OK, receivedIntent);
        finish();
    }
}
