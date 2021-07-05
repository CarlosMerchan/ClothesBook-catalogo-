/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Acmm
 */
public class Zapato extends Ropa{
    
    public Zapato(){
        
    }
    
    public Zapato(String tipo,String talla,String color,String marca,int precio){
        this.tipo = tipo;
        this.color = color;
        this.marca = marca;
        this.talla = talla;        
        this.precio = precio;
    }
    
    
    
     public Zapato(int idProducto,String tipo,String talla,String color,String marca,int precio,int cantidad){
        this.tipo = tipo;
        this.color = color;
        this.marca = marca;
        this.talla = talla;        
        this.precio = precio;
        this.cantidad = cantidad;
        this.idProducto = idProducto;
    }
     
    public Zapato(int idProducto){
        this.idProducto = idProducto;
    }
    
    public Zapato(String tipo,String talla,String color){
        this.tipo = tipo;
        this.color = color;
        this.talla = talla;        
    }
    
    
    
    
    
    
    
    
    
    
}
