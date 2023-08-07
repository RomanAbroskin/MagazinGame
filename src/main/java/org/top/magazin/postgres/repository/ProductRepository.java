package org.top.magazin.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.top.magazin.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
