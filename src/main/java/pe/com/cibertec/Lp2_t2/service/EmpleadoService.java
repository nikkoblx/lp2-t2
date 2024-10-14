package pe.com.cibertec.Lp2_t2.service;

import java.util.List;

import pe.com.cibertec.Lp2_t2.model.EmpleadoEntity;

public interface EmpleadoService {

	List<EmpleadoEntity> buscarEmpleados();
    EmpleadoEntity buscarEmpleadoPorDni(String dniEmpleado);
    void crearEmpleado(EmpleadoEntity empleadoEntity);
    void actualizarEmpleado(String dniEmpleado, EmpleadoEntity empleadoEntity);
    void eliminarEmpleado(String dniEmpleado);
}
