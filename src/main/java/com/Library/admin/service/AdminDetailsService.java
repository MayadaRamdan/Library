package com.Library.admin.service;

import com.Library.admin.entity.Admin;
import com.Library.admin.repo.AdminRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminDetailsService implements UserDetailsService {



  private final AdminRepo repo;

  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    final Optional<Admin> adminOpt = this.repo.findByName(username);
    if (adminOpt.isEmpty()) {
      throw new UsernameNotFoundException("Unknown user " + username);
    }

    Admin admin = adminOpt.get();
    return User.withUsername(admin.getName())
            .password(admin.getPassword())
            .authorities("ROLE_USER")
            .accountExpired(false)
            .accountLocked(false)
            .credentialsExpired(false)
            .disabled(false)
            .build();
  }



}
