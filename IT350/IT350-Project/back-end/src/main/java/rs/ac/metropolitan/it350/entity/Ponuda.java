package rs.ac.metropolitan.it350.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ponuda")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Ponuda extends Auditable {
	@Column(name = "kratakopis")
	private String kratakopis;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_ponude")
	private Integer id;
	@JoinColumn(name = "id_posla", referencedColumnName = "id_posla")
	@ManyToOne
	private Poslovi idPosla;
	@Column(name = "predlozenacena")
	private Double predlozenacena;
	
}