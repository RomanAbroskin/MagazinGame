package org.top.magazin.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.top.magazin.entity.PersonalAccount;

public interface PersonalAccountRepository extends JpaRepository<PersonalAccount,Integer> {
}
