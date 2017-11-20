package ziron.calculadoradenotas;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class IntroTareas extends AppCompatActivity {
    private Button btnOk;
    private CheckBox check1;
    private CheckBox check2;
    private Intent in;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_tareas);
        btnOk = (Button)findViewById(R.id.btnOk);
        check1 = (CheckBox)findViewById(R.id.checkBox);
        check2 = (CheckBox)findViewById(R.id.checkBox2);
        res = this.getResources();
    }
    public void ok(View v){
        if(check1.isChecked() && check2.isChecked()){
            Toast.makeText(this, res.getString(R.string.error15), Toast.LENGTH_SHORT).show();
        }else{
            if(check1.isChecked()){
                in = new Intent(this,PrincipalTarea.class);
                startActivity(in);
            }else{
                if(check2.isChecked()){
                    finish();
                }else{
                    Toast.makeText(this, res.getString(R.string.error15), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
