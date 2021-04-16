package com.example.calificado6.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.calificado6.R;
import com.example.calificado6.Utilidades;
import com.example.calificado6.model.Pelicula;
import java.util.ArrayList;
import java.util.List;
public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.PeliculaViewHolder>{
    private OnPeliculaClickListener peliculaClickListener;
    public PeliculaAdapter(ArrayList<Pelicula> dataPeliculas) {
        this.dataPeliculas = dataPeliculas;
    }
    //Interface Publica
    public interface  OnPeliculaClickListener{
        void onClick(int posicion);
    }
    //Creando Lista
    private List<Pelicula> dataPeliculas;
    //Constructor Adapter
    public PeliculaAdapter(List<Pelicula> listaPeliculas,
                           OnPeliculaClickListener peliculaClickListener) {
        this.dataPeliculas = listaPeliculas;
        this.peliculaClickListener=peliculaClickListener;
    }
    //CREAR VIEWHOLDER
    static class PeliculaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgPelicula;
        private TextView txtTitulo;
        private TextView txtPublicado;
        private TextView txtDirector;
        public PeliculaViewHolder(@NonNull View itemView, OnPeliculaClickListener peliculaClickListener) {
            super(itemView);
            imgPelicula=itemView.findViewById(R.id.imgPelicula);
            txtTitulo =itemView.findViewById(R.id.txtTitulo);
            txtPublicado =itemView.findViewById(R.id.txtPublicado);
            txtDirector =itemView.findViewById(R.id.txtDirector);
            //Pocision donde se a echo click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(peliculaClickListener!=null){
                        int posicion= getAdapterPosition();
                        if ((posicion !=RecyclerView.NO_POSITION)){
                            peliculaClickListener.onClick(posicion);
                        }
                    }
                }
            });
        }
        public void bindPelicula(Pelicula pelicula){
            imgPelicula.setImageResource(pelicula.getIdImagen());
            txtTitulo.setText(pelicula.getTitulo());
            txtPublicado.setText(pelicula.getAño());
            txtDirector.setText(pelicula.getDirector());
        }
    }
    @NonNull
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout=0;
        if(Utilidades.visualizacion==Utilidades.LIST){
            layout=R.layout.item_pelicula;
        }
        else{
            layout=R.layout.item_gridp_pelicula;
        }
        View itemPelicula = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        return new PeliculaViewHolder(itemPelicula, peliculaClickListener);
    }
    public void onBindViewHolder(@NonNull PeliculaViewHolder  holder, int position) {
        holder.bindPelicula(dataPeliculas.get(position));
    }
    public int getItemCount() {
        int size = dataPeliculas.size();
        return size;
    }
    public List<Pelicula> getListaPeliculas() {
        return dataPeliculas;
    }
}
