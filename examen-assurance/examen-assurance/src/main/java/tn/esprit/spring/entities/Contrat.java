package tn.esprit.spring.entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Contrat {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idContrat;

	private String matricule ;
	@Temporal(TemporalType.DATE)
	private Date dateEffet ;

	@Enumerated(EnumType.STRING)
	private TypeContrat type;
}
