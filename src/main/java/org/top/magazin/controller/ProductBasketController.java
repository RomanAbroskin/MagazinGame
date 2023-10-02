package org.top.magazin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import org.top.magazin.entity.Client;
import org.top.magazin.service.ClientService;
import org.top.magazin.service.ProductBasketService;

import java.util.Optional;

@Controller
@RequestMapping("beginning")
@RequiredArgsConstructor
public class ProductBasketController {

    private final ClientService clientService;

    private final ProductBasketService productBasketService;

   @GetMapping("purchase/{id}")
   public String purchaseProduct(@PathVariable Integer id, Authentication authentication) {
       UserDetails userDetails = (UserDetails) authentication.getPrincipal();
       Optional<Client> client = clientService.getByLogin(userDetails.getUsername());
       return productBasketService.purchase(id,client);
   }
    @GetMapping("")
    public String productBasketList (Model model, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<Client> client = clientService.getByLogin(userDetails.getUsername());
        return productBasketService.listSum(client,model);
    }
    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable Integer id, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<Client> client = clientService.getByLogin(userDetails.getUsername());
         return productBasketService.deleteFromBasket(client,id);
    }
    @GetMapping("delete/buy")
    public String deleteBuy(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Optional<Client> client = clientService.getByLogin(userDetails.getUsername());
        return productBasketService.buy(client);
   }
}
