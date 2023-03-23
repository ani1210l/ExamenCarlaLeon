package modelo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;

public class ModeloPlatos extends Platos {

    ConectPG conpg = new ConectPG();

    public ModeloPlatos() {
    }

    public ModeloPlatos(int idProducto, String nombre, double precio, int cantidad, String descripcion, String tipo, FileInputStream foto, int longitud, Image imagen) {
        super(idProducto, nombre, precio, cantidad, descripcion, tipo, foto, longitud, imagen);
    }

    public boolean crearProductoSinFoto() {

        String sql = "INSERT INTO producto(nombre, precio, cantidad, descripcion, foto,tipo) VALUES ('" + getNombre() + "', " + getPrecio() + ", " + getCantidad() + ", '" + getDescripcion() + "','null','" + getTipo() + "');";

        return conpg.accion(sql);
    }

    public boolean crearProductoFoto() {
        try {
            String sql;

            sql = "INSERT INTO producto (nombre, precio, cantidad, descripcion, foto,tipo)";
            sql += "VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = conpg.getCon().prepareStatement(sql);
            ps.setString(1, getNombre());
            ps.setDouble(2, getPrecio());
            ps.setInt(3, getCantidad());
            ps.setString(4, getDescripcion());
            ps.setBinaryStream(5, getFoto(), getLongitud());
            ps.setString(6, getTipo());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPlatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean modificarProductoSinFoto() { //modificar la instancia en la BD

        String sql = "UPDATE producto SET nombre='" + getNombre() + "', precio=" + getPrecio() + ",  cantidad=" + getCantidad() + ", descripcion='" + getDescripcion() + "'";

        return conpg.accion(sql);
    }

    public boolean modificarPersonaFoto() {
        try {
            String sql;

            sql = "UPDATE producto SET nombre=?,precio=?,cantidad=?,descripcion=?,foto=? Where idproducto=?";
            PreparedStatement ps = conpg.getCon().prepareStatement(sql);
            ps.setString(1, getNombre());
            ps.setDouble(2, getPrecio());
            ps.setInt(3, getCantidad());
            ps.setString(4, getDescripcion());
            ps.setBinaryStream(5, getFoto(), getLongitud());
            ps.setInt(6, getIdProducto());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPlatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean eliminarProducto(int codigo) {

        String sql = "DELETE FROM producto WHERE idproducto = " + codigo + ";";

        return conpg.accion(sql);
    }

    public List<Platos> buscarProducto(String nombre) {
        try {
            //Me retorna un "List" de "persona"
            List<Platos> lista = new ArrayList<>();

            String sql = "Select * from producto where nombre like '" + nombre + "%'";

            //ConectPG conpg = new ConectPG();
            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"
            byte[] bytea;

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Platos producto = new Platos();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                producto.setIdProducto(rs.getInt("idproducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setDescripcion(rs.getString("descripcion"));
                bytea = rs.getBytes("foto");

                if (bytea != null) {

                    try {
                        producto.setImagen(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloPlatos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                lista.add(producto); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloPlatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Platos> listaProductosTabla() {
        try {
            //Me retorna un "List" de "persona"
            List<Platos> lista = new ArrayList<>();

            String sql = "select * from producto";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"
            byte[] bytea;

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Platos producto = new Platos();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                producto.setIdProducto(rs.getInt("idproducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setDescripcion(rs.getString("descripcion"));
                bytea = rs.getBytes("foto");

                if (bytea != null) {

                    try {
                        producto.setImagen(obtenerImagen(bytea));
                    } catch (IOException ex) {
                        Logger.getLogger(ModeloPlatos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                lista.add(producto); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloPlatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Platos> listaProductoJDialog() {
        try {
            //Me retorna un "List" de "persona"
            List<Platos> lista = new ArrayList<>();

            String sql = "select idproducto,nombre, precio, cantidad, descripcion from producto";

            ResultSet rs = conpg.consulta(sql); //La consulta nos devuelve un "ResultSet"

            //Pasar de "ResultSet" a "List"
            while (rs.next()) {
                //Crear las instancias de las personas
                Platos producto = new Platos();

                //Todo lo que haga en la sentencia define como voy a extraer los datos
                producto.setIdProducto(rs.getInt("idproducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setDescripcion(rs.getString("descripcion"));

                lista.add(producto); //Agrego los datos a la lista
            }

            //Cierro la conexion a la BD
            rs.close();
            //Retorno la lista
            return lista;

        } catch (SQLException ex) {
            Logger.getLogger(ModeloPlatos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private Image obtenerImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) it.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return reader.read(0, param);
    }

    public ImageIcon ConsultarFotoJDialog(int codigo) {
        conpg.getCon();
        String sql = "select foto from \"producto\" where idproducto = " + codigo + ";";
        ImageIcon foto;
        InputStream is;

        try {
            ResultSet rs = conpg.consulta(sql);
            while (rs.next()) {

                is = rs.getBinaryStream(1);

                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);

                Image img = foto.getImage();
                Image newimg = img.getScaledInstance(118, 139, java.awt.Image.SCALE_SMOOTH);

                ImageIcon newicon = new ImageIcon(newimg);

                return newicon;
            }
        } catch (Exception ex) {

            return null;
        }

        return null;
    }
}
