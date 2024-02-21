package datos;

import modelo.Empleado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDatosEmpleados {
    private static final Map<Integer, Empleado> empleados = new HashMap<>();

    public static void agregarEmpleado(Empleado empleado) {
        empleados.put(empleado.getCodigo(), empleado);
    }

    public static List<Empleado> obtenerEmpleados() {
        return new ArrayList<>(empleados.values());
    }

    public static Empleado buscarEmpleadoPorCodigo(int codigo) {
        return empleados.get(codigo);
    }

    public static void actualizarEmpleado(Empleado empleadoActualizado) {
        empleados.put(empleadoActualizado.getCodigo(), empleadoActualizado);
    }

    public static void eliminarEmpleado(int codigo) {
        empleados.remove(codigo);
    }
}

