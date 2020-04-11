package com.example.bezbednost.controller;

import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.cert.CertIOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bezbednost.data.IssuerData;
import com.example.bezbednost.data.SubjectData;
import com.example.bezbednost.dbModel.CertificateDB;
import com.example.bezbednost.dto.CertificateDTO;
import com.example.bezbednost.generate.CertificateGenerator;
import com.example.bezbednost.keystore.KeyStoreWriter;
import com.example.bezbednost.model.CertificateRoot;
import com.example.bezbednost.service.CertificateDBService;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


import java.util.Date;





@RestController
@RequestMapping(value="/Certificate")
public class CertificateController {
	
	@Autowired
	CertificateDBService service;
	
	@PostMapping(value="/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CertificateDTO> createCertificate (@RequestBody CertificateDTO cDTO) throws CertIOException{
		KeyStoreWriter keyStore = new KeyStoreWriter();
		Long id = Long.parseLong("0");
		switch(cDTO.getTip()){
			case ROOT:
				try {
					CertificateRoot c = new CertificateRoot(cDTO);
					//CertificateExample klasa
					//generateSubjectData
					// generisemo javni i privatni kljuc subjekta kojem izdajemo sertifikat
					// posto je u pitanju root, koji potpisuje sam sebe, taj privatni ce se koristiti
					// i kod issuer-a kako bi sertifikat bio samopotpisan
					KeyPair keyPairSubject = generateKeyPair(); 
					Date startDate = c.getDatumIzdavanja();
					Date endDate = c.getDatumIsteka();
					//Serijski broj sertifikata...kako generisati??
					String sn = Long.toString(System.currentTimeMillis());
					//Podaci o vlasniku
					X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);	
					builder.addRDN(BCStyle.CN, "localhost");
					builder.addRDN(BCStyle.OU, "a");
				    builder.addRDN(BCStyle.O, c.getNazivOrganizacije());
				    builder.addRDN(BCStyle.L, "a");
				    builder.addRDN(BCStyle.C, "US");
				    builder.addRDN(BCStyle.EmailAddress, "a@a.com");			    
				    
				    SubjectData subjectData = new SubjectData(keyPairSubject.getPublic(), builder.build(), sn, startDate, endDate);
					
				    //generateIssuerData
					X500NameBuilder builder1 = new X500NameBuilder(BCStyle.INSTANCE);
					builder1.addRDN(BCStyle.CN, "localhost");
					builder1.addRDN(BCStyle.OU, "a");
				    builder1.addRDN(BCStyle.O, c.getNazivOrganizacije());
				    builder1.addRDN(BCStyle.L, "a");
				    builder1.addRDN(BCStyle.C, "US");
				    builder1.addRDN(BCStyle.EmailAddress, "a@a.com");
				    IssuerData issuerData = new IssuerData(keyPairSubject.getPrivate(), builder1.build());
						
					//Generisanje sertifikata
				    CertificateGenerator cg = new CertificateGenerator();
				    X509Certificate cert = cg.generateCertificate(subjectData, issuerData);
				    
				    cert.verify(keyPairSubject.getPublic());
				   
				    
				    CertificateDB cDB = new CertificateDB(c, null);
				    cDB.setAuthority(true);
				    cDB.setRoot(true);
				    cDB.setPublicKey(keyPairSubject.getPublic().getEncoded());
				    cDB = service.save(cDB);
				    cDB.setNadSertifikatId(cDB.getId());
				    cDB = service.save(cDB);
				    id = cDB.getId();
				    
				    keyStore.write(cDB.getId().toString(), keyPairSubject.getPrivate(), "123456".toCharArray(), cert);
				    String nazivKeyStora = c.getNazivOrganizacije().concat(Long.toString(cDB.getId()));
				    keyStore.saveKeyStore(nazivKeyStora.concat(".jks"), "111".toCharArray()); 
				    
				}catch(CertificateException e) {
					e.printStackTrace();
				} catch (InvalidKeyException e) {
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (NoSuchProviderException e) {
					e.printStackTrace();
				} catch (SignatureException e) {
					e.printStackTrace();
				}
				
				break;
				
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	private KeyPair generateKeyPair() {
        try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA"); 
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
			keyGen.initialize(2048, random);
			return keyGen.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
        return null;
	}
	
		
	

}

