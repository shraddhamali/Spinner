package com.shraddha.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;                                                               //As a lable
    EditText editText;                                                              //edit text to enter text
    Spinner spinner;                                                                //to drop down list
    static String string,string1;
    RadioButton radioButton,radioButton1;                       //For select only one option
    RadioGroup radioGroup;                                      //to set radio button if we select one then 2nd get unchecked automatically
    CheckBox checkBox;                                          //to use select more option
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                                 //getting objct from xml file
        spinner=findViewById(R.id.spinner);
        textView=findViewById(R.id.textView);
        editText=findViewById(R.id.editTextTextPersonName);
        radioButton=findViewById(R.id.radioButton);
        radioButton1=findViewById(R.id.radioButton2);
        radioGroup=findViewById(R.id.radio_may);
        checkBox=findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {      //to select item
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {//if it is checked then button has been changed
                if(compoundButton.isChecked())
                {
                    editText.setVisibility(View.INVISIBLE);
                    radioGroup.setVisibility(View.INVISIBLE);
                    spinner.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.INVISIBLE);
                }else
                {
                    editText.setVisibility(View.VISIBLE);
                    radioGroup.setVisibility(View.VISIBLE);
                    spinner.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                }

            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {        //to get listed spinner
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s= editText.getText().toString().trim();
                string= String.valueOf(adapterView.getItemAtPosition(i));
                string=string + "\n Welcome " +s +string1;
                textView.setText(string);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {//call back method

            }
        });

    }

    public void onRadioButtonClicked(View view) {
        boolean status_checked=((RadioButton)view).isChecked();
        switch (view.getId())
        {
            case R.id.radioButton:
                if(status_checked)
                {
                    string1= "\n"+"Gender "+radioButton.getText().toString().trim();
                }

                break;
            case R.id.radioButton2:
                if(status_checked) {
                    string1 = "\n"+"Gender " + radioButton1.getText().toString().trim() + "\n";
                }
                break;
        }

    }
}