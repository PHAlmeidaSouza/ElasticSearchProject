package br.com.elasticsearch.integration.controller;

import br.com.elasticsearch.integration.document.Product;
import br.com.elasticsearch.integration.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Product product, @PathVariable String id) {
        productService.updateProduct(product, id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/name/{name}")
    public Page<Product> findByNameContaining(@PathVariable String name) {
        return productService.findByNameContaining(name);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/id/{id}")
    public Product findById(@PathVariable String id) {
        return productService.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Iterable<Product> findAll() {
        return productService.findAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        productService.deleteProduct(id);
    }

}
