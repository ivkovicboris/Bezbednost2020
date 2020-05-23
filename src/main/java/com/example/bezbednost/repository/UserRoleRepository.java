package com.example.bezbednost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bezbednost.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

	UserRole findByName(String name);
}
