/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import domain.Zapato;
import java.util.List;

/**
 *
 * @author Acmm
 */
public interface ZapatoDao {
    
    public List<Zapato> seleccionar();
    
    public int actulizar(Zapato zapato);
    
    public int eliminar(Zapato zapato);
    
    public int insertar(Zapato zapato);
    
    public  List<Zapato> busquedaAvanzada(Zapato zapato);
}
