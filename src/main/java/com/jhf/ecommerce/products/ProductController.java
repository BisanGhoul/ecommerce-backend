package com.jhf.ecommerce.products;

import com.jhf.ecommerce.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // Endpoint to get all products with variants
    @GetMapping("/products")
    public List<Product> getAllProductsWithVariants() {
        return productService.getAllProductsWithVariants();
    }
}
