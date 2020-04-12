package com.example.bezbednost.service;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.security.cert.X509Certificate;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.bezbednost.dbModel.CertificateDB;



public class OCSPService {
	
	@Autowired
	CertificateDBService service;
	
	 private boolean checkDate(CertificateDB certificate, Date date){
		 LocalDate date1 = LocalDate.now(); 
		 if(certificate == null){
	            return false;
	        }
	        if( certificate.getDatumIsteka().after(convertToDateViaInstant(date1)))
				return true;
	        else {
				return false;
			}
	 }
	 
	 public Date convertToDateViaInstant(LocalDate dateToConvert) {
		    return java.util.Date.from(dateToConvert.atStartOfDay()
		      .atZone(ZoneId.systemDefault())
		      .toInstant());
	}
	 
	 public String check(CertificateDB certificate, CertificateDB issuerCert) throws NullPointerException {
	        if (certificate.isRevoked()){
	            return "REVOKED";
	        }
	        else {
	            return "GOOD";
	        }
	 }
	 
	 public Boolean checkCertificateValidity(CertificateDB certificate) throws NullPointerException {
		    CertificateDB parentCertificate = service.findOne(certificate.getNadSertifikatId());
	        String certStatus;
	        try {
	            certStatus = check(certificate, parentCertificate);
	        }catch (NullPointerException e){
	            System.out.println("Sertifikati imaju NULL vrednost.");
	            return false;
	        }

	        if (checkDate(certificate, certificate.getDatumIsteka())) {
	                if (certStatus.equals("GOOD")) {
	                    if(certificate.equals(parentCertificate)){
	                        // sertifikat je validan
	                        return true;
	                    }
	                    else{
	                        // ako nije root, proveravaj sad njega
	                       checkCertificateValidity(parentCertificate);
	                    }
	                }
	        }

	        return false;
	    }
	 
	 
	        
}
