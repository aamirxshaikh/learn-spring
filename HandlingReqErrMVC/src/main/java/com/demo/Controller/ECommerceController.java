package com.demo.Controller;

import com.demo.Service.ProductService;
import com.demo.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/products/{name}")
    public String getProduct(@PathVariable("name") String name, Model model) {
        String message = "Product : " + name;

        model.addAttribute("message", message);

        return "product";
    }

    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    public String getStores(Model model) {
        model.addAttribute("stores", storeService.getStores());

        return "stores";
    }

    @RequestMapping(value = "/stores/{name}")
    public String getStore(@PathVariable("name") String name, Model model) {
        String message = "Store : " + name;

        model.addAttribute("message", message);

        return "store";
    }
}
