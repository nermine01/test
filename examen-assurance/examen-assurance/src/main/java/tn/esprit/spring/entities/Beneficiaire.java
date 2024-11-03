package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Beneficiaire {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBeneficiaire;

	private int cin;
	private String nom;
	private String prenom;
	private String profession;
	private float salaire;


	@OneToMany(mappedBy="beneficiaire", fetch=FetchType.EAGER)
	@JsonIgnore
	@ToString.Exclude
	private Set<Assurance> assurances = new HashSet<Assurance>();
	
}
