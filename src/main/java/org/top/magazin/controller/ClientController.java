package org.top.magazin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.magazin.entity.Client;
import org.top.magazin.service.ClientService;
import org.top.magazin.service.ProductService;

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

    @GetMapping("new")
    public String newClient(Model model){
        Client newClient= new Client();
        model.addAttribute("newClient", newClient);
        return "client/client-add-form";
    }

    @PostMapping("new")
    public  String newClient(Client newClient, RedirectAttributes ra){
        Client client = clientService.register(newClient);
        ra.addFlashAttribute("newClient", client);
        return "redirect:/client";
    }

    @GetMapping("delete/{id}")
    public String deleteClient(@PathVariable Integer id){
        clientService.deleteById(id);
        return "redirect:/client";
    }

    @GetMapping("details/{id}")
    public String detailsClient(@PathVariable Integer id, Model model){
        Optional<Client> client = clientService.getById(id);
        if(client.isPresent()) {
            model.addAttribute("client", client.get());
            return "client/client-details";
        }else {
            return "redirect:/client";
        }
    }
    @GetMapping("update/{id}")
    public String updateClient( @PathVariable Integer id, Model model) {
        Optional<Client> client = clientService.getById(id);
        if (client.isPresent()) {
            model.addAttribute("client", client);
            return "client/client-update-form";
        }
        return "redirect:/client";
    }

    @PostMapping("update")
    public String updateClient(Client updateClient, RedirectAttributes ra){
        Client client = clientService.register(updateClient);
        ra.addFlashAttribute("updateClient", client);
        return "redirect:/client";
    }
}