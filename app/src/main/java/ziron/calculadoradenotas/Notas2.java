package ziron.calculadoradenotas;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Notas2 extends AppCompatActivity {

    private double n1, n2, n3, fn;
    private double p1, p2, p3;
    private EditText nota1;
    private EditText nota2;
    private EditText nota3;
    private TextView Final;
    private TextView lblNeed;
    private Resources res;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas2);
        nota1 = (EditText)findViewById(R.id.txtNota1);
        nota2 = (EditText)findViewById(R.id.txtNota2);
        nota3 = (EditText)findViewById(R.id.txtNota3);
        Final = (TextView)findViewById(R.id.lblResFinal);
        lblNeed = (TextView)findViewById(R.id.lblNeed);
        res = this.getResources();
        //Recuperamos la información pasada en el intent
        bundle = this.getIntent().getExtras();
    }public void calcular(View v){
        p1 = Double.parseDouble(bundle.getString("porcentaje1"));
        p2 = Double.parseDouble(bundle.getString("porcentaje2"));
        p3 = Double.parseDouble(bundle.getString("porcentaje3"));

        if (!TextUtils.isEmpty(nota1.getText())) {
            n1 = Double.parseDouble(String.valueOf(nota1.getText()));
        }else{
            Toast.makeText(this, "No ingresó la nota 1. El valor se definirá como 0", Toast.LENGTH_SHORT).show();
            n1 = 0;
        }
        if (!TextUtils.isEmpty(nota2.getText())) {
            n2 = Double.parseDouble(String.valueOf(nota2.getText()));
        }else{
            Toast.makeText(this, "No ingresó la nota 2. El valor se definirá como 0", Toast.LENGTH_SHORT).show();
            n2 = 0;
        }
        if (!TextUtils.isEmpty(nota3.getText())) {
            n3 = Double.parseDouble(String.valueOf(nota3.getText()));
        }else{
            Toast.makeText(this, "No ingresó la nota 3. El valor se definirá como 0", Toast.LENGTH_SHORT).show();
            n3 = 0;
        }
        n1 = (n1 * (p1/100));
        n2 = (n2 * (p2/100));
        n3 = (n3 * (p3/100));
        fn = n1 + n2 + n3;
        double fn2 = fn;
        fn2 = Math.rint(fn*100)/100;
//            DecimalFormat df = new DecimalFormat("#.###");
//            df.format(fn);

        Final.setText(Double.toString(fn2));
        //segunda etapa
        fn = 3 - fn;
        fn = fn/(p3/100);
        double fn3 = fn;
        fn3= Math.rint(fn3*100)/100;
        lblNeed.setText(Double.toString(fn3));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calcmenu2, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {

            case R.id.inicio:
                //metodoSearch()
                Intent intent = new Intent(this, Principal.class);

                //Creamos la información a pasar entre actividades
                // Bundle b = new Bundle();
                //b.putString("nombre", txtNombre.getText().toString());

                //Añadimos la información al intent
                //intent.putExtras(b);

                //Iniciamos la nueva actividad
                startActivity(intent);
                finish();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
