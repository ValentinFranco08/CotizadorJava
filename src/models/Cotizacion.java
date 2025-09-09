package models;

public class Cotizacion {
    private final MetodoPagoStrategy estrategia;

    public Cotizacion(MetodoPagoStrategy estrategia) {
        if (estrategia == null) throw new IllegalArgumentException("Estrategia nula");
        this.estrategia = estrategia;
    }

    public double calcular(double precioBase, double valorPermuta) {
        if (precioBase < 0) throw new IllegalArgumentException("Precio base inválido");
        if (valorPermuta < 0) valorPermuta = 0;
        return estrategia.calcularPrecio(precioBase, valorPermuta);
    }
}
