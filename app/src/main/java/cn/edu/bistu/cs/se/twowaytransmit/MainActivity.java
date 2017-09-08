package cn.edu.bistu.cs.se.twowaytransmit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEtContent;
    private EditText etContent;
    private EditText etSec;
    String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.buttonToAnother);
        etContent = (EditText) findViewById(R.id.et_content);
        etSec = (EditText) findViewById(R.id.et_sec);

        Intent intent2=getIntent();
        String msa=intent2.getStringExtra("message2");
        intent2.putExtra("result2", msa);
        setResult(0,intent2);
        finish();
        // TODO Auto-generated method stub




        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                content =  etContent.getText().toString().trim();
                Intent intent=new Intent(MainActivity.this,AnotherActivity.class);
                intent.putExtra("message", content);
                startActivityForResult(intent,0);

            }
        });
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0&&resultCode==0){
            String str=data.getStringExtra("result2");
            etContent.setText(str);


//            String str=content;
//            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
//            Toast.makeText(this,content, Toast.LENGTH_SHORT).show();
        }
    }
}
