package pe.com.cibertec.Lp2_t2.service;

import java.util.List;

import pe.com.cibertec.Lp2_t2.model.AreaEntity;

public interface AreaService {

	List<AreaEntity> buscarArea();
	AreaEntity buscarAreaPorId(Integer id);
	void crearArea(AreaEntity areaEntity);
	void actualizarArea(Integer id, AreaEntity areaEntity);
	void eliminarArea(Integer id);
}