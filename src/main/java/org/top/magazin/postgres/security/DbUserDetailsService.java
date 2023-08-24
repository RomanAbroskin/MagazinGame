package org.top.magazin.postgres.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.top.magazin.entity.Client;
import org.top.magazin.postgres.repository.ClientRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbUserDetailsService implements UserDetailsService {

    private final  ClientRepository clientRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Optional <Client> client = clientRepository.findByLogin(username);

      if(client.isEmpty()){
          throw new UsernameNotFoundException(username);
      }
        DbUserDetails userDetails=new DbUserDetails();
        userDetails.setClient(client.get());
        return userDetails;
    }
}
