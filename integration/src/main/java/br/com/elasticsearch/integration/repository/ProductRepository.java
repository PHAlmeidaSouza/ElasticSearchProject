package br.com.elasticsearch.integration.repository;

import br.com.elasticsearch.integration.document.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product, String> {
    Page<Product> findByNameContaining(String category, Pageable pageable);
}
