package models;

public class PagoContado implements MetodoPagoStrategy {
    @Override
    public double calcularPrecio(double precioBase, double valorPermuta) {
        return precioBase * 0.95; // 5% de descuento
    }
}
