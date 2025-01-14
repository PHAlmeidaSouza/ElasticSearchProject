package br.com.elasticsearch.integration.service;

import br.com.elasticsearch.integration.document.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Product createProduct(Product product);
    void updateProduct(Product product, String id);
    Product findById(String id);
    Iterable<Product> findAll();
    void deleteProduct(String id);
    Page<Product> findByNameContaining(String name);
}
