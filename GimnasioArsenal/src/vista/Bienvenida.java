package vista;

import javax.swing.JOptionPane;
import controlador.Constantes;

public class Bienvenida {
    public static int[] solicitarInformacionGimnasio() {
        int[] informacionGimnasio = new int[2];

        informacionGimnasio[0] = solicitarNumeroClientes();
        informacionGimnasio[1] = solicitarNumeroEmpleados();

        return informacionGimnasio;
    }

    private static int solicitarNumeroClientes() {
        int numeroClientes = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                String input = JOptionPane.showInputDialog("Bienvenido al Gym Arsenal. Ingrese el número de clientes:");

                if (input == null) {
                    System.exit(0);
                }

                numeroClientes = Integer.parseInt(input);

                if (numeroClientes > 0) {
                    entradaValida = true;
                } else {
                    mostrarMensajeError("Ingrese un número válido mayor que cero.");
                }
            } catch (NumberFormatException e) {
                mostrarMensajeError("Ingrese un número válido.");
            }
        }

        return numeroClientes;
    }

    private static int solicitarNumeroEmpleados() {
        int numeroEmpleados = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese el número de empleados (máximo 6):");

                if (input == null) {
                    System.exit(0);
                }

                numeroEmpleados = Integer.parseInt(input);

                if (numeroEmpleados > 0 && numeroEmpleados <= Constantes.MAX_EMPLEADOS) {
                    entradaValida = true;
                } else {
                    mostrarMensajeError("Ingrese un número válido mayor que cero y no mayor que " + Constantes.MAX_EMPLEADOS);
                }
            } catch (NumberFormatException e) {
                mostrarMensajeError("Ingrese un número válido.");
            }
        }

        return numeroEmpleados;
    }

    public static int mostrarMenuRecibo() {
        String[] opciones = {"Mostrar Recibo de Empleado", "Mostrar Nómina Financiera del Gimnasio"};
        return JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción:",
                "Menú Recibo",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
        ) + 1;
    }

    public static int solicitarCodigoEmpleado() {
        int codigoEmpleado = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese el código del empleado:");

                if (input == null) {
                    System.exit(0);
                }

                codigoEmpleado = Integer.parseInt(input);

                if (codigoEmpleado > 0) {
                    entradaValida = true;
                } else {
                    mostrarMensajeError("Ingrese un código válido mayor que cero.");
                }
            } catch (NumberFormatException e) {
                mostrarMensajeError("Ingrese un código válido.");
            }
        }

        return codigoEmpleado;
    }

    private static void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
