package rs.ac.metropolitan.it350.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "korisnik")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Korisnik extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_korisnika")
	private Integer id;
	@Column(name = "ime")
	private String ime;
	@Column(name = "prezime")
	private String prezime;
	@Column(name = "godine")
	private String godine;
	
}