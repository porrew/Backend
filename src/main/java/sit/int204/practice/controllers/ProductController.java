package sit.int204.practice.controllers;


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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import sit.int204.practice.models.Product;
import sit.int204.practice.repositories.ProductRepository;
import sit.int204.service.FileUploadUtil;
import java.io.IOException;
import java.util.List;
import org.springframework.http.MediaType;
//@CrossOrigin(origins = {"http://localhost:8080/"}) 
@CrossOrigin(origins = {"http://52.253.91.116"})
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
		  try {
	        var imgFile = new ClassPathResource("/image/" + product_id + "/" + path);
	        return  ResponseEntity
	                .ok()
	                .body(new InputStreamResource(imgFile.getInputStream()));}
		  catch (Exception e) {
			  throw new IOException("Could not save Data");
		}
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
	 	public ResponseEntity<Product> replaceProduct(@RequestBody Product newproduct,
	 			@PathVariable(value = "product_id") long product_id)  throws IOException {
		 try {
		 Product product = productrepository.findById(product_id).orElseThrow(); 
		 product.setProduct_Name(newproduct.getProduct_Name());
		 product.setDescription(newproduct.getDescription());
		 product.setPrice(newproduct.getPrice());
		 product.setDate(newproduct.getDate());
		 product.setPath(newproduct.getPath());
		 final Product updateid = productrepository.save(product);
		 return ResponseEntity.ok(updateid);}	
		 catch (Exception e) {
			 throw new IOException("Could not save Data");
		}
	 }
	 
//	 @PutMapping("/Product/{product_id}")
//	 	public ResponseEntity<Product> replaceProduct(
//	 			@RequestPart(value = "file",required=false)MultipartFile file,
//	 			@RequestPart Product newproduct,
//	 			@RequestPart(value = "product") String product_,
//	 			@PathVariable(value = "product_id") long product_id) 
//	 					throws IOException {
//		 try {
//		 ObjectMapper map = new ObjectMapper();
//		 Product prod = map.readValue(product_, Product.class);
//		 Product product = productrepository.findById(product_id).orElseThrow(); 
//		 product.setProduct_Name(newproduct.getProduct_Name());
//		 product.setDescription(newproduct.getDescription());
//		 product.setPrice(newproduct.getPrice());
//		 product.setDate(newproduct.getDate());
//		 product.setPath(newproduct.getPath());
//		 final Product updateid = productrepository.save(product);
//		 return ResponseEntity.ok(updateid);}	
//		 catch (Exception e) {
//			 throw new IOException("Could not save Data");
//		}
//	 }
	 
//	 @PostMapping("/Product")
//	  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
//		 Product _product = productrepository.save(product);
//		 return new ResponseEntity<>(_product, HttpStatus.CREATED);
//	    
//	  }
	 	
	 @PostMapping(value = "/Product/multi"
//			 , consumes = MediaType.MULTIPART_FORM_DATA_VALUE
			 )
	    public ResponseEntity<Product> saveUser(
	    		@RequestPart(value = "file",required=false)MultipartFile file,
	            @RequestPart(value = "product") String product_
	    		) throws IOException {
		 try {
		 	ObjectMapper map = new ObjectMapper();
		 	Product prod = map.readValue(product_, Product.class);
	        String fileName = file.getOriginalFilename();
	        Product savedProd = productrepository.save(prod);  
	        String uploadDir = "src/main/resources/image/" + savedProd.getProduct_id();    
	        FileUploadUtil.saveFile(uploadDir, fileName, file); 
	        return new ResponseEntity<>(savedProd, HttpStatus.CREATED);}
	        catch (Exception e) {
	        	throw new IOException("Could not save Data");
			}
	 }
	    
	 
	 @PutMapping(value = "/Product/multi"
			 )
	    public ResponseEntity<Product> putUser(
	    		@RequestPart(value = "file",required=false)MultipartFile file,
	            @RequestPart(value = "product") String product_, 
	            @PathVariable(value = "product_id") long product_id
	    		) throws IOException {
		 try {
		 	ObjectMapper map = new ObjectMapper();
		 	Product prod = map.readValue(product_, Product.class);
	        String fileName = file.getOriginalFilename();
	        Product savedProd = productrepository.save(prod);  
	        String uploadDir = "src/main/resources/image/" + savedProd.getProduct_id();    
	        FileUploadUtil.saveFile(uploadDir, fileName, file); 
	        Product product = productrepository.findById(product_id).orElseThrow(); 
			product.setProduct_Name(savedProd.getProduct_Name());
			product.setDescription(savedProd.getDescription());
			product.setPrice(savedProd.getPrice());
			product.setDate(savedProd.getDate());
			product.setPath(savedProd.getPath());
			final Product updateid = productrepository.save(product);
	        return new ResponseEntity<>(updateid, HttpStatus.CREATED);}
	        catch (Exception e) {
	        	throw new IOException("Could not save Data");
			}

	    }
	 
	
	
	
	
}
