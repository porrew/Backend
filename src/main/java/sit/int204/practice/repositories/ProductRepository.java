package sit.int204.practice.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sit.int204.practice.models.Brand;
import sit.int204.practice.models.Product;

public interface ProductRepository extends JpaRepository<Product , Long> {
//	public List<Product> findByBrandId(Long Brand);
}
