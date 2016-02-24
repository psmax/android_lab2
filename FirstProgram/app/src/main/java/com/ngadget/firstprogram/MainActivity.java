package com.ngadget.firstprogram;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int clr_black = Color.BLACK;
    int clr_red = Color.RED;
    int clr_yellow = Color.YELLOW;
    int clr_green = Color.GREEN;
    int clr_blue = Color.BLUE;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button nextWindow = (Button) findViewById(R.id.buttonNextWindow);
        final Button myBut = (Button) findViewById(R.id.button);
        final CheckBox checks = (CheckBox) findViewById(R.id.checkBox);
        final RadioGroup radGrp = (RadioGroup) findViewById(R.id.rad);
        final RadioButton rad1 = (RadioButton) findViewById(R.id.radioButton);
        final RadioButton rad2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton rad3 = (RadioButton) findViewById(R.id.radioButton3);
        final TextView myText = (TextView) findViewById(R.id.textView);

        nextWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(Constraints.SOME_STR, myText.getText());
                startActivityForResult(intent,1);
            }
        });

        radGrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rad1.isChecked()) {
                    myText.setTextColor(clr_blue);
                } else if (rad2.isChecked()) {
                    myText.setTextColor(clr_green);
                } else if (rad3.isChecked()) {
                    myText.setTextColor(clr_yellow);
                }
            }
        });

        checks.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    myBut.setEnabled(true);
                    rad1.setEnabled(true);
                    rad2.setEnabled(true);
                    rad3.setEnabled(true);
                } else {
                    myBut.setEnabled(false);
                    rad1.setEnabled(false);
                    rad2.setEnabled(false);
                    rad3.setEnabled(false);
                }
            }
        });

        myBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myBut.getCurrentTextColor() == clr_red) {
                    myBut.setTextColor(clr_black);
                } else {
                    myBut.setTextColor(clr_red);
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {return;}
        TextView textbox = (TextView) findViewById(R.id.textView2);
        String name = data.getStringExtra("2");
        textbox.setText(name);
    }
}
