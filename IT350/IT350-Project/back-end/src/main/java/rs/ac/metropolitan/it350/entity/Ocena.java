package rs.ac.metropolitan.it350.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ocena")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Ocena extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_ocene")
	private Integer id;
	@JoinColumn(name = "id_posla", referencedColumnName = "id_posla")
	@ManyToOne
	private Poslovi idPosla;
	@JoinColumn(name = "id_radnika", referencedColumnName = "id_radnika")
	@ManyToOne
	private Radnik idRadnika;
	@Column(name = "ocena")
	private Integer ocena;
	
}