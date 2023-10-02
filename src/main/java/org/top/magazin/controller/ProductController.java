package org.top.magazin.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.magazin.entity.Client;
import org.top.magazin.entity.Product;
import org.top.magazin.service.ClientService;
import org.top.magazin.service.ProductService;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Optional;

@Controller
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

   private final ProductService productService;
   private final ClientService clientService;

   @GetMapping("")
   public String productList (Model model, Authentication authentication){
      UserDetails userDetails = (UserDetails) authentication.getPrincipal();
      Optional<Client> client = clientService.getByLogin(userDetails.getUsername());
      return productService.productListOptions(client,model);
   }

   @GetMapping("new")
   public String newProduct(Model model) {
      Product newProduct = new Product();
      model.addAttribute("newProduct", newProduct);
      return "product/product-add-form";
   }

   @GetMapping("byu")
   public String buy () {
      return "redirect:/product";
   }

   @PostMapping("new")
   public String newProduct(Product newProduct, @RequestParam("previewImage") MultipartFile previewImage ,RedirectAttributes ra) throws IOException {
      String imageDataAsString = Base64
              .getEncoder()
              .encodeToString(
                      previewImage.getBytes()
              );
      newProduct.setPreviewImageG(imageDataAsString);
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
    return productService.detailsProductOptions(id,model);
   }
   @GetMapping("update/{id}")
   public String updateProduct(@PathVariable Integer id, Model model) {
      return productService.updateProductOptions(id,model);
   }

   @PostMapping("update")
   public String updateProduct(Product updatedProduct, @RequestParam("previewImag") MultipartFile previewImag, RedirectAttributes ra) throws IOException {
      String imageDataAsString = Base64
              .getEncoder()
              .encodeToString(
                      previewImag.getBytes()
              );
      updatedProduct.setPreviewImageG(imageDataAsString);
      Product product = productService.register(updatedProduct);
      ra.addFlashAttribute("updateProduct", product);
      return "redirect:/product";
   }

}
