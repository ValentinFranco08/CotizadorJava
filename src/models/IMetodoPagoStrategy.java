// Ubicación: /modelo/IMetodoPagoStrategy.java
package models;

// La interfaz Strategy define la operación que las estrategias concretas implementarán.
public interface IMetodoPagoStrategy {
    double calcularPrecioFinal(Cotizacion cotizacion);
}