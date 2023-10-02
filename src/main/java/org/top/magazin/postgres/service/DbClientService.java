package org.top.magazin.postgres.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.top.magazin.entity.Client;
import org.top.magazin.postgres.repository.ClientRepository;
import org.top.magazin.service.ClientService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbClientService implements ClientService {

    private final ClientRepository clientRepository;
    @Override
    public Iterable<Client> getAll() {
        var clients = clientRepository.findAll();
        if (clients.iterator().hasNext()){
            return clients;
        }
        return null;
    }
    @Override
    public void deleteById(Integer id) {
        clientRepository.deleteById(id);
    }
    @Override
    public Optional<Client> getByLogin(String username) {
        return clientRepository.findByLogin(username);
    }
}
