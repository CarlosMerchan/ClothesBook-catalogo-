/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Pantalon;
import java.util.List;

/**
 *
 * @author Acmm
 */
public interface PantalonDao {
    
    public List<Pantalon> seleccionar();
    
    public int actulizar(Pantalon pantalon);
    
    public int eliminar(Pantalon pantalon);
    
    public int insertar(Pantalon pantalon);
    
    public  List<Pantalon> busquedaAvanzada(Pantalon pantalon);
}
