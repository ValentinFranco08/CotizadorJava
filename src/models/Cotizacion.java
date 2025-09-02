// Ubicación: /modelo/Cotizacion.java
package models;

public class Cotizacion {
    private Vehiculo vehiculo;
    private IMetodoPagoStrategy metodoPago;
    private double valorVehiculoUsado; // Solo relevante para la estrategia de permuta

    public Cotizacion(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    // El controlador usará este método para cambiar la estrategia dinámicamente
    public void setMetodoPago(IMetodoPagoStrategy metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    // El modelo delega el cálculo a la estrategia actual
    public double calcularTotal() {
        if (metodoPago == null) {
            System.out.println("Error: No se ha seleccionado un método de pago.");
            return vehiculo.getPrecioLista();
        }
        return metodoPago.calcularPrecioFinal(this);
    }
    
    // Getters y Setters necesarios para las estrategias
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setValorVehiculoUsado(double valor) {
        this.valorVehiculoUsado = valor;
    }

    public double getValorVehiculoUsado() {
        return valorVehiculoUsado;
    }
}