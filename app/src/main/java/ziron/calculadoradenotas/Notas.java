package ziron.calculadoradenotas;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Notas extends AppCompatActivity {
    private double n1, n2, n3, fn;
    private double p1, p2, p3;

    private EditText txtNota1;
    private EditText txtNota2;
    private EditText txtNota3;
    private TextView lblResFinal;
    private TextView lblNeed;
    private Resources res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        txtNota1 = (EditText)findViewById(R.id.txtNota1);
        txtNota2 = (EditText)findViewById(R.id.txtNota2);
        txtNota3 = (EditText)findViewById(R.id.txtNota3);
        lblResFinal = (TextView)findViewById(R.id.lblResFinal);
        lblNeed = (TextView)findViewById(R.id.lblNeed);
        res = this.getResources();


    }
    public void calcular(View v){
        p1 = 30;
        p2 = 30;
        p3 = 40;

        if (!esVacio(txtNota1.getText().toString())) {
            n1 = Double.parseDouble(String.valueOf(txtNota1.getText()));
        }else{
            Toast.makeText(this, res.getString(R.string.error001), Toast.LENGTH_SHORT).show();
            n1 = 0;
        }
        if (!TextUtils.isEmpty(txtNota2.getText())) {
            n2 = Double.parseDouble(String.valueOf(txtNota2.getText()));
        }else{
            Toast.makeText(this, res.getString(R.string.error002), Toast.LENGTH_SHORT).show();
            n2 = 0;
        }
        if (!TextUtils.isEmpty(txtNota3.getText())) {
            n3 = Double.parseDouble(String.valueOf(txtNota3.getText()));
        }else{
            Toast.makeText(this, res.getString(R.string.error003), Toast.LENGTH_SHORT).show();
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

        lblResFinal.setText(Double.toString(fn2));
        //segunda etapa
        fn = 3 - fn;
        fn = fn/(p3/100);
        double fn3 = fn;
        fn3= Math.rint(fn3*100)/100;
        lblNeed.setText(Double.toString(fn3));
    }
    private boolean esVacio(String t1){
        if (TextUtils.isEmpty(t1)) return true;
        else return false;
    }
}
