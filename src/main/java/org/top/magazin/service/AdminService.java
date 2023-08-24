package org.top.magazin.service;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    Admin register(Admin admin);
    Iterable<Admin> getAll();
}
