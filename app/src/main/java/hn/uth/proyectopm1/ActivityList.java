package hn.uth.proyectopm1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ActivityList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductoAdapter productoAdapter;
    private DatabaseReference productosRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productoAdapter = new ProductoAdapter();
        recyclerView.setAdapter(productoAdapter);
        productosRef = FirebaseDatabase.getInstance().getReference().child("productos");

        productosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Producto> productos = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String nombre = snapshot.child("nombre").getValue(String.class);
                    String precio = snapshot.child("precio").getValue(String.class);
                    String descripcion = snapshot.child("descripcion").getValue(String.class);
                    String fotoUrl = snapshot.child("fotoUrl").getValue(String.class);

                    Producto producto = new Producto(nombre, precio, descripcion, fotoUrl);
                    productos.add(producto);
                }

                productoAdapter.setProductos(productos);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Maneja el error en caso de que ocurra
            }
        });





    }




}

