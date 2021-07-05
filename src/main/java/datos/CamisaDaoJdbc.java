
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConexion;
import domain.Camisa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class CamisaDaoJdbc implements CamisaDao{
    
    private static final String SQL_SELECT = "SELECT * FROM clothesbook.productos WHERE tipo ='polo' OR tipo ='camisa'"; 
    private static final String SQL_INSERT = "INSERT INTO clothesbook.productos(tipo,talla,color,marca,precio,cantidad) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE clothesbook.productos SET tipo = ?,talla = ?, color = ? , marca = ? , precio = ? , cantidad = ? WHERE id_producto = ?";
    private static final String SQL_DELETE = "DELETE FROM clothesbook.productos WHERE id_persona = ?";
    private static final String SQL_ADVANCED ="SELECT * FROM clothesbook.productos WHERE tipo = ? AND talla = ? AND color =?";

    @Override
    public List<Camisa> seleccionar() {
         Connection con = null;
        PreparedStatement stt = null;
        ResultSet rs = null;
        List<Camisa> camisas = new ArrayList<>();
        Camisa camisa;

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
                camisa = new Camisa(idProducto, tipo, talla, color, marca, precio, cantidad);
                camisas.add(camisa);
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

        return camisas;
    }

    @Override
    public int actulizar(Camisa camisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Camisa camisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(Camisa camisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Camisa> busquedaAvanzada(Camisa camisa) {
        Connection con = null;
        PreparedStatement stt = null;
        ResultSet rs = null;
        List<Camisa> camisas = new ArrayList<>();
        Camisa camisaBusqueda;
        

        try {
            con = getConexion();
            stt = con.prepareStatement(SQL_ADVANCED);
            
            stt.setString(1, camisa.getTipo());
            stt.setString(2, camisa.getTalla());
            stt.setString(3, camisa.getColor());            
            rs = stt.executeQuery();
            while(rs.next()){
                int idProducto = rs.getInt("id_producto");
                String tipo = rs.getString("tipo");
                String talla = rs.getString("talla");
                String color = rs.getString("color");
                String marca = rs.getString("marca");
                int precio = rs.getInt("precio");
                int cantidad = rs.getInt("cantidad");
                camisaBusqueda = new Camisa(idProducto, tipo, talla, color, marca, precio, cantidad);
                camisas.add(camisaBusqueda);
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

        return camisas;
    }
    
}
