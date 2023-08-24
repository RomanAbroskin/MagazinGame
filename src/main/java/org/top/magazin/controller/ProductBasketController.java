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
import org.top.magazin.service.ProductBasketService;
import org.top.magazin.service.ProductService;

import java.util.Optional;

@Controller
@RequestMapping("beginning")
@RequiredArgsConstructor
public class ProductBasketController {

    private final ProductBasketService productBasketService;

    private final ProductService productService;

      //получить не купленные игры
      //получить игры пользователя


   @GetMapping("purchase/{id}")
   public String purchaseProduct(@PathVariable Integer id) {
       Optional<Product> All= (productService.getById(id));
      productBasketService.register(All.get()) ;
      return "redirect:/";
   }

    @GetMapping("")
    public String productBasketList (Model model){
        var products = productBasketService.getAll();
        model.addAttribute("products",products);
        return "client-product/client-basket-list";
    }

    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productBasketService.deleteById(id);
        return "redirect:/beginning";
    }
}
