package pe.com.cibertec.Lp2_t2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.Lp2_t2.model.AreaEntity;

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity, Integer>{

}
