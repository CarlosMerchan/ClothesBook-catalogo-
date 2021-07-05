
package domain;


public class Pantalon extends Ropa{
    
    public Pantalon(String tipo,String talla,String color,String marca,int precio){
        this.color = color;
        this.marca = marca;
        this.talla = talla;
        this.precio = precio;
        this.tipo = tipo;
    }
    
    
    
     public Pantalon(int idProducto,String tipo,String talla,String color,String marca,int precio,int cantidad){
        this.tipo = tipo;
        this.color = color;
        this.marca = marca;
        this.talla = talla;
        this.precio = precio;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }
     
    public Pantalon(int idProducto){
        this.idProducto = idProducto;
    }
    
    public Pantalon(String tipo,String talla,String color){
        this.tipo = tipo;
        this.color = color;
        this.talla = talla;        
    }
}
