package com.example.bezbednost.dbModel;
import java.security.PublicKey;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.example.bezbednost.model.Certificate;
import com.example.bezbednost.model.CertificateType;

@Entity
@Table(name="sertifikati")
public class CertificateDB {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "nazivOrganizacije", nullable = false)
	private String nazivOrganizacije;
	
	@Column(name = "nadSertifikatId", nullable = true)
	private Long nadSertifikatId;
	
	@Column(name = "datumIzdavanja", nullable = false)
	private Date datumIzdavanja;
	
	@Column(name = "datumIsteka", nullable = false)
	private Date datumIsteka;
	
	@Column(name = "povucen")
	private boolean revoked;
	
	@Column(name = "korenski")
	private boolean root;
	
	@Column(name = "dozvolaZaIzdavanje")
	private boolean authority;
	
	@Column(name = "tip")
	private CertificateType tip;
	
	@Column(name = "javniKljuc", length=1000)
	private byte[] publicKey;
	
	public CertificateDB() {
		
	}

	public CertificateDB(Long nadSertifikatId, Date datumIzdavanja, Date datumIsteka, boolean revoked,
			boolean root, boolean authority, CertificateType tip, String nazivOrganizacije,  byte[] publicKey) {
		this.nadSertifikatId = nadSertifikatId;
		this.datumIzdavanja = datumIzdavanja;
		this.datumIsteka = datumIsteka;
		this.revoked = revoked;
		this.root = root;
		this.authority = authority;
		this.tip = tip;
		this.nazivOrganizacije = nazivOrganizacije;
		this.publicKey = publicKey;
	}
	
	public CertificateDB(Certificate c, Long nadSertifikatId) {
		this.nadSertifikatId = nadSertifikatId;
		this.datumIzdavanja = c.getDatumIzdavanja();
		this.datumIsteka = c.getDatumIsteka();
		this.revoked = c.isRevoked();
		this.root = c.isRoot();
		this.authority = c.isAuthority();
		this.tip = c.getTip();
		this.nazivOrganizacije = c.getNazivOrganizacije();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazivOrganizacije() {
		return nazivOrganizacije;
	}

	public void setNazivOrganizacije(String nazivOrganizacije) {
		this.nazivOrganizacije = nazivOrganizacije;
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

	public  byte[] getPublicKey() {
		return publicKey;
	}

	public void setPublicKey( byte[] publicKey) {
		this.publicKey = publicKey;
	}
	
}
