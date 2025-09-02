// Ubicación: /Main.java
import models.*;
import controller.CotizacionController;

public class Main {
    public static void main(String[] args) {
        // 1. Se crea el objeto de negocio (Modelo)
        Vehiculo fiatCronos = new Vehiculo("Fiat", "Cronos", 25000000.00);
        Cotizacion cotizacion = new Cotizacion(fiatCronos);

        // 2. Se crea el Controlador y se asocia con el Modelo
        CotizacionController controller = new CotizacionController(cotizacion);

        // --- SIMULACIÓN DE INTERACCIÓN DEL USUARIO ---

        System.out.println("Vehículo: " + fiatCronos.getMarca() + " " + fiatCronos.getModelo());
        System.out.println("Precio de Lista: $" + String.format("%.2f", fiatCronos.getPrecioLista()));
        System.out.println("------------------------------------------");

        // Escenario 1: El usuario elige "Pago de Contado"
        System.out.println("Usuario selecciona: Pago de Contado");
        controller.calcularPrecioFinal("contado", 0);
        
        System.out.println("------------------------------------------");

        // Escenario 2: El usuario elige "Financiado"
        System.out.println("Usuario selecciona: Financiado");
        controller.calcularPrecioFinal("financiado", 0);

        System.out.println("------------------------------------------");

        // Escenario 3: El usuario elige "Permuta" y entrega un usado valuado en $8,000,000
        System.out.println("Usuario selecciona: Permuta (entrega usado por $8,000,000)");
        controller.calcularPrecioFinal("permuta", 8000000.00);
    }
}