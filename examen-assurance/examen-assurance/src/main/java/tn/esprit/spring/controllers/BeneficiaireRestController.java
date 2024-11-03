package tn.esprit.spring.controllers;

import java.util.Set;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Assurance;
import tn.esprit.spring.entities.Beneficiaire;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.TypeContrat;
import tn.esprit.spring.services.IBeneficiaireServices;

@Tag(name = "Examen Assurance")
@RestController
@AllArgsConstructor
@RequestMapping("/benefciaire")
public class BeneficiaireRestController {

	IBeneficiaireServices benefServices;
	
	@PostMapping("/addBenef")
	public Beneficiaire addBeneficiaire(@RequestBody Beneficiaire beneficiaire)
	{
		
		return benefServices.ajouterBeneficaire(beneficiaire);
	}

	@PostMapping("/addContrat")
	public Contrat addContrat(@RequestBody Contrat contrat)
	{

		return benefServices.ajouterContrat(contrat);
	}

	@PostMapping("/addAssurance/{cin-benef}/{matricule}")
	public Assurance addAssurance(@RequestBody Assurance assurance, @PathVariable("cin-benef") int cinB, @PathVariable("matricule") String matricule)
	{
		return benefServices.ajouterAssurance(assurance, cinB, matricule);
	}

	@GetMapping("/getContratBf/{id-benef}")
	public Contrat getContratByBf(@PathVariable("id-benef")int idBf)
	{
		return benefServices.getContratBf(idBf);
	}
	
	@GetMapping("/getMontantBf/{cin-benef}")
	public float getMontantBf(@PathVariable("cin-benef") int cinBf)
	{
		return benefServices.getMontantBf(cinBf);
	}

	@GetMapping("/getBeneficairesAsC/{typeC}")
	public Set<Beneficiaire> getBeneficairesAsC(@PathVariable("typeC")TypeContrat tc)
	{
		return benefServices.getBeneficairesAsC(tc);
	}

}
