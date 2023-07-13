package hn.uth.proyectopm1;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {
    private List<Producto> productos;
    private List<Producto> carritoProductos = new ArrayList<>();

    public ProductoAdapter() {
        productos = new ArrayList<>();
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
        notifyDataSetChanged();
    }





    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductoViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final Producto producto = productos.get(position);
        holder.nombreTextView.setText(producto.getNombre());
        holder.precioTextView.setText(String.valueOf(producto.getPrecio()));
        holder.descripcionTextView.setText(producto.getDescripcion());
        Picasso.get().load(producto.getFotoUrl()).into(holder.fotoImageView);



    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class ProductoViewHolder extends RecyclerView.ViewHolder {
        public TextView nombreTextView;
        public TextView precioTextView;
        public TextView descripcionTextView;
        public ImageView fotoImageView;
        public ImageButton btnAgregarCarrito;

        public Button btnIrAlCarrito;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            precioTextView = itemView.findViewById(R.id.precioTextView);
            descripcionTextView = itemView.findViewById(R.id.descripcionTextView);
            fotoImageView = itemView.findViewById(R.id.fotoImageView);
            btnAgregarCarrito = itemView.findViewById(R.id.btnAgregarCarrito);
        }
    }
}
