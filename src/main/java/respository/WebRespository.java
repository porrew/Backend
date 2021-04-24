package respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Webmodel;

public interface WebRespository extends JpaRepository<Webmodel, Long> {
	List<Webmodel> findByPublished(boolean published);
	List<Webmodel> findByTitleContaining(String title);
	
	
}