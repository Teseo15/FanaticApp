package com.example.calificado6.activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.calificado6.R;
import com.example.calificado6.fragmentos.GrillaFragment;
import com.example.calificado6.fragmentos.ListaFragment;
import com.example.calificado6.fragmentos.TemaFragment;
import com.google.android.material.button.MaterialButton;
public class MainActivity extends AppCompatActivity {
    private MaterialButton btntema;
    private MaterialButton btnlista;
    private MaterialButton btntgrilla;
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btntema=findViewById(R.id.btnTema);
        btnlista=findViewById(R.id.btnLista);
        btntgrilla=findViewById(R.id.btnGrilla);
        frameLayout=findViewById(R.id.frmContenedorFragment);
        btntema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                TemaFragment temaFragment = new TemaFragment();
                fragmentTransaction.replace(R.id.frmContenedorFragment,temaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btnlista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ListaFragment listaFragment = new ListaFragment();
                fragmentTransaction.replace(R.id.frmContenedorFragment, listaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        btntgrilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                GrillaFragment grillaFragment = new GrillaFragment ();

                fragmentTransaction.replace(R.id.frmContenedorFragment, grillaFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}