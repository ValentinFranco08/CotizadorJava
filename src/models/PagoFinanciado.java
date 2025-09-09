package models;

public class PagoFinanciado implements MetodoPagoStrategy {
    @Override
    public double calcularPrecio(double precioBase, double valorPermuta) {
        return precioBase * 1.20; // 20% de recargo
    }
}
