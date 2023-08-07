package org.top.magazin.postgres;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.top.magazin.entity.Admin;
import org.top.magazin.postgres.repository.AdminRepository;
import org.top.magazin.service.AdminService;

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
    public Optional<Admin> getById(Integer id) {
        return adminRepository.findById(id);
    }

    @Override
    public Iterable<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
       adminRepository.deleteById(id);
    }

    @Override
    public Admin update(Admin admin) {
        return null;
    }
}
