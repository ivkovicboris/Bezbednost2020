package com.example.bezbednost.model;

import com.example.bezbednost.dto.CertificateDTO;

public class CertificatePerson extends Certificate{
	
	private String ime;
	private String prezime;
	private String drzava;
	private String nazivOrganizacije;
	private String email;
	
	public CertificatePerson() {
		
	}
	
	public CertificatePerson(String ime, String prezime, String drzava, String nazivOrganizacije, String email) {
		this.ime = ime;
		this.prezime = prezime;
		this.drzava = drzava;
		this.nazivOrganizacije = nazivOrganizacije;
		this.email = email;
	}
	
	public CertificatePerson(CertificateDTO c) {
		super(c.getId(), c.getNadSertifikatId(), c.getDatumIzdavanja(), c.getDatumIsteka(), c.isRevoked(), c.isRoot(), c.isAuthority(), c.getTip(), c.getNazivOrganizacije());
		this.ime = c.getIme();
		this.prezime = c.getPrezime();
		this.drzava = c.getDrzava();
		this.nazivOrganizacije = c.getNazivOrganizacije();
		this.email = c.getEmail();
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	public String getNazivOrganizacije() {
		return nazivOrganizacije;
	}
	public void setNazivOrganizacije(String nazivOrganizacije) {
		this.nazivOrganizacije = nazivOrganizacije;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
