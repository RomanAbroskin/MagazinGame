package org.top.magazin.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.top.magazin.entity.Client;
import org.top.magazin.entity.Product;

import java.util.Optional;

@Service
public interface ProductService {

    String productListOptions(Optional<Client> optionalClient, Model model);
    String detailsProductOptions(@PathVariable Integer id, Model model);
    String updateProductOptions(@PathVariable Integer id, Model model);
    Product register(Product product);
    void deleteById(Integer id);

}
