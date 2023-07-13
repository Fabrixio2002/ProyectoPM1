package hn.uth.proyectopm1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarritoAdapter extends RecyclerView.Adapter<CarritoAdapter.ViewHolder> {

    private List<Producto> productos;

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrito, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Producto producto = productos.get(position);
        holder.txtNombre.setText(producto.getNombre());
        holder.txtPrecio.setText(producto.getPrecio());
        // Configurar otros atributos según tus necesidades
    }

    @Override
    public int getItemCount() {
        return productos != null ? productos.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre;
        TextView txtPrecio;
        // Agrega otros elementos de interfaz de usuario según tus necesidades

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);
            // Inicializar otros elementos de interfaz de usuario según tus necesidades
        }
    }
}
