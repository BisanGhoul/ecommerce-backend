package com.jhf.ecommerce.specification;

import com.jhf.ecommerce.DTO.ProductFilterDTO;
import com.jhf.ecommerce.model.*;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> filterByTag(String tagName) {
        return (root, query, criteriaBuilder) -> {
            Join<Product, Producttag> productTags = root.join("producttags");
            Join<Producttag, Tag> tag = productTags.join("tag");
            return criteriaBuilder.equal(tag.get("name"), tagName);
        };
    }

    public static Specification<Product> filterByCategory(String categoryName) {
        return (root, query, criteriaBuilder) -> {
            Join<Product, ProductCategory> productCategories = root.join("productCategories");
            Join<ProductCategory, Category> category = productCategories.join("category");
            return criteriaBuilder.equal(category.get("categoryName"), categoryName);
        };
    }
    public static Specification<Product> filterByPrice(Double minPrice, Double maxPrice) {
        return (root, query, criteriaBuilder) -> {
            // Create a join to the product variants
            Join<Product, Productvariant> productVariants = root.join("productvariants");

            // Check for price filters and apply accordingly
            if (minPrice != null && maxPrice != null) {
                return criteriaBuilder.between(productVariants.get("price"), minPrice, maxPrice);
            } else if (minPrice != null) {
                return criteriaBuilder.greaterThanOrEqualTo(productVariants.get("price"), minPrice);
            } else if (maxPrice != null) {
                return criteriaBuilder.lessThanOrEqualTo(productVariants.get("price"), maxPrice);
            }

            // Return a conjunction (no filtering) if no price filters are set
            return criteriaBuilder.conjunction();
        };
    }

    public static Specification<Product> filterByColor(String colorCode) {
        return (root, query, criteriaBuilder) -> {
            Join<Product, Productvariant> productVariants = root.join("productvariants");
            Join<Productvariant, Color> color = productVariants.join("color");
            return criteriaBuilder.equal(color.get("name"), colorCode);
        };
    }
    public static Specification<Product> filterBySize(String sizeCode) {
        return (root, query, criteriaBuilder) -> {
            Join<Product, Productvariant> productVariants = root.join("productvariants");
            Join<Productvariant, Size> size = productVariants.join("size");
            return criteriaBuilder.equal(size.get("code"), sizeCode);
        };


    }

    public static Specification<Product> applyFilters(ProductFilterDTO filterDTO) {
        Specification<Product> specification = Specification.where(null);  // Start with an empty specification

        if (filterDTO.getTag() != null && !filterDTO.getTag().isEmpty()) {
            specification = specification.and(filterByTag(filterDTO.getTag()));
        }

        if (filterDTO.getCategory() != null && !filterDTO.getCategory().isEmpty()) {
            specification = specification.and(filterByCategory(filterDTO.getCategory()));
        }

        if (filterDTO.getMinPrice() != null || filterDTO.getMaxPrice() != null) {
            specification = specification.and(filterByPrice(filterDTO.getMinPrice(), filterDTO.getMaxPrice()));
        }

        if (filterDTO.getColor() != null && !filterDTO.getColor().isEmpty()) {
            specification = specification.and(filterByColor(filterDTO.getColor()));
        }

        if (filterDTO.getSize() != null && !filterDTO.getSize().isEmpty()) {
            specification = specification.and(filterBySize(filterDTO.getSize()));
        }

        return specification;
    }

}
