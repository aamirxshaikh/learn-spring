package com.demo.Controller;

import com.demo.Service.ProductService;
import com.demo.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ecommerce")
public class ECommerceController {
    @Autowired
    ProductService productService;

    @Autowired
    StoreService storeService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getProducts());

        return "products";
    }

    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public String getStores(Model model) {
        model.addAttribute("stores", storeService.getStores());

        return "stores";
    }
}
