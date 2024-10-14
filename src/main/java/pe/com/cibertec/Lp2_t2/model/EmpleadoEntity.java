package pe.com.cibertec.Lp2_t2.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_empleado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoEntity {

	@Id
	@Column(name = "dni_empleado", length = 8)
	private String dni;

	@Column(name = "nombre_empleado", length = 45, nullable = false)
	private String nombreEmpleado;

	@Column(name = "apellido_empleado", length = 45, nullable = false)
	private String apellidoEmpleado;

	@Column(name = "fecha_nacimiento", nullable = false)
	private Date fechaNacimiento;

	@Column(name = "direccion", length = 45)
	private String direccion;

	@Column(name = "correo", length = 45)
	private String correo;

	@ManyToOne
	@JoinColumn(name = "area_id", referencedColumnName = "area_id", nullable = false)
	private AreaEntity area;
}
