package com.example.bezbednost.dto;

import java.util.Date;


import com.example.bezbednost.dbModel.CertificateDB;
import com.example.bezbednost.model.Certificate;
import com.example.bezbednost.model.CertificateOrganization;
import com.example.bezbednost.model.CertificatePerson;
import com.example.bezbednost.model.CertificateType;

public class CertificateDTO {
	
	private Long id;
	
	//private X500Name naziv;
	private Long nadSertifikatId;
	//private PublicKey publicKey;
	private Date datumIzdavanja;
	private Date datumIsteka;
	private boolean revoked;
	private boolean root;
	private boolean authority;
	private CertificateType tip;
	private String nazivOrganizacije;
	
	//Root
	//...
	
	//Person
	private String ime;
	private String prezime;
	private String drzava;
	private String email;
	
	//Organization
	//private String drzava;
	private String ptt;
	private String adresa;
	
	
	public CertificateDTO() {
		
	}	
	
	public CertificateDTO(CertificateDB c) {
		this.id = c.getId();
		this.nazivOrganizacije = c.getNazivOrganizacije();
		this.nadSertifikatId = c.getNadSertifikatId();
		this.datumIzdavanja = c.getDatumIzdavanja();
		this.datumIsteka = c.getDatumIsteka();
		this.revoked = c.isRevoked();
		this.root = c.isRoot();
		this.authority = c.isAuthority();
		this.tip = c.getTip();	
	}

	public CertificateDTO(Certificate c) {
		this.id = c.getId();
		//this.publicKey = c.getPublicKey();
		this.datumIzdavanja = c.getDatumIzdavanja();
		this.datumIsteka = c.getDatumIsteka();
		this.revoked = c.isRevoked();
		this.root = c.isRoot();
		this.authority = c.isAuthority();
		this.tip = c.getTip();
		this.nazivOrganizacije = c.getNazivOrganizacije();
	}
	
	public CertificateDTO(CertificateOrganization c) {
		this.id = c.getId();
		//this.publicKey = c.getPublicKey();
		this.datumIzdavanja = c.getDatumIzdavanja();
		this.datumIsteka = c.getDatumIsteka();
		this.revoked = c.isRevoked();
		this.root = c.isRoot();
		this.authority = c.isAuthority();
		this.tip = c.getTip();
		this.ptt = c.getPtt();
		this.drzava = c.getDrzava();
		this.nazivOrganizacije = c.getNazivOrganizacije();
		this.adresa = c.getAdresa();
	}
	
	public CertificateDTO(CertificatePerson c) {
		this.id = c.getId();
		//this.publicKey = c.getPublicKey();
		this.datumIzdavanja = c.getDatumIzdavanja();
		this.datumIsteka = c.getDatumIsteka();
		this.revoked = c.isRevoked();
		this.root = c.isRoot();
		this.authority = c.isAuthority();
		this.tip = c.getTip();
		
		this.ime = c.getIme();
		this.prezime = c.getPrezime();
		this.drzava = c.getDrzava();
		this.nazivOrganizacije = c.getNazivOrganizacije();
		this.email = c.getEmail();
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNadSertifikatId() {
		return nadSertifikatId;
	}
	public void setNadSertifikatId(Long nadSertifikatId) {
		this.nadSertifikatId = nadSertifikatId;
	}
	public Date getDatumIzdavanja() {
		return datumIzdavanja;
	}
	public void setDatumIzdavanja(Date datumIzdavanja) {
		this.datumIzdavanja = datumIzdavanja;
	}
	public Date getDatumIsteka() {
		return datumIsteka;
	}
	public void setDatumIsteka(Date datumIsteka) {
		this.datumIsteka = datumIsteka;
	}
	public boolean isRevoked() {
		return revoked;
	}
	public void setRevoked(boolean revoked) {
		this.revoked = revoked;
	}

//	public X500Name getNaziv() {
//		return naziv;
//	}
//
//	public void setNaziv(X500Name naziv) {
//		this.naziv = naziv;
//	}

//	public PublicKey getPublicKey() {
//		return publicKey;
//	}
//
//	public void setPublicKey(PublicKey publicKey) {
//		this.publicKey = publicKey;
//	}

	public boolean isRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}

	public boolean isAuthority() {
		return authority;
	}

	public void setAuthority(boolean authority) {
		this.authority = authority;
	}

	public CertificateType getTip() {
		return tip;
	}

	public void setTip(CertificateType tip) {
		this.tip = tip;
	}

	public String getNazivOrganizacije() {
		return nazivOrganizacije;
	}

	public void setNazivOrganizacije(String nazivOrganizacije) {
		this.nazivOrganizacije = nazivOrganizacije;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPtt() {
		return ptt;
	}

	public void setPtt(String ptt) {
		this.ptt = ptt;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
}

