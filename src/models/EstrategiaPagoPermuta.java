// Ubicación: /modelo/EstrategiaPagoPermuta.java
package models;

// Resta el valor del vehículo usado que entrega el cliente.
public class EstrategiaPagoPermuta implements IMetodoPagoStrategy {
    @Override
    public double calcularPrecioFinal(Cotizacion cotizacion) {
        double precioLista = cotizacion.getVehiculo().getPrecioLista();
        double valorUsado = cotizacion.getValorVehiculoUsado();
        System.out.println("Descontando valor de vehículo usado...");
        return precioLista - valorUsado;
    }
}