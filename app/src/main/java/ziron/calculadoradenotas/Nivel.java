package ziron.calculadoradenotas;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Nivel extends AppCompatActivity {
    private EditText txtPlan;
    private EditText txtAprob;
    private Button btnCalcular;
    private TextView lblNivel;
    private Spinner spCreditMatri;
    private String CreditMatri[];
    private Spinner spNiveles;
    private String Niveles[];
    private Resources resources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel);
        txtPlan = (EditText)findViewById(R.id.txtPlan);
        txtAprob = (EditText)findViewById(R.id.txtAprob);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        lblNivel = (TextView)findViewById(R.id.lblNivel);
        resources  = this.getResources();
        spCreditMatri = (Spinner)findViewById(R.id.spCreditMatri);
        CreditMatri = resources.getStringArray(R.array.CreditMatri);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CreditMatri);
        spCreditMatri.setAdapter(adapter);

        spNiveles = (Spinner)findViewById(R.id.spNiveles);
        Niveles = resources.getStringArray(R.array.Niveles);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Niveles);
        spNiveles.setAdapter(adapter2);


    }
    public void calcularNivel(View v){
        if (!TextUtils.isEmpty(txtAprob.getText().toString())&& !TextUtils.isEmpty(txtPlan.getText().toString())) {
            Double b13 = Double.parseDouble(txtAprob.getText().toString());
            Double b15 = Double.parseDouble(spCreditMatri.getSelectedItem().toString());
            Double b11 = Double.parseDouble(txtPlan.getText().toString());
            Double b17 = Double.parseDouble(spNiveles.getSelectedItem().toString());
            Double resultado;

            resultado = (((b13+b15)/b11)*b17);
            lblNivel.setText(String.valueOf(resultado));
        }else{
            Toast.makeText(this, resources.getString(R.string.error004), Toast.LENGTH_SHORT).show();
        }

    }
}
