package hn.uth.proyectopm1;

import android.os.Parcel;
import android.os.Parcelable;

public class Producto implements Parcelable {
    private String nombre;
    private String precio;
    private String descripcion;
    private String fotoUrl;

    public Producto() {
    }

    public Producto(String nombre, String precio, String descripcion, String fotoUrl) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.fotoUrl = fotoUrl;
    }

    protected Producto(Parcel in) {
        nombre = in.readString();
        precio = in.readString();
        descripcion = in.readString();
        fotoUrl = in.readString();
    }

    public static final Creator<Producto> CREATOR = new Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel in) {
            return new Producto(in);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(precio);
        dest.writeString(descripcion);
        dest.writeString(fotoUrl);
    }
}
