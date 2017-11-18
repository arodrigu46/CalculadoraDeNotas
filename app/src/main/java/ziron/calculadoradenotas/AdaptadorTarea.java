package ziron.calculadoradenotas;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

/**
 * Created by arodrigu46 on 18/11/2017.
 */

public class AdaptadorTarea extends RecyclerView.Adapter<AdaptadorTarea.TareaViewHolder> {
    private ArrayList<Tarea> tareas;
    private Resources res;
    private Context contexto;
    private OnTareaClickListener clickListener;


    public AdaptadorTarea(Context contexto, ArrayList<Tarea> tareas,
                            OnTareaClickListener clickListener){
        this.tareas=tareas;
        this.res=contexto.getResources();
        this.contexto=contexto;
        this.clickListener=clickListener;
    }


    @Override
    public TareaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tarea,parent,false);
        return new TareaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final TareaViewHolder holder, int position) {
        final Tarea p = tareas.get(position);

        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        storageReference.child(p.getFoto()).getDownloadUrl()
                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.with(contexto).load(uri).into(holder.foto);
                    }
                });

        holder.nombre.setText(p.getNombre());
        holder.fechaEntrega.setText(p.getFechaEntrega());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onTareaClick(p);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tareas.size();
    }

    public static class TareaViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView nombre;
        private TextView fechaEntrega;


        public TareaViewHolder(View item){
            super(item);

            foto = (ImageView)item.findViewById(R.id.imgFoto);
            nombre = (TextView) item.findViewById(R.id.lblNombre);
            fechaEntrega = (TextView) item.findViewById(R.id.lblFechaEntrega);
        }

    }

    public interface OnTareaClickListener{
        void onTareaClick(Tarea p);
    }
}
