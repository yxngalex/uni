package rs.ac.metropolitan.it350.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "poslovi")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Poslovi extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_posla")
	private Integer id;
	@JoinColumn(name = "id_poslodavca", referencedColumnName = "id_poslodavca")
	@ManyToOne
	private Poslodavac idPoslodavca;
	@Column(name = "naziv")
	private String naziv;
	@Column(name = "opis")
	private String opis;
	@Column(name = "maks_budzet")
	private Double maksBudzet;
	@Column(name = "duzina_trajanja")
	private LocalDateTime duzinaTrajanja;
	@Column(name = "broj_potrebnih_radnika")
	private Integer brojPotrebnihRadnika;
	@Column(name = "kljucna_rec")
	private String kljucnaRec;
	
}