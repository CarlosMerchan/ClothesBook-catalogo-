
package datos;

import domain.Camisa;
import java.util.List;


public interface CamisaDao {
    
    public List<Camisa> seleccionar();
    
    public int actulizar(Camisa camisa);
    
    public int eliminar(Camisa camisa);
    
    public int insertar(Camisa camisa);
    
    public  List<Camisa> busquedaAvanzada(Camisa camisa);
}
