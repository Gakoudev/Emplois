package com.groupeisi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Annonce implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String titre;
    
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String description;
    
    @Column(nullable = false)
    private String localisation;
    
    @Column(nullable = false)
    private double salaire;
    
    @Column(nullable = false)
    private String dateLimite;
    
    
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String experience;
    
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String typeJob;

	@ManyToOne
	@JoinColumn(name="Entreprise_ID")
	private Entreprise entreprise =new Entreprise();

	@ManyToOne
	@JoinColumn(name="Domaine_ID")
	private Domaine domaine =new Domaine();

	public Annonce() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public String getDateLimite() {
		return dateLimite;
	}

	public void setDateLimite(String dateLimite2) {
		this.dateLimite = dateLimite2;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domain) {
		this.domaine = domain;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getTypeJob() {
		return typeJob;
	}

	public void setTypeJob(String typeJob) {
		this.typeJob = typeJob;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

}
