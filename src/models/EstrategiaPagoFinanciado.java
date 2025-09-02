// Ubicación: /modelo/EstrategiaPagoFinanciado.java
package models;

// Suma un 20% de interés por financiación.
public class EstrategiaPagoFinanciado implements IMetodoPagoStrategy {
    @Override
    public double calcularPrecioFinal(Cotizacion cotizacion) {
        double precioLista = cotizacion.getVehiculo().getPrecioLista();
        System.out.println("Aplicando recargo del 20% por financiación...");
        return precioLista * 1.20; 
    }
}