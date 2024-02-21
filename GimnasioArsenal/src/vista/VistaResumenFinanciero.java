package vista;

import javax.swing.JOptionPane;
import datos.DatosFinancieros;

public class VistaResumenFinanciero {
    public static void mostrarResumenFinanciero() {
        double ingresosMembresias = DatosFinancieros.obtenerIngresosMembresias();
        double gastosSalarios = DatosFinancieros.obtenerGastosSalarios();
        double balance = DatosFinancieros.obtenerBalance();

        String mensaje = String.format(
                "Resumen Financiero\nIngresos por Membresías: $%.2f\nGastos en Salarios: $%.2f\nBalance: $%.2f",
                ingresosMembresias, gastosSalarios, balance
        );

        JOptionPane.showMessageDialog(null, mensaje, "Resumen Financiero", JOptionPane.INFORMATION_MESSAGE);
    }
}
