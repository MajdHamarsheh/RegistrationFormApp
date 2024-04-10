package com.example.myapplicationInClass;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextEmail;
    RadioGroup radioGroupGender;
    RadioButton radioButtonMale, radioButtonFemale;
    Switch switchLastYear;
    Button buttonSubmit;
    TextView textViewHiddenData;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        switchLastYear = findViewById(R.id.switchLastYear);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textViewHiddenData = findViewById(R.id.hiddenTextView);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                String gender = "";

                int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
                if (selectedGenderId == radioButtonMale.getId()) {
                    gender = "Male";
                } else if (selectedGenderId == radioButtonFemale.getId()) {
                    gender = "Female";
                }

                boolean hadAccountLastYear = switchLastYear.isChecked();

                if (name.isEmpty() || email.isEmpty() || gender.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                } else {

                    String hiddenData =  name + "\n" + email + "\n" + gender + "\nlast year : " + (hadAccountLastYear ? "Yes" : "No");
                    textViewHiddenData.setText(hiddenData);


                    textViewHiddenData.setVisibility(View.VISIBLE);

                    Toast.makeText(MainActivity.this, "Data set to hidden TextView", Toast.LENGTH_SHORT).show();
                }
            }
});
}
}