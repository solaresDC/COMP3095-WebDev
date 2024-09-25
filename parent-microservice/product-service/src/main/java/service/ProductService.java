package service;

import dto.ProductRequest;
import dto.ProductResponse;
import model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductService{
    ProductResponse createProduct(ProductRequest ProductRequest);
    List<ProductResponse> getAllProducts();
    String updateProduct(String id, ProductRequest productRequest);

    void deleteProduct(String id);
}
