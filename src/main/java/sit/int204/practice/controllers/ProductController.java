package sit.int204.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import antlr.StringUtils;
import sit.int204.practice.models.Brand;
import sit.int204.practice.models.Color;
import sit.int204.practice.models.Product;
import sit.int204.practice.repositories.ProductRepository;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.util.List;
import sit.int204.practice.repositories.*;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
public class ProductController {
	@Autowired
	ProductRepository productrepository;

	
	 @GetMapping("/Product/{product_id}")
	    public Product showProduct(@PathVariable long product_id) {
	        return productrepository.findById(product_id).orElse(null);
	    }
	 
	 @GetMapping("/Product")
	    public List<Product> allProduct() {
	        return productrepository.findAll(PageRequest.of(0,24)).getContent();
	    }
	 @DeleteMapping("/Product/delete/{product_id}")
	    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable long product_id) {
		 productrepository.deleteById(product_id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	 
	 @PutMapping("/Product/{product_id}")
	 	public ResponseEntity<Product> replaceProduct(@RequestBody Product newproduct, @PathVariable(value = "product_id") long product_id) {
		
		 Product product = productrepository.findById(product_id).orElseThrow(); 
		 product.setProduct_Name(newproduct.getProduct_Name());
		 product.setDescription(newproduct.getDescription());
		 product.setPrice(newproduct.getPrice());
		 product.setDate(newproduct.getDate());
		 product.setPath(newproduct.getPath());
		 final Product updateid = productrepository.save(product);
		 return ResponseEntity.ok(updateid);	    
	 }
	 
	 @PostMapping("/Product")
	  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		 Product _product = productrepository.save(product);
		 return new ResponseEntity<>(_product, HttpStatus.CREATED);
	    
	  }
	 	
	 @PostMapping(value = "/users/save")
	    public ResponseEntity<Product> saveUser(@RequestParam("file") Product product,
	            @RequestParam("image") MultipartFile file) throws IOException {
	         
	        String fileName = file.getOriginalFilename();
	        
	        product.setPath(fileName);
	         
	        Product savedUser = productrepository.save(product);
	 
	        return new ResponseEntity<>(savedUser,HttpStatus.OK);
	    }
	
	
	
}
