package io.github.camilacamiis.Client.model.repository;

import io.github.camilacamiis.Client.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
