package org.top.magazin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.top.magazin.entity.Client;
import org.top.magazin.service.ClientService;

import java.util.Optional;

@Controller
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("")
    public String clientList(Model model){
        Iterable<Client> clients = clientService.getAll();
        model.addAttribute("clients", clients);
        return "client/client-list";
    }
    @GetMapping("delete/{id}")
    public String deleteClient(@PathVariable Integer id){
        clientService.deleteById(id);
        return "redirect:/client";
    }
}