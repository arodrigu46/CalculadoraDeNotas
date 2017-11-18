package ziron.calculadoradenotas;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by arodrigu46 on 18/11/2017.
 */

public class Metodos {
    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return fotos.get(fotoSeleccionada);
    }

    public static boolean validar_aux(TextView t, String mensaje){
        if(t.getText().toString().isEmpty()){
            t.requestFocus();
            t.setError(mensaje);
            return true;
        }
        return  false;
    }

    public static boolean existencia_tarea(ArrayList<Tarea> tareas,
                                             String nombre){
        for (int i = 0; i < tareas.size(); i++) {
            if(tareas.get(i).getNombre().equals(nombre)) return true;
        }
        return false;
    }
}
