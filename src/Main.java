import controller.CotizacionController;
import view.VistaCotizacion;

public class Main {
    public static void main(String[] args) {
        CotizacionController controller = new CotizacionController();
        new VistaCotizacion(controller).mostrar();
    }
}
