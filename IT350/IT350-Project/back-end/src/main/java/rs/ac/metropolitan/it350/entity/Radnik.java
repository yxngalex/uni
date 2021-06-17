package rs.ac.metropolitan.it350.entity;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "radnik")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Radnik extends Auditable {
	@JoinColumn(name = "id_korisnika", referencedColumnName = "id_korisnika")
	@ManyToOne
	private Korisnik idKorisnika;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_radnika")
	private Integer id;
	@JoinColumn(name = "rad_id_radnika", referencedColumnName = "id_radnika")
	@ManyToOne
	private Radnik radIdRadnika;
	@JoinColumn(name = "id_ponude", referencedColumnName = "id_ponude")
	@ManyToOne
	private Ponuda idPonude;
	@JoinColumn(name = "id_posla", referencedColumnName = "id_posla")
	@ManyToOne
	private Poslovi idPosla;
	@JoinColumn(name = "id_poruke", referencedColumnName = "id_poruke")
	@ManyToOne
	private Poruka idPoruke;
	
}