package com.example.bezbednost.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bezbednost.dbModel.CertificateDB;

@Repository
public interface CertificateDBRepository extends JpaRepository<CertificateDB, Long>{
	
	CertificateDB findOneById(Long id);
	List<CertificateDB> findAll();
	
}


