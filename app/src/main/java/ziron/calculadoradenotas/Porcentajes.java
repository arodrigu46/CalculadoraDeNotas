package ziron.calculadoradenotas;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Porcentajes extends AppCompatActivity {
    private EditText txtPorcentaje1;
    private EditText txtPorcentaje2;
    private EditText txtPorcentaje3;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porcentajes);
        txtPorcentaje1 = (EditText)findViewById(R.id.txtPorcentaje1);
        txtPorcentaje2 = (EditText)findViewById(R.id.txtPorcentaje2);
        txtPorcentaje3 = (EditText)findViewById(R.id.txtPorcentaje3);
        res = this.getResources();
    }

    public void Porcentajes(View v){
        int psum1, psum2, psum3;
        if (!TextUtils.isEmpty(txtPorcentaje1.getText().toString())) {
            psum1 = Integer.parseInt(txtPorcentaje1.getText().toString());
        }else{
            Toast.makeText(this, res.getString(R.string.error005), Toast.LENGTH_SHORT).show();
            psum1 = 0;
        }
        if (!TextUtils.isEmpty(txtPorcentaje2.getText().toString())) {
            psum2 = Integer.parseInt(txtPorcentaje2.getText().toString());
        }else{
            Toast.makeText(this, res.getString(R.string.error006), Toast.LENGTH_SHORT).show();
            psum2=0;
        }
        if (!TextUtils.isEmpty(txtPorcentaje3.getText().toString())) {
            psum3 = Integer.parseInt(txtPorcentaje3.getText().toString());
        }else{
            Toast.makeText(this, res.getString(R.string.error007), Toast.LENGTH_SHORT).show();

            psum3=0;
        }



        if ((psum1+psum2+psum3)==100) {
            Intent intent2 = new Intent(this, Notas2.class);

            //Creamos la información a pasar entre actividades
            Bundle p1 = new Bundle();
            Bundle p2 = new Bundle();
            Bundle p3 = new Bundle();
            p1.putString("porcentaje1", txtPorcentaje1.getText().toString());
            p2.putString("porcentaje2", txtPorcentaje2.getText().toString());
            p3.putString("porcentaje3", txtPorcentaje3.getText().toString());

            //Añadimos la información al intent
            intent2.putExtras(p1);
            intent2.putExtras(p2);
            intent2.putExtras(p3);

            //Iniciamos la nueva actividad
            startActivity(intent2);
        }else{
            Toast.makeText(this, res.getString(R.string.error008), Toast.LENGTH_SHORT).show();

        }
    }
}
