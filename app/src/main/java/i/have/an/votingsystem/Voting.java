package i.have.an.votingsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Voting extends AppCompatActivity {

    int vother=0,vaap=0,vaimim=0,vinc=0,vbjp=0;

    Switch saap,sbjp,saimim,sinc,sother;
    Button smt;

    AlertDialog.Builder Builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_voting);

        saap = findViewById(R.id.sapp);
        sbjp = findViewById(R.id.sbjp);
        saimim = findViewById(R.id.saimim);
        sinc = findViewById(R.id.sinc);
        sother = findViewById(R.id.sother);
        smt = findViewById(R.id.smt);

        Builder = new AlertDialog.Builder(this);

        saap.setOnCheckedChangeListener((cb, on) -> {
            if(on)
            {
                sbjp.setChecked(false);
                saimim.setChecked(false);
                sinc.setChecked(false);
                sother.setChecked(false);
            }
        });

        saimim.setOnCheckedChangeListener((cb, on) -> {
        if(on)
        {
            sbjp.setChecked(false);
            saap.setChecked(false);
            sinc.setChecked(false);
            sother.setChecked(false);
        }
    });

        sinc.setOnCheckedChangeListener((cb, on) -> {
        if(on)
        {
            sbjp.setChecked(false);
            saimim.setChecked(false);
            saap.setChecked(false);
            sother.setChecked(false);
        }
    });

        sbjp.setOnCheckedChangeListener((cb, on) -> {
        if(on)
        {
            saap.setChecked(false);
            saimim.setChecked(false);
            sinc.setChecked(false);
            sother.setChecked(false);
        }
    });

       sother.setOnCheckedChangeListener((cb, on) -> {
        if(on)
        {
            sbjp.setChecked(false);
            saimim.setChecked(false);
            sinc.setChecked(false);
            saap.setChecked(false);
        }
    });

        smt.setOnClickListener(view -> {
            if(sother.isChecked()){
                vother++;
            }else if(saap.isChecked()){
                vaap++;
            }else if(sbjp.isChecked()){
                vbjp++;
            }else if(saimim.isChecked()){
                vaimim++;
            }else if(sinc.isChecked()){
                vinc++;
            }else{
                Toast.makeText(this,"Please Select A Party First!!",Toast.LENGTH_SHORT).show();

            }

            Builder.setMessage("show result or continue?")
                    .setCancelable(false)

                    .setPositiveButton("Result", (dialog, id) -> {
                        Intent i = new Intent(this,Result.class);
                        i.putExtra("vaap",vaap);
                        i.putExtra("vbjp",vbjp);
                        i.putExtra("vaimim",vaimim);
                        i.putExtra("vinc",vinc);
                        i.putExtra("vother",vother);
                        startActivity(i);


                    }).setNegativeButton("Continue", (dialog, id) -> {

                        sbjp.setChecked(false);
                        sother.setChecked(false);
                        saimim.setChecked(false);
                        sinc.setChecked(false);
                        saap.setChecked(false);
                    });

            AlertDialog alert = Builder.create();

            alert.setTitle("Vote Submitted!");
            alert.show();

        });


    }
}