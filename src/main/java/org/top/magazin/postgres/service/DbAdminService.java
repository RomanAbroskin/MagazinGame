package org.top.magazin.postgres.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.top.magazin.entity.Admin;
import org.top.magazin.postgres.repository.AdminRepository;
import org.top.magazin.service.AdminService;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbAdminService implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    public Admin register(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Iterable<Admin> getAll() {
        var admins = adminRepository.findAll();
        if (admins.iterator().hasNext()){
            return admins;
        }
        return null;
    }
}
