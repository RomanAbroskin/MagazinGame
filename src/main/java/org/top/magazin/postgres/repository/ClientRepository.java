package org.top.magazin.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.top.magazin.entity.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    Optional<Client> findByLogin(String login);
}
