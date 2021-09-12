package site.model;

import org.springframework.data.jpa.repository.JpaRepository;
import site.model.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
