package datos;

public class DatosFinancieros {
    private static double ingresosMembresias = 0.0;
    private static double gastosSalarios = 0.0;

    public static void agregarIngresoMembresia(double ingreso) {
        ingresosMembresias += ingreso;
    }

    public static void agregarGastoSalario(double gasto) {
        gastosSalarios += gasto;
    }

    public static double obtenerIngresosMembresias() {
        return ingresosMembresias;
    }

    public static double obtenerGastosSalarios() {
        return gastosSalarios;
    }

    public static double obtenerBalance() {
        return ingresosMembresias - gastosSalarios;
    }

    public static void reiniciarDatosFinancieros() {
        ingresosMembresias = 0.0;
        gastosSalarios = 0.0;
    }
}