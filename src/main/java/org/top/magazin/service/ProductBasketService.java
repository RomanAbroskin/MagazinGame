package org.top.magazin.service;

import org.top.magazin.entity.Product;

import java.util.Optional;

public interface ProductBasketService {
    Iterable<Product> getAll();
    Optional<Product> getById(Integer id);
    void deleteById(Integer id);

    Product register(Product product);

}
