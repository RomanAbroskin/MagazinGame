package org.top.magazin.controller.develop;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.top.magazin.entity.Client;
import org.top.magazin.postgres.repository.ClientRepository;

@RestController
@RequestMapping("develop")
@RequiredArgsConstructor
public class DevelopController {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("create-admin")
    public String createAdmin() {
        String login = "admin";
        String password = "admin";
        password = passwordEncoder.encode(password);
        String role = "ADMIN";
        if (clientRepository.findByLogin(login).isPresent()) {
            return "администратор уже создан";
        }
        Client client = new Client();
        client.setLogin(login);
        client.setPassword(password);
        client.setRole(role);
        clientRepository.save(client);
        return "администратор успешно создан";
    }

    @GetMapping("create-user")
    public String createUser() {
        String login = "user";
        String password = "123456";
        password = passwordEncoder.encode(password);
        String role = "USER";
        if (clientRepository.findByLogin(login).isPresent()) {
            return "пользователь уже создан";
        }
        Client client = new Client();
        client.setLogin(login);
        client.setPassword(password);
        client.setRole(role);
        clientRepository.save(client);
        return "пользователь успешно создан";
    }
}
