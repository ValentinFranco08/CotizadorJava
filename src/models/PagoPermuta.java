package models;

public class PagoPermuta implements MetodoPagoStrategy {
    @Override
    public double calcularPrecio(double precioBase, double valorPermuta) {
        double total = precioBase - valorPermuta;
        return Math.max(total, 0.0); // nunca negativo
    }
}
