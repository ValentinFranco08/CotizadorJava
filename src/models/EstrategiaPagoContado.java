// Ubicación: /modelo/EstrategiaPagoContado.java
package models;

// Aplica un 5% de descuento por pago de contado.
public class EstrategiaPagoContado implements IMetodoPagoStrategy {
    @Override
    public double calcularPrecioFinal(Cotizacion cotizacion) {
        double precioLista = cotizacion.getVehiculo().getPrecioLista();
        System.out.println("Aplicando descuento del 5% por pago de contado...");
        return precioLista * 0.95; 
    }
}