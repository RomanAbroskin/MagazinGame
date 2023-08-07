package org.top.magazin.service;

import org.springframework.stereotype.Service;
import org.top.magazin.entity.Product;

import java.util.Optional;

@Service
public interface ProductService {

    Product register(Product product);  // регистрация товара
    Optional<Product> getById(Integer id);     // получить товара по id
    Iterable<Product> getAll();      // получить все товары
    void deleteById(Integer id); // удалить товар
    Product update (Product product); // обновить поля товара
}
