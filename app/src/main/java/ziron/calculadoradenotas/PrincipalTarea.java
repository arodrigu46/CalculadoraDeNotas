package ziron.calculadoradenotas;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PrincipalTarea extends AppCompatActivity implements AdaptadorTarea.OnTareaClickListener {
    private RecyclerView listado;
    private ArrayList<Tarea> tareas;
    private Resources res;
    private AdaptadorTarea adapter;
    private LinearLayoutManager llm;
    private DatabaseReference databaseReference;
    private final String BD="Tareas";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_tarea);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listado = (RecyclerView)findViewById(R.id.lstTareas);
        res = this.getResources();

        tareas = new ArrayList<>();
        adapter = new AdaptadorTarea(this.getApplicationContext(),tareas,this);
        llm = new LinearLayoutManager(this);
        listado.setLayoutManager(llm);
        listado.setAdapter(adapter);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child(BD).addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {
                tareas.clear();
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Tarea p= snapshot.getValue(Tarea.class);
                        tareas.add(p);
                    }
                }
                adapter.notifyDataSetChanged();
                Datos.setPersonas(tareas);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void agregar(View v){
        Intent i = new Intent(PrincipalTarea.this,CrearTarea.class);
        startActivity(i);

    }

    @Override
    public void onTareaClick(Tarea p) {
        Intent i = new Intent(PrincipalTarea.this,Principal.class);
        Bundle b = new Bundle();
        b.putString("id",p.getId());
        b.putString("nombre",p.getNombre());
        b.putString("FechaEntrega",p.getFechaEntrega());
        b.putString("foto",p.getFoto());

        i.putExtra("datos",b);
        startActivity(i);

    }

}
