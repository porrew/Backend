package sit.int204.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.practice.repositories.BrandRepository;
import sit.int204.practice.models.Brand;

import java.util.List;
@CrossOrigin(origins = {"http://52.253.91.116"}) 
//@CrossOrigin(origins = {"http://localhost:8080/"}) 
@RestController
public class BrandController {
	@Autowired
	BrandRepository brandrepository;
	
	 @GetMapping("/Brand/{Brand_id}")
	    public Brand show(@PathVariable long Brand_id) {
	        return brandrepository.findById(Brand_id).orElse(null);
	    }
	 @GetMapping("/Brand")
	    public List<Brand> allBrand() {
	        return brandrepository.findAll(PageRequest.of(0,12)).getContent();
	    }
//	 @PostMapping("/Brand")
//	  public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
//	   
//		 Brand _brand = brandrepository.save(new Brand(brand.getBrand_id(),brand.getBrand_Name()));
//		 return new ResponseEntity<>(_brand, HttpStatus.CREATED);
//	    
//	  }
//	 
}
