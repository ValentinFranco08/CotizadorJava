package models;

public interface MetodoPagoStrategy {
    /**
     * @param precioBase     precio del vehículo
     * @param valorPermuta   valor a descontar (si aplica). Para estrategias que no lo usan, ignorar.
     * @return precio final
     */
    double calcularPrecio(double precioBase, double valorPermuta);
}
