package org.top.magazin.postgres.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.top.magazin.entity.Product;
import org.top.magazin.postgres.repository.ProductBasketRepository;
import org.top.magazin.service.ProductBasketService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbProductBasketService implements ProductBasketService {

    private final ProductBasketRepository productBasketRepository;

    @Override
    public Iterable<Product> getAll() {
        var productBasket = productBasketRepository.findAll();
        if (productBasket.iterator().hasNext()){
            return productBasket;
        }
        return null;
    }

    @Override
    public Optional<Product> getById(Integer id) {
        return productBasketRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        productBasketRepository.deleteById(id);
    }

    public Product register(Product product) {
        return productBasketRepository.save(product);
    }


}

