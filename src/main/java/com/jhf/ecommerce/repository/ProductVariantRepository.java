package com.jhf.ecommerce.repository;

import com.jhf.ecommerce.model.Productvariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariantRepository extends JpaRepository<Productvariant, Integer> {
}
