package org.top.magazin.service;

import org.springframework.stereotype.Service;
import org.top.magazin.entity.Admin;

import java.util.Optional;

@Service
public interface AdminService {

    Admin register(Admin admin);  // регистрация клиента
    Optional<Admin> getById(Integer id);     // получить клиента по id
    Iterable<Admin> getAll();      // получить всех клиентов
    void deleteById(Integer id); // удалить клиента
    Admin update (Admin admin);
}
