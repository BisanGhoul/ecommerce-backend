package com.jhf.ecommerce.products;

import com.jhf.ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductVariantRepository productVariantRepository;

    // Method to get all products along with their variants

    public List<Product> getAllProductsWithVariants() {
        List<Product> products = productRepository.findAll();
        products.forEach(product -> product.getProductvariants().size()); // Force fetch of variants
        return products;
    }
}
