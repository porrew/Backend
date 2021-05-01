package sit.int204.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.practice.repositories.PraticeRepository;
import sit.int204.practice.repositories.ProductsJpaRepository;
import sit.int204.practice.exceptions.ExceptionResponse;
import sit.int204.practice.exceptions.SurveyException;
import sit.int204.practice.models.Pratice;
import sit.int204.practice.models.Products;
import sit.int204.practice.models.Survey;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
public class PraticeController {
	 @Autowired
	    PraticeRepository praticerepository;
	
	 @GetMapping("/Pratice/{code}")
	    public Pratice show(@PathVariable String code) {

	        return praticerepository.findById(code).orElse(null);
	    }
	 
	 @GetMapping("/Pratice")
	    public List<Pratice> allPratice() {
	        return praticerepository.findAll(PageRequest.of(0,12)).getContent();
	    }
	 @DeleteMapping("/Pratice/delete/{code}")
	    public ResponseEntity<HttpStatus> delete(@PathVariable String code) {
	        praticerepository.deleteById(code);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	 
	 @PutMapping("/Pratice/{code}")
	 	public ResponseEntity<Pratice> replaceCode(@RequestBody Pratice newpratice, @PathVariable(value = "code") String code) {
		
		 Pratice pratice = praticerepository.findById(code).orElseThrow(); 
		 pratice.setName(newpratice.getName());
		 pratice.setDesc(newpratice.getDesc());
		 final Pratice updateid = praticerepository.save(pratice);
		 return ResponseEntity.ok(updateid);	    
	 }
	 
	 @PostMapping("/Pratice")
	 public  Pratice createPratice( @RequestBody Pratice pratice) {
		 return praticerepository.save(pratice);
	 }

	 
	 
	  }
	 
	

