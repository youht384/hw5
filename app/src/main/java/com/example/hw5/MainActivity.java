package com.example.hw5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText_Y;
    private EditText editText_M;
    private EditText editText_D;
    private EditText editText_Hr;
    private EditText editText_Min;
    private EditText editText_Sec;
    private Button button;
    private TextView Data_text;
    private TextView Time_text;
    private TextView LeapY_text;
    int Y,M,D,Hr,Min,Sec=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_Y = findViewById(R.id.editText_Y);
        editText_M = findViewById(R.id.editText_M);
        editText_D = findViewById(R.id.editText_D);
        editText_Hr = findViewById(R.id.editText_Hr);
        editText_Min = findViewById(R.id.editText_Min);
        editText_Sec = findViewById(R.id.editText_Sec);
        button = findViewById(R.id.button);
        Data_text = findViewById(R.id.DATE_text);
        Time_text = findViewById(R.id.TIME_text);
        LeapY_text = findViewById(R.id.LeapYear_text);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(editText_Y.getText().toString().matches("")
                        || editText_M.getText().toString().matches("")
                        || editText_D.getText().toString().matches("")
                        ||editText_Hr.getText().toString().matches("")
                        ||editText_Min.getText().toString().matches("")
                        ||editText_Sec.getText().toString().matches("")) {
                    Toast toast = Toast.makeText(MainActivity.this, "Stop kidding now", Toast.LENGTH_LONG);
                    toast.show();
                }
                else{
                    Y = Integer.parseInt(editText_Y.getText().toString());
                    M = Integer.parseInt(editText_M.getText().toString());
                    D = Integer.parseInt(editText_D.getText().toString());
                    Hr = Integer.parseInt(editText_Hr.getText().toString());
                    Min = Integer.parseInt(editText_Min.getText().toString());
                    Sec = Integer.parseInt(editText_Sec.getText().toString());
                   // Min += (Sec/60);
                   // Sec %= 60;
                   // Hr += (Min/60);
                   // Min %= 60;
                   // D += (Hr/24) ;
                   // Hr %= 24;


                    if((Y%4==0 && Y%100!=0) || (Y%400==0 && Y%3200!=0))
                        LeapY_text.setText(getString(R.string.Y_LY_Text));
                    else
                        LeapY_text.setText(getString(R.string.N_LY_Text));

                    Data_text.setText(Y+"/"+M+"/"+D);
                    Time_text.setText(Hr+":"+Min+":"+Sec);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);



                }
            }
        });


    }
}
