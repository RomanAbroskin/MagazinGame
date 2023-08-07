package org.top.magazin.postgres;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.top.magazin.entity.Product;
import org.top.magazin.postgres.repository.ProductRepository;
import org.top.magazin.service.ProductService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product register(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
      productRepository.deleteById(id);
    }

    @Override
    public Product update(Product product) {
        return null;
    }
}
