package ziron.calculadoradenotas;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by arodrigu46 on 18/11/2017.
 */

public class Datos {
    private static DatabaseReference databaseReference = FirebaseDatabase.
            getInstance().getReference();
    private static String bd ="Tareas";
    private static ArrayList<Tarea> tareas = new ArrayList<>();

    public static void guardarTarea(Tarea p){

        databaseReference.child(bd).child(p.getId()).setValue(p);
    }

    public static ArrayList<Tarea> obtenerPersonas(){
        return tareas;
    }

    public static void setPersonas(ArrayList<Tarea> per){
        tareas=per;
    }

    public static String getId(){
        return databaseReference.push().getKey();
    }

    public static void actualizar(Tarea p ){
        databaseReference.child(bd).child(p.getId()).setValue(p);
    }
    public static void eliminar(Tarea p){
        databaseReference.child(bd).child(p.getId()).removeValue();
    }
}
