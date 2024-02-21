package vista;

import javax.swing.JOptionPane;
import modelo.Empleado;
import modelo.Nomina;

public class VistaNomina {
    public static void mostrarComprobantePago(Empleado empleado, double tarifaHora) {
        Nomina.calcularSalario(empleado, tarifaHora);

        String mensaje = "Comprobante de Pago\n" +
                "Nombre: " + empleado.getNombre() + "\n" +
                "Horas Trabajadas: " + empleado.getHorasTrabajadas() + "\n" +
                "Tarifa por Hora: $" + tarifaHora + "\n" +
                "Salario Bruto: $" + empleado.getSalarioBruto() + "\n" +
                "Impuesto sobre la Renta (ISR): $" + empleado.getISR() + "\n" +
                "Salario Neto: $" + empleado.getSalarioNeto();

        JOptionPane.showMessageDialog(null, mensaje, "Comprobante de Pago", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarResumenFinanciero(double ingresosMembresias, double gastosSalarios) {
        String mensaje = "Resumen Financiero\n" +
                "Ingresos por Membresías: $" + ingresosMembresias + "\n" +
                "Gastos por Salarios: $" + gastosSalarios + "\n" +
                "Balance: $" + (ingresosMembresias - gastosSalarios);

        JOptionPane.showMessageDialog(null, mensaje, "Resumen Financiero", JOptionPane.INFORMATION_MESSAGE);
    }
}
