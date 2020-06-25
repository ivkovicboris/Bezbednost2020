//package com.example.bezbednost.model;
//
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import org.springframework.security.core.GrantedAuthority;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.Set;
//
//@SuppressWarnings("unused")
//@Entity
//
//public class Authority {
//
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;
//
//    @Column(name = "name")
//    private String name;     // ADMIN, USER...
//
//    @ManyToMany(mappedBy = "authorities")
//    private Collection<User> users;
//
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(
//        name = "authorities_permissions",
//        joinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"),
//        inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
//    private Set<Permission> permissions;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Collection<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Collection<User> users) {
//		this.users = users;
//	}
//
//	public Set<Permission> getPermissions() {
//		return permissions;
//	}
//
//	public void setPermissions(Set<Permission> permissions) {
//		this.permissions = permissions;
//	}
//
//    
//    
//    
//}
//
