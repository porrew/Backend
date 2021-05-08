package sit.int204.practice.controllers;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;

import sit.int204.practice.models.Brand;
import sit.int204.practice.models.Color;
import sit.int204.practice.models.Product;
import sit.int204.practice.repositories.ProductRepository;
import sit.int204.service.FileUploadUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import sit.int204.practice.repositories.*;
import org.springframework.http.MediaType;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
public class ProductController {
	@Autowired
	ProductRepository productrepository;

	
	 @GetMapping("/Product/{product_id}")
	    public Product showProduct(@PathVariable long product_id) {
	        return productrepository.findById(product_id).orElse(null);
	    }
	 

	  @RequestMapping(value = "/Product/image/{product_id}/{path}", method = RequestMethod.GET,produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
	  
	    public ResponseEntity<InputStreamResource> getImage(@PathVariable String path,@PathVariable long product_id) throws IOException {
	        var imgFile = new ClassPathResource("/image/" + product_id + "/" + path);
	        return  ResponseEntity
	                .ok()
	                .body(new InputStreamResource(imgFile.getInputStream()));
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
	 	
	 @PostMapping(value = "/Product/multi", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	    public ResponseEntity<Product> saveUser(
	    		@RequestParam(value = "file")MultipartFile file,
	            @RequestPart Product product) throws IOException {
	        String fileName = file.getOriginalFilename();
	        product.setPath(fileName);
	        Product savedUser = productrepository.save(product);
	        
	        String uploadDir = "src/main/resources/image/" + savedUser.getProduct_id();
	        
	        FileUploadUtil.saveFile(uploadDir, fileName, file);    
	        return new ResponseEntity<>(savedUser,HttpStatus.OK);

	    }
	 
	 
	
	
	
	
}
