package com.example.calificado6.fragmentos;
//import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import com.example.calificado6.R;
import com.example.calificado6.Utilidades;
import com.example.calificado6.adapter.PeliculaAdapter;
import com.example.calificado6.model.Pelicula;
import java.util.ArrayList;
public class ListaFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private RecyclerView rcvPeliculas;
    ArrayList<Pelicula> dataPeliculas;
    public ListaFragment() { }
    public static ListaFragment newInstance(String param1, String param2) {
        ListaFragment fragment = new ListaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Utilidades.visualizacion=Utilidades.LIST;
        View view = inflater.inflate(R.layout.fragment_lista, container, false);
        dataPeliculas=new ArrayList<>();
        rcvPeliculas =view.findViewById(R.id.rcvPeliculas);

        PeliculaAdapter.OnPeliculaClickListener peliculaClickListener = new PeliculaAdapter.OnPeliculaClickListener() {
            @Override
            public void onClick(int posicion) {
                PeliculaAdapter peliculaAdapter = (PeliculaAdapter) rcvPeliculas.getAdapter();
                Pelicula pelicula = peliculaAdapter.getListaPeliculas().get(posicion);
                new DialogFragment().show(getFragmentManager(),"DialogFragment");
                 }
        };
        rcvPeliculas.setLayoutManager(new LinearLayoutManager(getContext()));

        obtenerDataPeliculas();
        PeliculaAdapter adapter=new PeliculaAdapter(dataPeliculas, peliculaClickListener);
        rcvPeliculas.setAdapter(adapter);
        return view;

    }
    public void obtenerDataPeliculas() {

        dataPeliculas.add(new Pelicula("Proyecto Power","2020", "Henry Joost y Ariel Schulman", R.drawable.proyecto_power,R.string.power));
        dataPeliculas.add(new Pelicula("Triple Amenaza","2019", "Jesse V. Johnson", R.drawable.triple_ame,R.string.triple));
        dataPeliculas.add(new Pelicula("Aves De Presa","2020", "Cathy Yan", R.drawable.aves_de_presa,R.string.aves_de_presa));
        dataPeliculas.add(new Pelicula("Bad Boys para siempre","2020", "Adil El Arbi y Bilall Fallah", R.drawable.bad_boys,R.string.bad));
        dataPeliculas.add(new Pelicula("Bloodshot","2020", "Dave Wilson", R.drawable.bloodshot,R.string.blood));
        dataPeliculas.add(new Pelicula("Greyhound: En la mira del enemigo","2020", "Aaron Schneider", R.drawable.greyhound,R.string.grey));
        dataPeliculas.add(new Pelicula("Inside Man: Most Wanted","2019", "M.J. Bassett", R.drawable.inside_man,R.string.inside));
        dataPeliculas.add(new Pelicula("Proyecto Géminis","2019", "Ang Lee", R.drawable.proyecto_geminis,R.string.geminis));
        dataPeliculas.add(new Pelicula("La vieja guardia","2020", "Gina Prince-Bythewood", R.drawable.la_vieja,R.string.la_vieja));
        dataPeliculas.add(new Pelicula("Terminator: Destino oculto","2019", "Tim Miller", R.drawable.terminator,R.string.termi));
        dataPeliculas.add(new Pelicula("Balas de venganza","2019", "Daniel Zirilli", R.drawable.balas,R.string.bala));
        dataPeliculas.add(new Pelicula("Triple Frontera","2019", "J.C. Chandor", R.drawable.triple_frontera,R.string.frontera));
    }
    private void layoutAnimation(RecyclerView recyclerView){
        Context context= recyclerView.getContext();
        LayoutAnimationController layoutAnimationController= AnimationUtils.loadLayoutAnimation(context,R.anim.layout_animation);
        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}