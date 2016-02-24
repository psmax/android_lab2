package com.ngadget.firstprogram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        final TextView txt = (TextView) findViewById(R.id.someText);
        final String someStr = getIntent().getStringExtra(Constraints.SOME_STR);
        txt.setText(someStr);

       findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
               intent.putExtra("lol", txt.getText());
               setResult(RESULT_OK, intent);
               finish();
           }
       });

    }
}
