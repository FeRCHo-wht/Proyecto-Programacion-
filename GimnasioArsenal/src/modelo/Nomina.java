package modelo;

public class Nomina {
    public static final double CALCULO_ISR = 0.19; // Porcentaje de impuesto sobre la renta

    public static double calcularSalario(Empleado empleado, double tarifaHora) {
        double salarioBruto = empleado.getHorasTrabajadas() * tarifaHora;
        double isr = salarioBruto * CALCULO_ISR;
        double salarioNeto = salarioBruto - isr;

        empleado.setSalarioBruto(salarioBruto);
        empleado.setISR(isr);
        empleado.setSalarioNeto(salarioNeto);

        return salarioNeto;
    }

    public static String generarComprobante(Empleado empleado, double tarifaHora) {
        double salarioNeto = calcularSalario(empleado, tarifaHora);

        String comprobante = "Comprobante de Pago\n" +
                "Nombre: " + empleado.getNombre() + "\n" +
                "Horas Trabajadas: " + empleado.getHorasTrabajadas() + "\n" +
                "Tarifa por Hora: $" + tarifaHora + "\n" +
                "Salario Bruto: $" + empleado.getSalarioBruto() + "\n" +
                "Impuesto sobre la Renta (ISR): $" + empleado.getISR() + "\n" +
                "Salario Neto: $" + salarioNeto;

        return comprobante;
    }
}

