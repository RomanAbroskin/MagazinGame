package org.top.magazin.service;

import org.springframework.ui.Model;
import org.top.magazin.entity.Client;
import java.util.Optional;

public interface ProductBasketService {

    String deleteFromBasket(Optional<Client> optionalClient, int id);
    String buy(Optional<Client> optionalClient);
    String listSum(Optional<Client> optionalClient, Model model);
    String purchase(Integer id, Optional<Client> optionalClient);
}
