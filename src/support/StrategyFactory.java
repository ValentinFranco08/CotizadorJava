package support;

import java.util.Map;
import java.util.function.Supplier;
import models.*;

public class StrategyFactory {
    // clave -> constructor de la estrategia
    private static final Map<String, Supplier<MetodoPagoStrategy>> REGISTRY = Map.of(
        "contado",     PagoContado::new,
        "financiado",  PagoFinanciado::new,
        "permuta",     PagoPermuta::new
    );

    public static MetodoPagoStrategy of(String metodoPago) {
        if (metodoPago == null) throw new IllegalArgumentException("Método nulo");
        Supplier<MetodoPagoStrategy> sup = REGISTRY.get(metodoPago.toLowerCase());
        if (sup == null) {
            throw new IllegalArgumentException("Método de pago desconocido: " + metodoPago);
        }
        return sup.get();
    }
}
