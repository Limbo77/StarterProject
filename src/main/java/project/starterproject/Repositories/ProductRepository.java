package project.starterproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.starterproject.Models.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
