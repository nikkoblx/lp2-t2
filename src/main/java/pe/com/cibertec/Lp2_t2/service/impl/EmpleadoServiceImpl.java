package pe.com.cibertec.Lp2_t2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.cibertec.Lp2_t2.model.EmpleadoEntity;
import pe.com.cibertec.Lp2_t2.repository.EmpleadoRepository;
import pe.com.cibertec.Lp2_t2.service.EmpleadoService;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<EmpleadoEntity> buscarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public EmpleadoEntity buscarEmpleadoPorDni(String dniEmpleado) {
        return empleadoRepository.findByDniEmpleado(dniEmpleado);
    }

    @Override
    public void crearEmpleado(EmpleadoEntity empleadoEntity) {
        empleadoRepository.save(empleadoEntity);
    }

    @Override
    public void actualizarEmpleado(String dniEmpleado, EmpleadoEntity empleadoEntity) {
        if (empleadoRepository.existsById(dniEmpleado)) {
            empleadoEntity.setDniEmpleado(dniEmpleado);
            empleadoRepository.save(empleadoEntity);
        }
    }

    @Override
    public void eliminarEmpleado(String dniEmpleado) {
        empleadoRepository.deleteById(dniEmpleado);
    }
}