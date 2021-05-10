package sit.int204.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.practice.repositories.ColorRepository;
import sit.int204.practice.models.Color;

import java.util.List;
@CrossOrigin(origins = {"http://52.253.91.116"})
@RestController
public class ColorController {
	@Autowired
	ColorRepository colorrepository;
	
	 @GetMapping("/Color/{Color_id}")
	    public Color show(@PathVariable long Color_id) {
	        return colorrepository.findById(Color_id).orElse(null);
	    }
	 @GetMapping("/Color")
	    public List<Color> allBrand() {
	        return colorrepository.findAll(PageRequest.of(0,12)).getContent();
	    }
}
