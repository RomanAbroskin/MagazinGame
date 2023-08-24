package org.top.magazin.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.magazin.entity.Product;
import org.top.magazin.service.ProductService;

import java.util.Optional;

@Controller
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

   private final ProductService productService;

   @GetMapping("")
   public String productList (Model model){
      var products = productService.getAll();
      model.addAttribute("products",products);
      return "product/product-list";
   }

   @GetMapping("new")
   public String newProduct(Model model) {
      Product newProduct = new Product();
      model.addAttribute("newProduct", newProduct);
      return "product/product-add-form";
   }

   @PostMapping("new")
   public String newProduct(Product newProduct, RedirectAttributes ra) {
      Product product = productService.register(newProduct);
      ra.addFlashAttribute("newProduct", product);
      return "redirect:/product";
   }

   @GetMapping("delete/{id}")
   public String deleteProduct(@PathVariable Integer id) {
      productService.deleteById(id);
      return "redirect:/product";
   }
   @GetMapping("details/{id}")
   public String detailsProduct(@PathVariable Integer id, Model model) {
      Optional<Product> product = productService.getById(id);
      if (product.isPresent()) {
         model.addAttribute("product", product.get());
         return "product/product-details";
      }
      return "redirect:/product";
   }
   @GetMapping("update/{id}")
   public String updateProduct(@PathVariable Integer id, Model model) {
      Optional<Product> product = productService.getById(id);
      if (product.isPresent()) {
         model.addAttribute("product", product);
         return "product/product-update-form";
      }
      return "redirect:/product";
   }

   @PostMapping("update")
   public String updateProduct(Product updatedProduct, RedirectAttributes ra) {
      Product product = productService.register(updatedProduct);
      ra.addFlashAttribute("updateProduct", product);
      return "redirect:/product";
   }

}
