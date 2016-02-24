package com.ngadget.firstprogram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private String someString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final TextView txt = (TextView) findViewById(R.id.secondActivityText);
        someString = getIntent().getStringExtra(Constraints.SOME_STR);
        txt.setText(someString);

        findViewById(R.id.buttonNextWindow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                intent.putExtra(Constraints.SOME_STR, someString);
                startActivityForResult(intent,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {return;}
        String name = data.getStringExtra("lol");
        Intent intent = new Intent();
        intent.putExtra("2", name);
        setResult(RESULT_OK,intent);
        finish();
    }
}
