/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;


abstract class Ropa {
    
    protected int idProducto;
    protected String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    protected String talla;
    protected String color;
    protected String marca;
    protected int precio;
    protected int cantidad;
    

    public int getIdProducto() {
        return idProducto;
    }
    

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

   
    
    

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return idProducto + tipo +  talla +  color +  marca +  precio  + cantidad ;
    }

    
}
