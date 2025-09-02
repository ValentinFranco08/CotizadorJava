// Ubicación: /modelo/Vehiculo.java
package models;

// Un simple objeto de datos para el vehículo.
public class Vehiculo {
    private String marca;
    private String modelo;
    private double precioLista;

    public Vehiculo(String marca, String modelo, double precioLista) {
        this.marca = marca;
        this.modelo = modelo;
        this.precioLista = precioLista;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecioLista() {
        return precioLista;
    }
    // Otros getters y setters...
}