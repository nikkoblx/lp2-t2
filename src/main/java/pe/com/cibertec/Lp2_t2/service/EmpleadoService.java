package pe.com.cibertec.Lp2_t2.service;

import java.util.List;

import pe.com.cibertec.Lp2_t2.model.EmpleadoEntity;

public interface EmpleadoService {
	
    List<EmpleadoEntity> buscarEmpleados();
    EmpleadoEntity buscarEmpleadoPorDni(String dni);
    void crearEmpleado(EmpleadoEntity empleadoEntity);
    void actualizarEmpleado(String dni, EmpleadoEntity empleadoEntity);
    void eliminarEmpleado(String dniEmpleado);
}
