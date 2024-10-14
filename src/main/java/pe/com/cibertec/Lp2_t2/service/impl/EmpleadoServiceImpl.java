package pe.com.cibertec.Lp2_t2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.com.cibertec.Lp2_t2.model.EmpleadoEntity;
import pe.com.cibertec.Lp2_t2.repository.EmpleadoRepository;
import pe.com.cibertec.Lp2_t2.service.EmpleadoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<EmpleadoEntity> buscarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public EmpleadoEntity buscarEmpleadoPorDni(String dni) {
        return empleadoRepository.findByDni(dni);
    }

    @Override
    public void crearEmpleado(EmpleadoEntity empleadoEntity) {
        empleadoRepository.save(empleadoEntity);
    }

    @Override
    public void actualizarEmpleado(String dni, EmpleadoEntity empleadoEntity) {
        EmpleadoEntity empleadoExistente = empleadoRepository.findByDni(empleadoEntity.getDni());
        if(empleadoExistente == null) {
            throw new RuntimeException("Empleado no encontrado.");
        }
        try {
            empleadoExistente.setNombreEmpleado(empleadoEntity.getNombreEmpleado());
            empleadoExistente.setApellidoEmpleado(empleadoEntity.getApellidoEmpleado());
            empleadoExistente.setFechaNacimiento(empleadoEntity.getFechaNacimiento());
            empleadoExistente.setCorreo(empleadoEntity.getCorreo());
            empleadoExistente.setDireccion(empleadoEntity.getDireccion());
            empleadoExistente.setArea(empleadoEntity.getArea());
            empleadoRepository.save(empleadoExistente);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error al actualizar. ");
        }
    }

    @Override
    public void eliminarEmpleado(String dni) {
        EmpleadoEntity empleadoExistente = empleadoRepository.findByDni(dni);
        if(empleadoExistente != null) {
            empleadoRepository.delete(empleadoExistente);
        }
    }
}