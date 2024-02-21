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
                String input = JOptionPane.showInputDialog("Bienvenido al Gym Arsenal. Ingrese el n�mero de clientes:");

                if (input == null) {
                    System.exit(0);
                }

                numeroClientes = Integer.parseInt(input);

                if (numeroClientes > 0) {
                    entradaValida = true;
                } else {
                    mostrarMensajeError("Ingrese un n�mero v�lido mayor que cero.");
                }
            } catch (NumberFormatException e) {
                mostrarMensajeError("Ingrese un n�mero v�lido.");
            }
        }

        return numeroClientes;
    }

    private static int solicitarNumeroEmpleados() {
        int numeroEmpleados = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese el n�mero de empleados (m�ximo 6):");

                if (input == null) {
                    System.exit(0);
                }

                numeroEmpleados = Integer.parseInt(input);

                if (numeroEmpleados > 0 && numeroEmpleados <= Constantes.MAX_EMPLEADOS) {
                    entradaValida = true;
                } else {
                    mostrarMensajeError("Ingrese un n�mero v�lido mayor que cero y no mayor que " + Constantes.MAX_EMPLEADOS);
                }
            } catch (NumberFormatException e) {
                mostrarMensajeError("Ingrese un n�mero v�lido.");
            }
        }

        return numeroEmpleados;
    }

    public static int mostrarMenuRecibo() {
        String[] opciones = {"Mostrar Recibo de Empleado", "Mostrar N�mina Financiera del Gimnasio"};
        return JOptionPane.showOptionDialog(
                null,
                "Seleccione una opci�n:",
                "Men� Recibo",
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
                String input = JOptionPane.showInputDialog("Ingrese el c�digo del empleado:");

                if (input == null) {
                    System.exit(0);
                }

                codigoEmpleado = Integer.parseInt(input);

                if (codigoEmpleado > 0) {
                    entradaValida = true;
                } else {
                    mostrarMensajeError("Ingrese un c�digo v�lido mayor que cero.");
                }
            } catch (NumberFormatException e) {
                mostrarMensajeError("Ingrese un c�digo v�lido.");
            }
        }

        return codigoEmpleado;
    }

    private static void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
