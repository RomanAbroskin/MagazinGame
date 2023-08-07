package org.top.magazin.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.top.magazin.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
