
package domain;


public class Camisa extends Ropa{
    
    public Camisa(){
        
    }
    
    public Camisa(String tipo,String talla,String color,String marca,int precio){
        this.color = color;
        this.marca = marca;
        this.talla = talla;
        this.precio = precio;
        this.tipo = tipo;
    }
    
    
    
     public Camisa(int idProducto,String tipo,String talla,String color,String marca,int precio,int cantidad){
        this.color = color;
        this.marca = marca;
        this.talla = talla;
        this.precio = precio;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }
     
    public Camisa(int idProducto){
        this.idProducto = idProducto;
    }
    
    public Camisa(String tipo,String talla,String color){
        this.tipo = tipo;
        this.color = color;
        this.talla = talla;        
    }
}
