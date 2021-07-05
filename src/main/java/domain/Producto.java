/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import datos.ProductosDao;
import java.util.List;

/**
 *
 * @author Acmm
 */
public class Producto  extends Ropa{
    
     public Producto(int idProducto,String tipo,String talla,String color,String marca,int precio,int cantidad){
        this.tipo = tipo;
        this.color = color;
        this.marca = marca;
        this.talla = talla;
        this.precio = precio;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public Producto() {
        
    }
    
     
     public List<Producto> consulta(){
         ProductosDao productodao = new ProductosDao();
        return productodao.seleccionar();
     }
    
}
