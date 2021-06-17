package rs.ac.metropolitan.it350.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "poruka")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Poruka extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_poruke")
	private Integer id;
	@Column(name = "poruka")
	private String poruka;
	
}