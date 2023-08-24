package org.top.magazin.postgres.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.top.magazin.entity.Product;
import org.top.magazin.postgres.repository.ProductRepository;
import org.top.magazin.service.ProductService;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product register(Product product) {
            var now = new Date(System.currentTimeMillis());
            product.setDate(now);
            return productRepository.save(product);
    }

    @Override
    public Optional<Product> getById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Iterable<Product> getAll() {
        var products = productRepository.findAll();
        if (products.iterator().hasNext()){
            return products;
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
      productRepository.deleteById(id);
    }

}
