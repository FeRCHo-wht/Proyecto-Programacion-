package controlador;

import javax.swing.JOptionPane;
import datos.BaseDatosEmpleados;
import datos.DatosFinancieros;
import modelo.Empleado;
import modelo.Nomina;
import vista.Bienvenida;
import vista.VistaNomina;
import vista.VistaResumenFinanciero;

public class ControladorGimnasio {
    private static double tarifaHora = 15000.0;

    public static void main(String[] args) {
        int[] informacionGimnasio = Bienvenida.solicitarInformacionGimnasio();

        for (int i = 0; i < informacionGimnasio[0]; i++) {
            agregarCliente();
        }

        for (int i = 0; i < informacionGimnasio[1]; i++) {
            agregarEmpleado();
        }

        mostrarComprobantesDePago();

        VistaResumenFinanciero.mostrarResumenFinanciero();
    }

    private static void agregarCliente() {
        DatosFinancieros.agregarIngresoMembresia(Constantes.TARIFA_MEMBRESIA);
    }

    private static void agregarEmpleado() {
        int codigo = BaseDatosEmpleados.obtenerEmpleados().size() + 1;

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
        int horasTrabajadas = obtenerHorasTrabajadas(nombre);

        Empleado nuevoEmpleado = new Empleado(codigo, nombre, horasTrabajadas);
        BaseDatosEmpleados.agregarEmpleado(nuevoEmpleado);

        double salario = Nomina.calcularSalario(nuevoEmpleado, tarifaHora);
        DatosFinancieros.agregarGastoSalario(salario);
    }

    private static int obtenerHorasTrabajadas(String nombre) {
        int horasTrabajadas = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                horasTrabajadas = Integer.parseInt(
                        JOptionPane.showInputDialog("Ingrese las horas trabajadas por " + nombre + ":")
                );

                if (horasTrabajadas >= 0 && horasTrabajadas <= Constantes.MAX_HORAS_MENSUALES) {
                    entradaValida = true;
                } else {
                    mostrarMensajeError("Ingrese un número válido de horas (entre 0 y " + Constantes.MAX_HORAS_MENSUALES + ").");
                }
            } catch (NumberFormatException e) {
                mostrarMensajeError("Ingrese un número válido.");
            }
        }

        return horasTrabajadas;
    }

    private static void mostrarComprobantesDePago() {
        for (Empleado empleado : BaseDatosEmpleados.obtenerEmpleados()) {
            VistaNomina.mostrarComprobantePago(empleado, tarifaHora);
        }
    }

    private static void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

