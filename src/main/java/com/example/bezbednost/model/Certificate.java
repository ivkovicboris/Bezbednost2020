package com.example.bezbednost.model;


import java.security.PublicKey;
import java.util.Date;

import org.bouncycastle.asn1.x500.X500Name;

public class Certificate {
	
	private Long id;
	
	private X500Name naziv;
	private Long nadSertifikatId;
	private PublicKey publicKey;
	
	private Date datumIzdavanja;
	private Date datumIsteka;
	private boolean revoked;
	private boolean root;
	private boolean authority;
	private CertificateType tip;
	
	private String nazivOrganizacije;	
	
	public Certificate() {
		super();
	}

	public Certificate(Long id, Long nadSertifikatId, Date datumIzdavanja,
			Date datumIsteka, boolean revoked, boolean root, boolean authority, CertificateType tip, String nazivOrganizacije) {
		this.id = id;
		this.nadSertifikatId = nadSertifikatId;
		this.publicKey = publicKey;
		this.datumIzdavanja = datumIzdavanja;
		this.datumIsteka = datumIsteka;
		this.revoked = revoked;
		this.root = root;
		this.authority = authority;
		this.tip = tip;
		this.nazivOrganizacije = nazivOrganizacije;
	}

	public String getNazivOrganizacije() {
		return nazivOrganizacije;
	}

	public void setNazivOrganizacije(String nazivOrganizacije) {
		this.nazivOrganizacije = nazivOrganizacije;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public X500Name getNaziv() {
		return naziv;
	}

	public void setNaziv(X500Name naziv) {
		this.naziv = naziv;
	}

	public Long getNadSertifikatId() {
		return nadSertifikatId;
	}

	public void setNadSertifikatId(Long nadSertifikatId) {
		this.nadSertifikatId = nadSertifikatId;
	}

	public PublicKey getPublicKey() {
		return publicKey;
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
}
