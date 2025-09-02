// Ubicación: /controlador/CotizacionController.java
package controller;

import models.*;

public class CotizacionController {
    private Cotizacion modelo;
    // private VistaCotizacion vista; // La vista se puede inyectar si es necesario

    public CotizacionController(Cotizacion modelo) {
        this.modelo = modelo;
        // this.vista = vista; // Se puede inyectar la vista si se requiere
    }

    /**
     * Calcula el precio final según el tipo de pago y el valor del vehículo usado.
     * Este método debería ser llamado por la vista (por ejemplo, al hacer clic en un botón).
     *
     * @param tipoPago   Tipo de pago ("contado", "financiado", "permuta")
     * @param valorUsado Valor del vehículo usado (solo relevante para permuta)
     */
    public void calcularPrecioFinal(String tipoPago, double valorUsado) {
        IMetodoPagoStrategy estrategiaSeleccionada;

        switch (tipoPago.toLowerCase()) {
            case "contado":
                estrategiaSeleccionada = new EstrategiaPagoContado();
                break;
            case "financiado":
                estrategiaSeleccionada = new EstrategiaPagoFinanciado();
                break;
            case "permuta":
                modelo.setValorVehiculoUsado(valorUsado);
                estrategiaSeleccionada = new EstrategiaPagoPermuta();
                break;
            default:
                throw new IllegalArgumentException("Método de pago no válido: " + tipoPago);
        }

        // Establece la estrategia en el modelo
        modelo.setMetodoPago(estrategiaSeleccionada);

        // Realiza el cálculo del precio final
        double precioFinal = modelo.calcularTotal();

        // Muestra el resultado (en un entorno real, se pasaría a la vista)
        System.out.println("Precio final calculado: $" + String.format("%.2f", precioFinal));
        // if (vista != null) vista.mostrarResultado(precioFinal);
    }
}