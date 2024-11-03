package tn.esprit.spring.entities;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Assurance {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idAssurance;

	private String designation;
	private float montant;

	@ManyToOne(cascade = CascadeType.ALL)
	private Contrat contrat;
	@ManyToOne(cascade = CascadeType.ALL)
	private Beneficiaire beneficiaire;

}
