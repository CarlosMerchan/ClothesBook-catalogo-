/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import domain.Pantalon;
import domain.Zapato;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PantalonDaoJdbc implements PantalonDao {
    
    private static final String SQL_SELECT = "SELECT * FROM clothesbook.productos WHERE tipo ='jean' OR tipo ='sudadera' OR tipo='dril'"; 
    private static final String SQL_INSERT = "INSERT INTO clothesbook.productos(tipo,talla,color,marca,precio,cantidad) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE clothesbook.productos SET tipo = ?,talla = ?, color = ? , marca = ? , precio = ? , cantidad = ? WHERE id_producto = ?";
    private static final String SQL_DELETE = "DELETE FROM clothesbook.productos WHERE id_persona = ?";
    private static final String SQL_ADVANCED ="SELECT * FROM clothesbook.productos WHERE tipo = ? AND talla = ? AND color =?";

    @Override
    public List<Pantalon> seleccionar() {
        Connection con = null;
        PreparedStatement stt = null;
        ResultSet rs = null;
        List<Pantalon> pantalones = new ArrayList<>();
        Pantalon pantalon;

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
                pantalon = new Pantalon(idProducto, tipo, talla, color, marca, precio, cantidad);
                pantalones.add(pantalon);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return pantalones;
    }

    @Override
    public int actulizar(Pantalon pantalon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Pantalon pantalon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(Pantalon pantalon) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pantalon> busquedaAvanzada(Pantalon pantalon) {
        Connection con = null;
        PreparedStatement stt = null;
        ResultSet rs = null;
        List<Pantalon> pantalones = new ArrayList<>();
        Pantalon pantalonBusqueda;
        

        try {
            con = getConexion();
            stt = con.prepareStatement(SQL_ADVANCED);
            
            stt.setString(1, pantalon.getTipo());
            stt.setString(2, pantalon.getTalla());
            stt.setString(3, pantalon.getColor());            
            rs = stt.executeQuery();
            while(rs.next()){
                int idProducto = rs.getInt("id_producto");
                String tipo = rs.getString("tipo");
                String talla = rs.getString("talla");
                String color = rs.getString("color");
                String marca = rs.getString("marca");
                int precio = rs.getInt("precio");
                int cantidad = rs.getInt("cantidad");
                pantalonBusqueda = new Pantalon(idProducto, tipo, talla, color, marca, precio, cantidad);
                pantalones.add(pantalonBusqueda);
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

        return pantalones;
    }
    
}
