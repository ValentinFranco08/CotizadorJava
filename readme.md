# Cotizador de Vehículos - TuAutoBolivar

Este proyecto es una aplicación Java que utiliza los patrones Modelo-Vista-Controlador (MVC) y Strategy para cotizar vehículos según diferentes métodos de pago: contado, financiado y permuta.

## Estructura del Proyecto

```
src/
  Main.java
  controller/
    CotizacionController.java
  models/
    Cotizacion.java
    Vehiculo.java
    IMetodoPagoStrategy.java
    EstrategiaPagoContado.java
    EstrategiaPagoFinanciado.java
    EstrategiaPagoPermuta.java
  view/
    VistaCotizacion.java
```

## Descripción de Componentes

- **models/**  
  Clases del modelo y estrategias de pago.
- **controller/**  
  Lógica entre la vista y el modelo.
- **view/**  
  Interfaz gráfica para el usuario.
- **Main.java**  
  Punto de entrada de la aplicación.

## Cómo ejecutar

1. Compila los archivos Java:
    ```
    javac src/**/*.java src/*.java
    ```
2. Ejecuta la aplicación:
    ```
    java -cp src Main
    ```

## Ejemplo de uso

El programa simula tres escenarios:
- Pago de contado (5% de descuento)
- Pago financiado (20% de recargo)
- Permuta (descuento del valor del usado)

Ejemplo educativo de patrones de diseño