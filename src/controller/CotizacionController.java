package controller;

import models.Cotizacion;
import models.MetodoPagoStrategy;
import support.StrategyFactory;

public class CotizacionController {

    public double cotizar(String metodoPago, double precioBase, double valorPermuta) {
        MetodoPagoStrategy estrategia = StrategyFactory.of(metodoPago);
        Cotizacion cotizacion = new Cotizacion(estrategia);
        return cotizacion.calcular(precioBase, valorPermuta);
    }
}
