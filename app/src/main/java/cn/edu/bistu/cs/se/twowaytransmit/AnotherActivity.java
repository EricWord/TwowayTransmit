package cn.edu.bistu.cs.se.twowaytransmit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AnotherActivity extends AppCompatActivity {

    private EditText etSec;
    String content ;
    String secContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
        etSec = (EditText) findViewById(R.id.et_sec);
        Intent intent=getIntent();
        String msa=intent.getStringExtra("message");
        etSec.setText(msa);




        Button button=(Button)findViewById(R.id.buttonReturn);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String secContent = etSec .getText().toString().trim();
                Intent intent2=new Intent(AnotherActivity.this,MainActivity.class);
                intent2.putExtra("message2", secContent);
                startActivityForResult(intent2,0);

                Intent intent=getIntent();
                String msa=intent.getStringExtra("message");
                intent.putExtra("result", msa);
                setResult(0,intent);
                finish();
            }
        });
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2&&resultCode==2){
            String str=data.getStringExtra("result");
//            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
            etSec.setText(str);
        }
    }

}

