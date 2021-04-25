//package controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import model.*;
//import respository.WebRespository; 
//
//@CrossOrigin(origins = "http://localhost:8081")
//@RestController
//@RequestMapping("/api")
//public class WebController {
//	
//	@Autowired
//	WebRespository webrepository;
//	
//	@GetMapping("/tutorials")
//	  public ResponseEntity<List<Webmodel>> getAllWebmodel(@RequestParam(required = false) String title) {
//		 try {
//		      List<Webmodel> webmodels = new ArrayList<Webmodel>();
//
//		      if (title == null)
//		    	  webrepository.findAll().forEach(webmodels::add);
//		      else
//		    	  webrepository.findByTitleContaining(title).forEach(webmodels::add);
//
//		      if (webmodels.isEmpty()) {
//		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		      }
//
//		      return new ResponseEntity<>(webmodels, HttpStatus.OK);
//		    } catch (Exception e) {
//		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		    }
//	    
//	  }
//
//	  @GetMapping("/tutorials/{id}")
//	  public ResponseEntity<Webmodel> getWebmodelById(@PathVariable("id") long id) {
//		  Optional<Webmodel> webmodelData = webrepository.findById(id);
//
//		    if (webmodelData.isPresent()) {
//		      return new ResponseEntity<>(webmodelData.get(), HttpStatus.OK);
//		    } else {
//		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		    }
//	   
//	  }
//	  
//	  
//
//	  @PostMapping("/tutorials")
//	  public ResponseEntity<Webmodel> createTutorial(@RequestBody Webmodel webmodel) {
//		  try {
//			  Webmodel _webmodel = webrepository
//		          .save(new Webmodel(webmodel.getImage(), webmodel.getImage(), webmodel.getImage()));
//		      return new ResponseEntity<>(_webmodel, HttpStatus.CREATED);
//		    } catch (Exception e) {
//		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		    }
//	   
//	  }
//
//	  @PutMapping("/tutorials/{id}")
//	  public ResponseEntity<Webmodel> updateWebmodel(@PathVariable("id") long id, @RequestBody Webmodel webmodel) {
//		  Optional<Webmodel> webmodelData = webrepository.findById(id);
//
//		    if (webmodelData.isPresent()) {
//		    	Webmodel _webmodel = webmodelData.get();
//		    	_webmodel.setImage(webmodel.getImage());
//		    	_webmodel.setDesc(webmodel.getDesc());
//		    	_webmodel.setName(webmodel.getName());
//		      return new ResponseEntity<>(webrepository.save(_webmodel), HttpStatus.OK);
//		    } else {
//		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		    }
//	   
//	  }
//
//	  @DeleteMapping("/tutorials/{id}")
//	  public ResponseEntity<HttpStatus> deleteWebmodel(@PathVariable("id") long id) {
//		  try {
//			  webrepository.deleteById(id);
//		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		    } catch (Exception e) {
//		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		    }
//	    
//	  }
//
//	  @DeleteMapping("/tutorials")
//	  public ResponseEntity<HttpStatus> deleteAllWebmodel() {
//		  try {
//			  webrepository.deleteAll();
//		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		    } catch (Exception e) {
//		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		    }
//	    
//	  }
//
////	  @GetMapping("/tutorials/published")
////	  public ResponseEntity<List<Webmodel>> findByPublished() {
////		  try {
////		      List<Webmodel> tutorials = webrepository.findByPublished(String );
////
////		      if (tutorials.isEmpty()) {
////		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
////		      }
////		      return new ResponseEntity<>(tutorials, HttpStatus.OK);
////		    } catch (Exception e) {
////		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
////		    }
////		  }
//	  
//	  }
//	
//	
//
