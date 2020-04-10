package com.example.bezbednost.model;

import com.example.bezbednost.dto.CertificateDTO;

public class CertificateRoot extends Certificate{
	
	public CertificateRoot() {
		super();
	}
	
	public CertificateRoot(CertificateDTO c) {
		super(c.getId(), c.getNadSertifikatId(), c.getDatumIzdavanja(), c.getDatumIsteka(), c.isRevoked(), c.isRoot(), c.isAuthority(), c.getTip(), c.getNazivOrganizacije());
	}
}
