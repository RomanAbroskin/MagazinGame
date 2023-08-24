package org.top.magazin.service;

import org.springframework.stereotype.Service;
import org.top.magazin.entity.Admin;

import java.util.Optional;

@Service
public interface AdminService {

    Admin register(Admin admin);
    Iterable<Admin> getAll();
}
