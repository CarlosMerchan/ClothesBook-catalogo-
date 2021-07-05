package datos;

import static datos.Conexion.*;
import domain.Zapato;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ZapatosDaoJdbc implements ZapatoDao {

    private static final String SQL_SELECT = "SELECT * FROM clothesbook.productos WHERE tipo ='mocasin' OR tipo ='tenis' OR tipo='bota'"; 
    private static final String SQL_INSERT = "INSERT INTO clothesbook.productos(tipo,talla,color,marca,precio,cantidad) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE clothesbook.productos SET tipo = ?,talla = ?, color = ? , marca = ? , precio = ? , cantidad = ? WHERE id_producto = ?";
    private static final String SQL_DELETE = "DELETE FROM clothesbook.productos WHERE id_persona = ?";
    private static final String SQL_ADVANCED ="SELECT * FROM clothesbook.productos WHERE tipo = ? AND talla = ? AND color =?";

    @Override
    public List<Zapato> seleccionar() {
        Connection con = null;
        PreparedStatement stt = null;
        ResultSet rs = null;
        List<Zapato> zapatos = new ArrayList<>();
        Zapato zapato;

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
                zapato = new Zapato(idProducto, tipo, talla, color, marca, precio, cantidad);
                zapatos.add(zapato);
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

        return zapatos;
    }
    
    
    @Override
    public int actulizar(Zapato zapato){
        int registro = 0;
        Connection con = null;
        PreparedStatement stt = null;
        
        try {
            con = getConexion();
            stt = con.prepareStatement(SQL_UPDATE);
            stt.setString(1, zapato.getTipo());
        } catch (SQLException ex) {
            Logger.getLogger(ZapatosDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return registro;
    }

    @Override
    public int eliminar(Zapato zapato) {
        int registro = 0;
        Connection con = null;
        PreparedStatement stt = null;

        try {
            con = getConexion();
            stt = con.prepareStatement(SQL_DELETE);
            registro = stt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registro;

    }

    

    @Override
    public int insertar(Zapato zapato) {
        int registro = 0;
        Connection con = null;
        PreparedStatement stt = null;
        
        try {
            con = getConexion();
            stt = con.prepareStatement(SQL_INSERT);
            stt.setString(1, zapato.getTipo());
            stt.setString(2, zapato.getTalla());
            stt.setString(3, zapato.getColor());
            stt.setString(4, zapato.getMarca());
            stt.setInt(5, zapato.getPrecio());
            stt.setInt(6, zapato.getCantidad());
            stt.setInt(7, zapato.getIdProducto());
            registro = stt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                close(stt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registro;
    }

    @Override
    public List<Zapato> busquedaAvanzada(Zapato zapato) {
        Connection con = null;
        PreparedStatement stt = null;
        ResultSet rs = null;
        List<Zapato> zapatos = new ArrayList<>();
        Zapato zapatoBusqueda;
        

        try {
            con = getConexion();
            stt = con.prepareStatement(SQL_ADVANCED);
            
            stt.setString(1, zapato.getTipo());
            stt.setString(2, zapato.getTalla());
            stt.setString(3, zapato.getColor());            
            rs = stt.executeQuery();
            while(rs.next()){
                int idProducto = rs.getInt("id_producto");
                String tipo = rs.getString("tipo");
                String talla = rs.getString("talla");
                String color = rs.getString("color");
                String marca = rs.getString("marca");
                int precio = rs.getInt("precio");
                int cantidad = rs.getInt("cantidad");
                zapatoBusqueda = new Zapato(idProducto, tipo, talla, color, marca, precio, cantidad);
                zapatos.add(zapatoBusqueda);
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

        return zapatos;
    }
    
}
