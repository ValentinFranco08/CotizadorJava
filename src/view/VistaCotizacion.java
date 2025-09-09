package view;

import controller.CotizacionController;
import java.util.Locale;
import java.util.Scanner;

public class VistaCotizacion {

    private final CotizacionController controller;

    public VistaCotizacion(CotizacionController controller) {
        this.controller = controller;
    }

    public void mostrar() {
        Locale.setDefault(Locale.US); // para usar punto decimal
        Scanner sc = new Scanner(System.in);
        System.out.print("Precio base: ");
        double precio = sc.nextDouble();
        System.out.print("Valor permuta: ");
        double permuta = sc.nextDouble();
        sc.nextLine(); // limpiar
        System.out.print("Método (contado | financiado | permuta): ");
        String metodo = sc.nextLine().trim();

        double total = controller.cotizar(metodo, precio, permuta);
        System.out.printf("Total: %.2f%n", total);
    }
}
