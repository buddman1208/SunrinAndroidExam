package kr.edcan.exampleapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import kr.edcan.exampleapplication.R;

public class StartActivityResultActivity extends AppCompatActivity {

    static final int REQUEST_CODE = 6974;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_result);
        (findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(), MenuActivity.class), REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    ((TextView) findViewById(R.id.resultText)).setText(data.getStringExtra("name") + " 이 수신되었습니다.");
                    break;
                default:
                    Toast.makeText(this, "User에 의해 취소되었습니다", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
