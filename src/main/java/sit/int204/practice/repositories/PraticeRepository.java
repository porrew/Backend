package sit.int204.practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sit.int204.practice.models.Pratice;

public interface PraticeRepository extends JpaRepository<Pratice, String>{
	
}
