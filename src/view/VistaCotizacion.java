// Ubicación: /vista/VistaCotizacion.java
package view;

import controller.CotizacionController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * La Vista es responsable de toda la interfaz de usuario.
 * No contiene ninguna lógica de negocio. Simplemente muestra datos
 * y envía las acciones del usuario al Controlador.
 */
public class VistaCotizacion extends JFrame {

    // Referencia al controlador para enviar acciones del usuario
    private CotizacionController controlador;

    // Componentes de la UI
    private JLabel lblVehiculoInfo;
    private JLabel lblPrecioLista;
    private JRadioButton optContado, optFinanciado, optPermuta;
    private JTextField txtValorUsado;
    private JButton btnCalcular;
    private JLabel lblPrecioFinal;

    // Formateador para mostrar los precios en formato de moneda local (ARS)
    private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("es", "AR"));

    public VistaCotizacion() {
        // --- 1. Configuración de la ventana principal ---
        setTitle("Cotizador de Vehículos - TuAutoBolivar");
        setSize(450, 400); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la app al cerrar la ventana
        setLayout(new GridLayout(7, 1, 10, 10)); // Layout simple en forma de grilla
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // --- 2. Creación y configuración de los componentes ---
        
        // Etiquetas para mostrar la información inicial del vehículo
        lblVehiculoInfo = new JLabel("Vehículo: ", SwingConstants.CENTER);
        lblVehiculoInfo.setFont(new Font("Arial", Font.BOLD, 14));

        lblPrecioLista = new JLabel("Precio Lista: ", SwingConstants.CENTER);
        lblPrecioLista.setFont(new Font("Arial", Font.PLAIN, 14));

        // Panel para las opciones de método de pago (JRadioButton)
        JPanel panelPago = new JPanel();
        panelPago.setBorder(BorderFactory.createTitledBorder("Método de Pago"));
        optContado = new JRadioButton("Contado", true); // Opción por defecto
        optFinanciado = new JRadioButton("Financiado");
        optPermuta = new JRadioButton("Permuta");
        
        // Agruparlos para que solo uno pueda ser seleccionado a la vez
        ButtonGroup grupoPago = new ButtonGroup();
        grupoPago.add(optContado);
        grupoPago.add(optFinanciado);
        grupoPago.add(optPermuta);
        panelPago.add(optContado);
        panelPago.add(optFinanciado);
        panelPago.add(optPermuta);

        // Panel para el ingreso del valor del auto usado
        JPanel panelPermuta = new JPanel();
        panelPermuta.add(new JLabel("Valor del usado: $"));
        txtValorUsado = new JTextField(12);
        txtValorUsado.setEnabled(false); // Deshabilitado hasta que se elija "Permuta"
        panelPermuta.add(txtValorUsado);

        // Botón para que el usuario inicie el cálculo
        btnCalcular = new JButton("Calcular Precio Final");

        // Etiqueta para mostrar el resultado final del cálculo
        lblPrecioFinal = new JLabel("PRECIO FINAL: $ -", SwingConstants.CENTER);
        lblPrecioFinal.setFont(new Font("Arial", Font.BOLD, 18));
        lblPrecioFinal.setForeground(new Color(0, 100, 0)); // Color verde oscuro

        // --- 3. Lógica de Eventos (Listeners) ---

        // Listener para los radio buttons: habilita/deshabilita el campo de texto
        ActionListener listenerOpciones = e -> txtValorUsado.setEnabled(optPermuta.isSelected());
        optContado.addActionListener(listenerOpciones);
        optFinanciado.addActionListener(listenerOpciones);
        optPermuta.addActionListener(listenerOpciones);

        // Listener para el botón "Calcular"
        btnCalcular.addActionListener(e -> onCalcularClick());

        // --- 4. Añadir todos los componentes a la ventana ---
        add(lblVehiculoInfo);
        add(lblPrecioLista);
        add(panelPago);
        add(panelPermuta);
        add(btnCalcular);
        add(lblPrecioFinal);
    }
    
    // Método para que el Main o el ensamblador inyecte la dependencia del controlador
    public void setControlador(CotizacionController controlador) {
        this.controlador = controlador;
    }

    /**
     * Este método es llamado por el Controlador cuando el usuario hace clic en el botón.
     * Recoge los datos de la UI y los pasa al controlador.
     */
    private void onCalcularClick() {
        if (controlador == null) {
            System.err.println("Error: El controlador no está asignado a la vista.");
            return;
        }

        String tipoPago = "";
        if (optContado.isSelected()) tipoPago = "contado";
        if (optFinanciado.isSelected()) tipoPago = "financiado";
        if (optPermuta.isSelected()) tipoPago = "permuta";

        double valorUsado = 0;
        if (tipoPago.equals("permuta")) {
            try {
                // Obtener el valor del campo de texto
                valorUsado = Double.parseDouble(txtValorUsado.getText());
            } catch (NumberFormatException ex) {
                // Manejo de error si el usuario ingresa texto no numérico
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico válido para el usado.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        // ¡ACCIÓN CLAVE! La vista le pasa la información al controlador.
        controlador.calcularPrecioFinal(tipoPago, valorUsado);
    }

    // --- MÉTODOS PÚBLICOS PARA SER LLAMADOS POR EL CONTROLADOR ---

    /**
     * El controlador llama a este método al iniciar para poblar la vista
     * con los datos del modelo.
     */
    public void mostrarDatosIniciales(String info, double precio) {
        lblVehiculoInfo.setText("Vehículo: " + info);
        lblPrecioLista.setText("Precio Lista: " + currencyFormatter.format(precio));
    }

    /**
     * El controlador llama a este método después de que el modelo realiza el cálculo,
     * para actualizar la vista con el resultado.
     */
    public void mostrarResultado(double precioFinal) {
        lblPrecioFinal.setText("PRECIO FINAL: " + currencyFormatter.format(precioFinal));
    }
}