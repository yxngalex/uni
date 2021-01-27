package rs.ac.metropolitan.it350.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "fajlovi")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Fajlovi extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_fajla")
	private Integer id;
	@JoinColumn(name = "id_radnika", referencedColumnName = "id_radnika")
	@ManyToOne
	private Radnik idRadnika;
	@Column(name = "tip_fajla")
	private String tipFajla;
	
}