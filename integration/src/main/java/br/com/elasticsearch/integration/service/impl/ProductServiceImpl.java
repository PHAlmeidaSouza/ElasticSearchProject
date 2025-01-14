package br.com.elasticsearch.integration.service.impl;

import br.com.elasticsearch.integration.document.Product;
import br.com.elasticsearch.integration.repository.ProductRepository;
import br.com.elasticsearch.integration.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product, String id) {
        Product newProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        newProduct.setId(id);
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setQuantity(product.getQuantity());
        newProduct.setPrice(product.getPrice());
        productRepository.save(newProduct);
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findByNameContaining(String name) {
        return productRepository.findByNameContaining(name, PageRequest.of(0, 10));
    }
}
