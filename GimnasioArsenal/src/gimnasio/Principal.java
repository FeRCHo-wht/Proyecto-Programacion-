package gimnasio;

import javax.swing.JOptionPane;
import controlador.Constantes;
import datos.BaseDatosEmpleados;
import datos.DatosFinancieros;
import modelo.Empleado;
import modelo.Nomina;
import vista.Bienvenida;
import vista.VistaNomina;
import vista.VistaResumenFinanciero;

public class Principal {
    public static void main(String[] args) {
        boolean salir = false;

        do {
            int opcion = mostrarMenu();

            switch (opcion) {
                case 1:
                    gestionarInformacionGimnasio();
                    break;
                case 2:
                    mostrarReciboGimnasio();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    mostrarMensajeError("Opci�n no v�lida. Por favor, ingrese una opci�n v�lida.");
            }
        } while (!salir);
    }

    private static int mostrarMenu() {
        String[] opciones = {"Gestionar Informaci�n del Gimnasio", "Mostrar Recibo del Gimnasio", "Salir"};
        return JOptionPane.showOptionDialog(
                null,
                "Seleccione una opci�n:",
                "Men� Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
        ) + 1;
    }

    private static void gestionarInformacionGimnasio() {
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

        double salario = Nomina.calcularSalario(nuevoEmpleado, Constantes.TARIFA_HORA);
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
                    mostrarMensajeError("Ingrese un n�mero v�lido de horas (entre 0 y " + Constantes.MAX_HORAS_MENSUALES + ").");
                }
            } catch (NumberFormatException e) {
                mostrarMensajeError("Ingrese un n�mero v�lido.");
            }
        }

        return horasTrabajadas;
    }

    private static void mostrarComprobantesDePago() {
        for (Empleado empleado : BaseDatosEmpleados.obtenerEmpleados()) {
            VistaNomina.mostrarComprobantePago(empleado, Constantes.TARIFA_HORA);
        }
    }

    private static void mostrarReciboGimnasio() {
        int opcionRecibo = Bienvenida.mostrarMenuRecibo();

        switch (opcionRecibo) {
            case 1:
                mostrarReciboEmpleado();
                break;
            case 2:
                mostrarNominasGimnasio();
                break;
            default:
                mostrarMensajeError("Opci�n no v�lida. Por favor, ingrese una opci�n v�lida.");
        }
    }

    private static void mostrarReciboEmpleado() {
        int codigoEmpleado = Bienvenida.solicitarCodigoEmpleado();
        Empleado empleado = BaseDatosEmpleados.buscarEmpleadoPorCodigo(codigoEmpleado);

        if (empleado != null) {
            VistaNomina.mostrarComprobantePago(empleado, Constantes.TARIFA_HORA);
        } else {
            mostrarMensajeError("No se encontr� un empleado con el c�digo " + codigoEmpleado);
        }
    }

    private static void mostrarNominasGimnasio() {
        VistaResumenFinanciero.mostrarResumenFinanciero();
    }

    private static void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
