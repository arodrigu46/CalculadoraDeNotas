package ziron.calculadoradenotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Button btnPromedioSemestre = (Button) findViewById(R.id.btnPromSem);
        Button btnCalculoNotas  = (Button) findViewById(R.id.btnClcNotas);
    }

    public void calculoDeNotasStart(View v){
        Intent i = new Intent(Principal.this,Notas.class);
        startActivity(i);
    }
    public void promedioSemestreStart(View v){
        Intent i = new Intent(Principal.this,Notas.class);
        startActivity(i);
    }
}
