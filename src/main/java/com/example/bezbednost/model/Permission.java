package com.example.bezbednost.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
public class Permission implements GrantedAuthority {
	private static final long serialVersionUID = 7338922787968631932L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name") private String name;

//    @ManyToMany(mappedBy = "permissions")
//    private List<UserRole> userRole;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
       name = "authorities_permissions",
       joinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"),
       inverseJoinColumns = @JoinColumn(name = "user_roles_id", referencedColumnName = "id"))    
	private List<UserRole> roles;


    @Override
    public String getAuthority() {
        return name;
    }

}