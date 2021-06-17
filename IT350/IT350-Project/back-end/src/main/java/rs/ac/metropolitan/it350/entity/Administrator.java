package rs.ac.metropolitan.it350.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "administrator")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Administrator extends Auditable {
	@JoinColumn(name = "id_korisnika", referencedColumnName = "id_korisnika")
	@ManyToOne
	private Korisnik idKorisnika;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_administartora")
	private Integer id;
	
}