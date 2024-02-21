package modelo;

public class Empleado implements Comparable<Empleado> {
    private int codigo;
    private String nombre;
    private int horasTrabajadas;
    private double salarioBruto;
    private double ISR;
    private double salarioNeto;

    public Empleado(int codigo, String nombre, int horasTrabajadas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
        this.salarioBruto = 0.0;
        this.ISR = 0.0;
        this.salarioNeto = 0.0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getISR() {
        return ISR;
    }

    public void setISR(double ISR) {
        this.ISR = ISR;
    }

    public double getSalarioNeto() {
        return salarioNeto;
    }

    public void setSalarioNeto(double salarioNeto) {
        this.salarioNeto = salarioNeto;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", horasTrabajadas=" + horasTrabajadas +
                ", salarioBruto=" + salarioBruto +
                ", ISR=" + ISR +
                ", salarioNeto=" + salarioNeto +
                '}';
    }

    @Override
    public int compareTo(Empleado otroEmpleado) {
        // Comparar por salarioNeto de manera descendente
        return Double.compare(otroEmpleado.getSalarioNeto(), this.getSalarioNeto());
    }
}
