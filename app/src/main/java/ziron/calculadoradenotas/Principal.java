package ziron.calculadoradenotas;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Principal extends AppCompatActivity {
    private ListView lv;
    private Resources resources;
    private String opc[];
    private Intent in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lv = (ListView) findViewById(R.id.lsOpciones);
        resources=this.getResources();
        opc = resources.getStringArray(R.array.OpcionesPrincipal);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        in = new Intent(Principal.this,Notas.class);
                        startActivity(in);
                        break;
                    case 1:
                        in = new Intent(Principal.this,Promedio.class);
                        startActivity(in);
                        break;
                    case 2:
                        in = new Intent(Principal.this,Principal.class);
                        startActivity(in);
                        break;
                    case 3:
                        in = new Intent(Principal.this,Nivel.class);
                        startActivity(in);
                        break;
                    case 4:
                        in = new Intent(Principal.this,ImgUpload.class);
                        startActivity(in);
                        break;
                    case 5:
                        in = new Intent(Principal.this,IntroTareas.class);
                        startActivity(in);
                        break;
                    case 6:
                        in = new Intent(Principal.this,Chat.class);
                        startActivity(in);
                        break;
                }
            }
        });
    }

}
