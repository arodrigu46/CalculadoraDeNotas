package ziron.calculadoradenotas;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Promedio extends AppCompatActivity {
    private double creditosTotal;
    private double notasTotal;
    private EditText txtMateria;
    private EditText txtCreditos;
    private EditText txtNota;
    private ListView lv;
    private TextView lblPromedio;
    final List<String> myItems = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promedio);
        txtMateria = (EditText)findViewById(R.id.txtMateria);
        txtCreditos = (EditText)findViewById(R.id.txtCreditos);
        txtNota = (EditText)findViewById(R.id.txtNota);
        lblPromedio = (TextView)findViewById(R.id.lblPromedio);
        lv = (ListView) findViewById(R.id.lsMaterias);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myItems);
        lv.setAdapter(adapter);
    }
    public void limpiar(View v){
        lblPromedio.setText("");
        Toast.makeText(this, "reiniciado", Toast.LENGTH_SHORT).show();
        myItems.clear();
    }
    public void agregar(View v){
        int detector = 0;
        switch (v.getId()) {
            case R.id.btnAñadir:
                if (!TextUtils.isEmpty(txtMateria.getText())) {

                    if (!TextUtils.isEmpty(txtCreditos.getText())) {

                        if (!TextUtils.isEmpty(txtNota.getText())) {
                            detector = 1;
                        }else{
                            Toast.makeText(this, "Ingrese la nota", Toast.LENGTH_SHORT).show();
                            detector = -1;
                        }
                    }else{
                        Toast.makeText(this, "Ingrese el número de créditos", Toast.LENGTH_SHORT).show();
                        detector = -1;
                    }
                }else{
                    Toast.makeText(this, "Ingrese el nombre de la materia", Toast.LENGTH_SHORT).show();
                    detector = -1;
                }


                if (detector==1) {
                    double nota = Double.parseDouble(txtNota.getText().toString());
                    int creditos = Integer.parseInt(txtCreditos.getText().toString());
                    double notaMultiplicada;
                    double promedioTotal;
                    creditosTotal += Integer.parseInt(txtCreditos.getText().toString());

                    notaMultiplicada = nota * creditos;

                    notasTotal += notaMultiplicada;

                    promedioTotal = notasTotal / creditosTotal;
                    promedioTotal = Math.rint(promedioTotal * 100) / 100;
                    lblPromedio.setText(String.valueOf(promedioTotal));
                    String elemento = txtMateria.getText().toString() + "----" + " creditos: " + txtCreditos.getText().toString() + " nota: " + txtNota.getText().toString();
                    myItems.add(elemento);

                    break;
                }else{
                    Toast.makeText(this, "Ingrese los datos correctamente", Toast.LENGTH_SHORT).show();
                    detector = 0;
                }
        }
        txtMateria.setText("");
        txtCreditos.setText("");
        txtNota.setText("");

    }
}
