package com.jhf.ecommerce.service;

import com.jhf.ecommerce.DTO.ProductFilterDTO;
import com.jhf.ecommerce.model.Product;
import com.jhf.ecommerce.repository.ProductVariantRepository;
import com.jhf.ecommerce.repository.ProductRepository;
import com.jhf.ecommerce.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getFilteredProducts(ProductFilterDTO filterDTO, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(ProductSpecification.applyFilters(filterDTO), pageable);
    }


}
