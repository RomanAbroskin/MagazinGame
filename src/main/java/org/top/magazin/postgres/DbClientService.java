package org.top.magazin.postgres;

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
    public Client register(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> getById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public Iterable<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client update(Client client) {
        return null;
    }
}
