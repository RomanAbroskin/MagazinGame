package org.top.magazin.postgres.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.top.magazin.entity.Client;
import org.top.magazin.entity.Product;
import org.top.magazin.postgres.repository.ClientRepository;
import org.top.magazin.postgres.repository.ProductRepository;
import org.top.magazin.service.ProductBasketService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbProductBasketService implements ProductBasketService {

    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;

    @Override
    public String deleteFromBasket(Optional<Client> optionalClient, int id) {
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            if (productRepository.findById(id).isPresent()) {
                client.getBasket().remove(productRepository.findById(id).get());
                clientRepository.save(client);
                return "redirect:/beginning";
            } else {
                return "Не найден продукт";
            }
        } else {
            return "Не найден клиент";
        }
    }
    @Override
    public String buy(Optional<Client> optionalClient) {
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.getBasket().clear();
            clientRepository.save(client);
            return "redirect:/beginning";
        }
        return "Не найден клиент";
    }
    @Override
    public String listSum(Optional<Client> optionalClient, Model model) {
        if(optionalClient.isPresent()){
            Client client=optionalClient.get();
        var products = client.getBasket();
        double sum=0;
        for(Product product:products){
            if(product.getPrice()!=null) {
                sum += product.getPrice();
            }
        }
        model.addAttribute("sum",sum);
        model.addAttribute("products",products);
        return "client-product/client-basket-list";
    } else {
        return "Не найден клиент";
        }
    }
    @Override
    public String purchase(Integer id, Optional<Client> optionalClient) {
        if(optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.getBasket().add(productRepository.getById(id));
            clientRepository.save(client);
        }
        return "redirect:/product";
    }

}

