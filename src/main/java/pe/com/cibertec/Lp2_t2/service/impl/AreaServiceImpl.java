package pe.com.cibertec.Lp2_t2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.Lp2_t2.model.AreaEntity;
import pe.com.cibertec.Lp2_t2.repository.AreaRepository;
import pe.com.cibertec.Lp2_t2.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
    private AreaRepository areaRepository;

	@Override
    public List<AreaEntity> buscarArea() {
        return areaRepository.findAll();
    }

    @Override
    public AreaEntity buscarAreaPorId(Integer id) {
        return areaRepository.findById(id).orElse(null);
    }

    @Override
    public void crearArea(AreaEntity areaEntity) {
        areaRepository.save(areaEntity);
    }

    @Override
    public void actualizarArea(Integer id, AreaEntity areaEntity) {
        if (areaRepository.existsById(id)) {
            areaEntity.setArea_id(id); 
            areaRepository.save(areaEntity);
        }
    }

    @Override
    public void eliminarArea(Integer id) {
        areaRepository.deleteById(id);
    }
}
