package com.jhf.ecommerce.products;

import com.jhf.ecommerce.Productvariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariantRepository extends JpaRepository<Productvariant, Integer> {
}
