package pe.com.cibertec.Lp2_t2.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_area")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AreaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer area_id;
    
	@Column(name = "nombre_area", length = 45, nullable = false)
    private String nombreArea;
	
	@OneToMany(mappedBy = "area", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EmpleadoEntity> empleado;
}
