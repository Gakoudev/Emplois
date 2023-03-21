package com.groupeisi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CV implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String age;
    
    @Column(nullable = false)
    private String adresse;
    
    @Column(nullable = false)
    private String telephone;
    
    @Column(nullable = false)
    private String specialite;
    
    @Column(nullable = false)
    private String niveauEetude;
    
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String experienceProfessionnelle;

	@ManyToOne
	@JoinColumn(name="Compte_ID")
	private Compte compte =new Compte();

	public CV() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getNiveauEetude() {
		return niveauEetude;
	}

	public void setNiveauEetude(String niveauEetude) {
		this.niveauEetude = niveauEetude;
	}

	public String getExperienceProfessionnelle() {
		return experienceProfessionnelle;
	}

	public void setExperienceProfessionnelle(String experienceProfessionnelle) {
		this.experienceProfessionnelle = experienceProfessionnelle;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
