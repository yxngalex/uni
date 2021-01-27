package rs.ac.metropolitan.it350.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "poslodavac")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Poslodavac extends Auditable {
	@JoinColumn(name = "id_korisnika", referencedColumnName = "id_korisnika")
	@ManyToOne
	private Korisnik idKorisnika;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_poslodavca")
	private Integer id;
	@JoinColumn(name = "id_poruke", referencedColumnName = "id_poruke")
	@ManyToOne
	private Poruka idPoruke;
	
}