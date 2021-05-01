package sit.int204.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.practice.models.Products;
import sit.int204.practice.repositories.ProductsJpaRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
public class ProductsRestController {
    @Autowired
    ProductsJpaRepository productsJpaRepository;

    @GetMapping("/products/{code}")
    public Products show(@PathVariable String code) {

        return productsJpaRepository.findById(code).orElse(null);
    }

    @GetMapping("/products")
    public List<Products> allProducts() {
        return productsJpaRepository.findAll(PageRequest.of(0,12)).getContent();
    }
}
