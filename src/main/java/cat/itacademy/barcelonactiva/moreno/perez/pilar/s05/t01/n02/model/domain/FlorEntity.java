package cat.itacademy.barcelonactiva.moreno.perez.pilar.s05.t01.n02.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "flors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pk_FlorID;
	
	@Column(name = "nom_flor")
	private String nomFlor;
	
	@Column(name = "pais_flor")
	private String paisFlor;

}
