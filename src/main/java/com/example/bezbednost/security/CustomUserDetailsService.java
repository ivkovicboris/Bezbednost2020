package com.example.bezbednost.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bezbednost.model.User;
import com.example.bezbednost.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	//protected final Logger logger = LogManager.getLogger(DokumentiApplication.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    //Funkcija koja na osnovu username-a iz baze vraca objekat User-a
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findOneByEmail(email);
        if (user == null) {
        	//logger.info("Could not find user with email '" + email + "'");
            throw new UsernameNotFoundException(String.format("No user found with email '%s'.", email));
        } else {
            return (UserDetails) user;
        }
    }

    //Funkcija pomocu koje korisnik menja svoju lozinku
    public void changePassword(String oldPassword, String newPassword) {

        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        String username = currentUser.getName();

        if (authenticationManager != null) {
        	//logger.debug("Re-authenticating user '"+ username + "' for password change request.");

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
        } else {
        	//logger.debug("No authentication manager set. can't change Password!");

            return;
        }

        //logger.debug("Changing password for user '"+ username + "'");

        User user = (User) loadUserByUsername(username);

        //pre nego sto u bazu upisemo novu lozinku, potrebno ju je hesirati
        //ne zelimo da u bazi cuvamo lozinke u plain text formatu
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
}