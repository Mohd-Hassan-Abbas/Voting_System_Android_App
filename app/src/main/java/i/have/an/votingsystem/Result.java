package i.have.an.votingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {

    int vaap, vbjp, vaimim, vinc, vother;
    TextView Res, taap,tbjp,taimim,tinc,tother, title,hlink;
    EditText ename, epass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_result);

        Res = findViewById(R.id.res);
        taap = findViewById(R.id.vaap);
        tbjp = findViewById(R.id.vbjp);
        taimim = findViewById(R.id.vaimim);
        tinc = findViewById(R.id.vinc);
        tother = findViewById(R.id.vother);

        ename = findViewById(R.id.ename);
        epass = findViewById(R.id.epass);
        title = findViewById(R.id.title);
        hlink = findViewById(R.id.hlink);

        epass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(i==5&&ename.length()==6){
                    if(charSequence.toString().equals("hassan")&&ename.getText().toString().equals("hassan")){
                        ename.setVisibility(View.GONE);
                        epass.setVisibility(View.GONE);
                        hlink.setVisibility(View.GONE);
                        title.setVisibility(View.GONE);
                        Res.setVisibility(View.VISIBLE);
                        taap.setVisibility(View.VISIBLE);
                        tbjp.setVisibility(View.VISIBLE);
                        taimim.setVisibility(View.VISIBLE);
                        tinc.setVisibility(View.VISIBLE);
                        tother.setVisibility(View.VISIBLE);
                    }else{
                        Toast.makeText(Result.this,"Wrong! Try Again",Toast.LENGTH_SHORT).show();
                    }
                }
                   }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        hlink.setOnClickListener(view -> {
            Toast.makeText(Result.this,"Contact Developer",Toast.LENGTH_SHORT).show();
        });

        Intent i = getIntent();
        vaap = i.getExtras().getInt("vaap");
        vbjp = i.getExtras().getInt("vbjp");
        vaimim = i.getExtras().getInt("vaimim");
        vinc = i.getExtras().getInt("vinc");
        vother = i.getExtras().getInt("vother");

        if(vaap>vbjp&&vaap>vaimim&&vaap>vinc&&vaap>vother){
            Res.setText("APP win with "+vaap+" votes");
        }else if(vbjp>vaap&&vbjp>vaimim&&vbjp>vinc&&vbjp>vother){
            Res.setText("BJP win with "+vbjp+" votes");
        }else if(vaimim>vbjp&&vaimim>vaap&&vaimim>vinc&&vaimim>vother){
            Res.setText("AIMIM win with "+vaimim+" votes");
        }else if(vinc>vbjp&&vinc>vaimim&&vinc>vaap&&vinc>vother){
            Res.setText("INC win with "+vinc+" votes");
        }else if(vother>vbjp&&vother>vaimim&&vother>vinc&&vother>vaap){
            Res.setText("Other's win with "+vother+" votes");
        }else{
            Res.setText("Oop's difficult!");
        }
        taap.setText("APP :- "+vaap);
        tbjp.setText("BJP :- "+vbjp);
        tinc.setText("INC :- "+vinc);
        taimim.setText("AIMIM :- "+vaimim);
        tother.setText("OTHER :- "+vother);

    }
}