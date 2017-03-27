package kr.edcan.exampleapplication.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import kr.edcan.exampleapplication.R;
import kr.edcan.exampleapplication.databinding.ActivityEditTextBinding;

public class EditTextActivity extends AppCompatActivity {

    TextView resultText;
    ActivityEditTextBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_text);
        setDefault();
    }

    private void setDefault() {
        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.checkBox.isChecked()) {
                    if (isValid(binding.idInput, binding.addressInput, binding.nameInput)) {
                        ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
                        binding.resultText.setText(
                                binding.idInput.getText().toString() + " " +
                                binding.nameInput.getText().toString() + " " +
                                binding.addressInput.getText().toString() + " " + getCheckedGroup(binding.ageGroup) + " \n로 저장되었습니다."
                        );
                    } else
                        Toast.makeText(EditTextActivity.this, "빈칸 없이 입력해주세요!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(EditTextActivity.this, "약관에 동의해주세요!", Toast.LENGTH_SHORT).show();
            }
        });
        binding.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    boolean isValid(EditText... editTexts) {
        for (EditText e : editTexts) {
            if (e.getText().toString().equals("")) return false;
        }
        return true;
    }

    String getCheckedGroup(RadioGroup radioGroup) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.age10:
                return "10대";
            case R.id.age20:
                return "20대";
            case R.id.age30:
                return "30대";
        }
        return "";
    }
}
