package sit.int204.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sit.int204.practice.models.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long>{
	
}
