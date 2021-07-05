/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Producto;
import java.sql.*;
import java.util.List;
import static datos.Conexion.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Acmm
 */
public class ProductosDao  {
    
    private static final String SQL_SELECT = "SELECT * FROM clothesbook.productos ";
    
    public List<Producto> seleccionar(){
        Connection con = null;
        PreparedStatement stt = null;
        ResultSet rs = null;
        List<Producto> productos = new ArrayList<>();
        Producto producto;

        try {
            con = getConexion();
            stt = con.prepareStatement(SQL_SELECT);
            rs = stt.executeQuery();
            while (rs.next()) {
                int idProducto = rs.getInt("id_producto");
                String tipo = rs.getString("tipo");
                String talla = rs.getString("talla");
                String color = rs.getString("color");
                String marca = rs.getString("marca");
                int precio = rs.getInt("precio");
                int cantidad = rs.getInt("cantidad");
                producto = new Producto(idProducto, tipo, talla, color, marca, precio, cantidad);
                productos.add(producto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro coincidencia con los datos de la busqueda en la base de datos");
        } finally {
            try {
                close(rs);
                close(stt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return productos;
    }
}
