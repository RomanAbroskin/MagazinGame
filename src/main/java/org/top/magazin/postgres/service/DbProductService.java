package org.top.magazin.postgres.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.top.magazin.entity.Client;
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
    public String productListOptions(Optional<Client> optionalClient, Model model) {
        if(optionalClient.isPresent()) {
            Client client = optionalClient.get();
            var products = productRepository.findAll();
            var productBasket = client.getBasket();
            model.addAttribute("productBasket", productBasket);
            model.addAttribute("products", products);
            return "product/product-list";
        }return "Нет клиента";
    }
    @Override
    public String detailsProductOptions(Integer id, Model model) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "product/product-details";
        }
        return "redirect:/product";
    }
    @Override
    public String updateProductOptions(Integer id, Model model) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product);
            return "product/product-update-form";
        }
        return "redirect:/product";
    }
    @Override
    public Product register(Product product) {
        var now = new Date(System.currentTimeMillis());
        product.setDate(now);
        return productRepository.save(product);
    }
    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
