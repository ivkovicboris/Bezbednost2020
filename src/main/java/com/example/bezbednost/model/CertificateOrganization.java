package com.example.bezbednost.model;

import com.example.bezbednost.dto.CertificateDTO;

public class CertificateOrganization extends Certificate{
	
	private String drzava;
	private String nazivOrganizacije;
	private String ptt;
	private String adresa;
	
	public CertificateOrganization() {
		super();
	}
	
	public CertificateOrganization(String drzava, String nazivOrganizacije, String ptt, String adresa) {
		super();
		this.drzava = drzava;
		this.nazivOrganizacije = nazivOrganizacije;
		this.ptt = ptt;
		this.adresa = adresa;
	}
	
	public CertificateOrganization(CertificateDTO c) {
		super(c.getId(), c.getNadSertifikatId(), c.getDatumIzdavanja(), c.getDatumIsteka(), c.isRevoked(), c.isRoot(), c.isAuthority(), c.getTip(), c.getNazivOrganizacije());
		this.drzava = c.getDrzava();
		this.nazivOrganizacije = c.getNazivOrganizacije();
		this.ptt = c.getPtt();
		this.adresa = c.getAdresa();
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
