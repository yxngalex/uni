package rs.ac.metropolitan.it350.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "zarada")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Zarada extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_zarade")
	private Integer id;
	@JoinColumn(name = "id_radnika", referencedColumnName = "id_radnika")
	@ManyToOne
	private Radnik idRadnika;
	@Column(name = "vrednost")
	private Double vrednost;
	@Column(name = "mesec")
	private LocalDate mesec;
	
}