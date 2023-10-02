package org.top.magazin.service;

import org.springframework.stereotype.Service;
import org.top.magazin.entity.Client;

import java.util.Optional;

@Service
public interface ClientService {
    Iterable<Client> getAll();
    void deleteById(Integer id);
    Optional<Client> getByLogin(String username);
}
