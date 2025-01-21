package com.jhf.ecommerce.controller;

import com.jhf.ecommerce.DTO.ProductFilterDTO;
import com.jhf.ecommerce.model.Product;
import com.jhf.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/filter")
    public Page<Product> filterProducts(
            @RequestParam(required = false) String tag,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String productSize,
            @RequestParam int page,
            @RequestParam int size) {

        ProductFilterDTO filterDTO = new ProductFilterDTO();
        filterDTO.setTag(tag);
        filterDTO.setCategory(category);
        filterDTO.setMinPrice(minPrice);
        filterDTO.setMaxPrice(maxPrice);
        filterDTO.setColor(color);
        filterDTO.setSize(productSize);
//http://localhost:8080/products/filter?page=0&size=10&category=BOTTOMS&tag=Men&productSize=L&color=blue&minPrice=140&maxPrice=200
        return productService.getFilteredProducts(filterDTO, page, size);
    }
}
