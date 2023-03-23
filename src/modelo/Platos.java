package modelo;

import java.awt.Image;
import java.io.FileInputStream;

public class Platos {

    private int idProducto;
    private String nombre;
    private double precio;
    private int cantidad;
    private String descripcion,tipo;

    //Guardar foto
    private FileInputStream foto;
    private int longitud;

    //Recuperar imagen
    private Image imagen;

    public Platos() {
    }

    public Platos(int idProducto, String nombre, double precio, int cantidad, String descripcion, String tipo, FileInputStream foto, int longitud, Image imagen) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.foto = foto;
        this.longitud = longitud;
        this.imagen = imagen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FileInputStream getFoto() {
        return foto;
    }

    public void setFoto(FileInputStream foto) {
        this.foto = foto;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
}
