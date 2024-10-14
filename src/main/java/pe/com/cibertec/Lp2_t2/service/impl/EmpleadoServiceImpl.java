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
        if (empleadoRepository.existsById(dni)) {
            empleadoEntity.setDni(dni);
            empleadoRepository.save(empleadoEntity);
        }
    }

    @Override
    public void eliminarEmpleado(String dni) {
        empleadoRepository.deleteById(dni);
    }
}