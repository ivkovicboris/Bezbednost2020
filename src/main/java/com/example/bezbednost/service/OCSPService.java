package com.example.bezbednost.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.security.cert.X509Certificate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bezbednost.dbModel.CertificateDB;
import com.example.bezbednost.dto.CertificateDTO;
import com.example.bezbednost.model.CertificateType;



@Service
public class OCSPService {
	
	@Autowired
	CertificateDBService service;
	
	 private boolean checkDate(CertificateDTO certificate, Date date){
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
	 
	 private Date convertToDateViaInstant(LocalDate dateToConvert) {
		    return java.util.Date.from(dateToConvert.atStartOfDay()
		      .atZone(ZoneId.systemDefault())
		      .toInstant());
	}
	 
	 public String check(CertificateDTO certificate) {
	        if (certificate.isRevoked()){
	            return "REVOKED";
	        }
	        else {
	            return "GOOD";
	        }
	 }
	 
	 public Boolean checkCertificateValidity(CertificateDTO certificate) {
		    CertificateDB parentCertificate = service.findOne(certificate.getNadSertifikatId());
		    CertificateDTO parent = new CertificateDTO(parentCertificate);
	        String certStatus;
	        if(check(certificate)==null) {
	        	return false;
	        }
	        certStatus = check(parent);

	        if (checkDate(certificate, certificate.getDatumIsteka())) {
	                if (certStatus.equals("GOOD")) {
	                    if(certificate.getTip()==CertificateType.ROOT){
	                        // sertifikat je validan
	                        return true;
	                    }
	                    else{
	                        // ako nije root, proveravaj sad njega
	                       return checkCertificateValidity(parent);
	                    }
	                }
	        }

	        return false;
	 }
	 
	 
	        
}
